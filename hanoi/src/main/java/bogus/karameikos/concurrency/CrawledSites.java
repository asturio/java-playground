package bogus.karameikos.concurrency;

import java.util.ArrayList;
import java.util.List;

public class CrawledSites {
    private List<String> crawledSites = new ArrayList<>();
    private List<String> linkedSites = new ArrayList<>();

    public void add(String site) {
        synchronized (this) {
            if (!crawledSites.contains(site)) {
                linkedSites.add(site);
            }
        }
    }

    public String next() {
        if (linkedSites.isEmpty()) {
            return null;
        }

        synchronized (this) {
            if (!linkedSites.isEmpty()) {
                String s = linkedSites.get(0);
                linkedSites.remove(0);
                crawledSites.add(s);
                return s;
            }
            return null;
        }
    }
}
