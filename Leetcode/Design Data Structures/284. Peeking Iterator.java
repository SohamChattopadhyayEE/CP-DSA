/*
Algorithm:
---------------------------------------------------------------------------
1. This data structures simply implements the interface of `Iterator`. 
2. Initiate two global variables such as an Integer (the pointer, say next) 
   and an Iterator (say itr).
3. Assign the input iterator to the global Iterator for the class(itr).
4. Similarly, if the iterator has next then assign it to the global Integer
   (next).
5. For the method peek() return the global variable holding the next value
   of the iterator.
6. If the method next() is called in the main function, the value
   stored in the global pointer (next) is assigned to a local variable 
   (say curr) and set the global pointer to the next of the iterator. 
   At the end return the value stored in the local variable.
7. 
*/




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
