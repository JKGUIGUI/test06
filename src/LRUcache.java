import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUcache<K,V> extends LinkedHashMap<K,V> {
    private  int size;

    public LRUcache(int size) {
        super(size,0.75F,true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > size;
    }
}
