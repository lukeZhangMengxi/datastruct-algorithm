package structure.cache.least_recently_used;

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);

        assert cache.get(1) == -1;
        assert cache.get(2) == 2;
        assert cache.get(3) == 3;
        assert cache.get(4) == 4;
        assert cache.get(5) == -1;

        System.out.print("Cache works properly!");
    }
}
