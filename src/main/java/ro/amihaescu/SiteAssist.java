package ro.amihaescu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SiteAssist {

  private static final String BASE_URL = "https://tomblomfield.com/";
  private static final ConcurrentMap<String, Set<String>> siteMap = new ConcurrentHashMap<>();

  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();
    ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    crawl(BASE_URL, new HashSet<>(), executorService);

    for (String url : siteMap.keySet()) {
      System.out.println(url);
      for (String link : siteMap.get(url)) {
        System.out.println("\t" + link);
      }
    }

    System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms; crawled " + siteMap.size() + " pages");

  }

  private static void crawl(String url, Set<String> visitedUrls, ExecutorService executorService) {
    try {
      Document document = Jsoup.connect(url).get();
      List<String> links = extractLinks(document);
      siteMap.put(url, Set.copyOf(links));
      CompletableFuture.allOf(links.stream()
                                   .filter(s -> !visitedUrls.contains(s))
                                   .map(s -> CompletableFuture.runAsync(() -> crawl(s, visitedUrls, executorService), executorService))
                                   .toArray(CompletableFuture[]::new)).get();
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
  }

  private static List<String> extractLinks(Document document) {
    List<String> links = new ArrayList<>();
    for (Element element : document.select("a[href]")) {
      String absUrl = element.absUrl("href");
      if (absUrl.startsWith(BASE_URL) || absUrl.startsWith("/")) {
        links.add(absUrl);
      }
    }
    return links;
  }
}


