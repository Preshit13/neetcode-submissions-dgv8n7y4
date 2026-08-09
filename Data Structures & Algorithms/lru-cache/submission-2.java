class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
            map.remove(key);
        }

        if(map.size() == capacity){
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        insert(newNode);
        map.put(key, newNode);
    }
}
