package questions.Design_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static volatile LRUCache lruCacheInstance = null;
    private final Node head;
    private final Node tail;
    private final int cacheCapacity;
    private final Map<Integer, Node> cacheMap;

    private LRUCache(int capacity) {
        this.cacheCapacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        cacheMap = new HashMap<>();
    }

    public LRUCache getLruCache(int cacheCapacity) {
        if(lruCacheInstance == null) {
            synchronized (LRUCache.class) {
                if(lruCacheInstance == null) {
                    lruCacheInstance = new LRUCache(cacheCapacity);
                }
            }
        }

        return lruCacheInstance;
    }

    public synchronized int get(int key) {
        Node node = cacheMap.get(key);
        if(node == null) return -1;

        delete(node);
        add(node);

        return node.value;
    }

    public synchronized void put(int key, int value) {
        Node node = cacheMap.get(key);
        if(node != null) {
            delete(node);
            node.value = value;
            cacheMap.put(key, node);
            add(node);
        } else {
            if(cacheMap.size() == cacheCapacity) {
                Node lruNode = tail.prev;
                delete(lruNode);
                cacheMap.remove(lruNode.key);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            cacheMap.put(key, newNode);
            add(newNode);
        }
    }

    private void add(Node node) {
        Node nextNode = head.next;
        node.next = nextNode;
        head.next = node;
        nextNode.prev = node;
        node.prev = head;
    }

    private void delete(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }
}
