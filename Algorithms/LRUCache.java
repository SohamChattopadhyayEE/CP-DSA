class LRUCache {
    class node{
        node next, prev;
        int key, val;
        node(int key, int value){
            this.key=key;
            this.val=value;
            this.next=null;
            this.prev=null;
        }
        node(){
            this.next=null;
            this.prev=null;
        }
    }

    Map<Integer, node>map;
    int cap, MAX_CAP;
    node head, tail;
    public LRUCache(int capacity) {
        MAX_CAP=capacity;
        cap=0;
        map=new HashMap<>();
        head = new node();
        tail = new node();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        __delete(key);
        __insert(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            __delete(key);
            __insert(key, value);
            return;
        }
        __insert(key, value);
    }

    public void __insert(int key, int value){
        cap++;
        if(cap>MAX_CAP)
            __delete();
        
        node n = new node(key, value);
        n.next = head.next;
        n.prev=head;
        head.next.prev=n;
        head.next=n;
        map.put(key, n);
    }
    public void __delete(){
        cap--;
        node n = tail.prev;
        node nPrev = n.prev;
        tail.prev=nPrev;
        nPrev.next=tail;
        map.remove(n.key);
    }
    public void __delete(int key){
        cap--;
        node n=map.get(key);
        node nodePrev = n.prev;
        node nodeNxt = n.next;
        nodePrev.next=nodeNxt;
        nodeNxt.prev=nodePrev;
        map.remove(key); 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
