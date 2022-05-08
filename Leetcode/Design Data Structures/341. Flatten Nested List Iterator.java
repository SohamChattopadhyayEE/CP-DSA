/*
Algorithm:
----------------------------------------------------------------------------
1. Create a recursive void method (here named as `flatten`) to flatten
   the nested list given as input to the constructor. 
2. To do so bellow steps are to be followed - 
    A. Declare a global List of integer (say `flat`) to hold the values
       of the input nested list.
    B. In that `flatten` method if the input is an integer add that 
       object (Integer type) to the global list `flat`.
    C. If not an integer, iterate through the object and recursively 
       call the method. 
3. In the constructor class, iteratively fill the list `flat` using 
   the method `flatten`.
4. An global integer (say `idx`) to be declared which points to the current
   element of the iterator.
5. For the method `next()`, return the value stored in the list `flat` at 
   index `idx` and increment the value of `idx` by 1.
6. For the method `hasNext()`, return `true` if the value of `idx` is less 
   than the size of the list `flat`, else return `false`.  
----------------------------------------------------------------------------
*/



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
