class MyHashMap {
    List<Integer> keys = new ArrayList<Integer>();
    List<Integer> values = new ArrayList<Integer>();
    public MyHashMap() {
        this.keys = keys;
        this.values = values;
    }
    
    public void put(int key, int value) {
        int idx=-1;
        for(int i=0; i<this.keys.size(); i++){
            if(this.keys.get(i)==key){
                idx = i;
                break;
            }
        }
        if(idx==-1){
            this.keys.add(key);
            this.values.add(value);
        }else{
            this.values.set(idx, value);
        }
    }
    
    public int get(int key) {
        int idx = -1;
        for(int i=0; i<this.keys.size(); i++){
            if(this.keys.get(i)==key){
                idx=i;
                break;
            }
        }
        return idx == -1 ? -1 : this.values.get(idx);
    }
    
    public void remove(int key) {
        int idx=-1;
        for(int i=0; i<this.keys.size(); i++){
            if(this.keys.get(i)==key){
                idx=i;
                break;
            }
        }
        if(idx != -1){
            this.keys.remove(idx);
            this.values.remove(idx);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
