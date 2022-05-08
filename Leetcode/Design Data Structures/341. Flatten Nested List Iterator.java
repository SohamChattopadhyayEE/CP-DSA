public class NestedIterator implements Iterator<Integer> {
    private List<Integer> flat = new ArrayList<Integer>();
    private int idx = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger itr : nestedList)
            flatten(itr);
    }

    @Override
    public Integer next() {
        return flat.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < flat.size();
    }
    private void flatten(NestedInteger obj){
        if(obj.isInteger()){
            flat.add(obj.getInteger());
            return;
        }
        for(int i=0; i<obj.getList().size(); i++)
                flatten(obj.getList().get(i));
    }
}
