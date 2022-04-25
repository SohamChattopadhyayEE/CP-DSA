// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> itr;
	public PeekingIterator(Iterator<Integer> iterator) {
        
        itr = iterator;
        if(hasNext())
            next = itr.next();
	    
	}
    
	public Integer peek() {
        return next;
	}
    
	@Override
	public Integer next() {
	    Integer curr = next;
        if(itr.hasNext())
            next = itr.next();
        else
            next=null;
        return curr;
	}
	
	@Override
	public boolean hasNext() {
	    return next != null || itr.hasNext();
	}
}
