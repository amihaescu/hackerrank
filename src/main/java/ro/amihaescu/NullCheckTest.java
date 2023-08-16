package ro.amihaescu;

public class NullCheckTest {

    private static class DownloadFormatId {
        private Long id;

        public Long getId() {
            return id;
        }
    }

    private static class DownloadFormat {
        private DownloadFormatId id;

        public DownloadFormat(DownloadFormatId id) {
            this.id = id;
        }

        public DownloadFormatId getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        DownloadFormat downloadFormat = new DownloadFormat(new DownloadFormatId());
        System.out.println(Long.valueOf(1L).equals(downloadFormat.getId().getId()) );
    }
}
