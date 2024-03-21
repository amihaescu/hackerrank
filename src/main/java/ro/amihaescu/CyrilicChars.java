package ro.amihaescu;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CyrilicChars {

  public static void main(String[] args) throws FileNotFoundException {
    byte[] bytes = "milchprodukte-adobestock-маргарита-медведева-485680334".getBytes(StandardCharsets.UTF_8);
    System.out.println(new String(bytes, StandardCharsets.UTF_8));
  }

}
