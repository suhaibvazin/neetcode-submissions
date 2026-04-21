class LRUCache {
    //doubly linked list
    class Node {
        int value;
        int key;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //cache data
    private final Map<Integer,Node> cache;

    //move recent to head
    private final Node head;
    //remove old from tail
    private final Node tail;
    //max capacity
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {

        if(!this.cache.containsKey(key)){
            return -1;
        }

        //cut the node gracefully from linked list and add right after dummy head
        //get the node
        Node cachedValue = cache.get(key);
        cutFromList(cachedValue);
        addTohead(cachedValue);
        return cachedValue.value;
    }
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node newVal = cache.get(key);
            newVal.value = value;
            cache.put(key,newVal);
            cutFromList(newVal);
            addTohead(newVal);

        }else{
            if(this.cache.size()>=this.capacity){
              //remove from cache and tail  
              Node tail = this.tail.prev;
              cache.remove(tail.key);
              cutFromList(tail);   
            }
            Node newVal = new Node(key,value);
            addTohead(newVal);
            cache.put(key,newVal);
            
        }
        
    }

    private void cutFromList(Node cachedValue){
        //cut
        cachedValue.prev.next = cachedValue.next;
        cachedValue.next.prev = cachedValue.prev;
    }

    private void addTohead(Node cachedValue){
        //add just after dummy head
        cachedValue.next = this.head.next;
        this.head.next.prev = cachedValue;
        cachedValue.prev = head;
        head.next = cachedValue;
    }
}
