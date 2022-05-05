class MyStack {
    Queue<Integer> front;
    int top;    
    public MyStack() {
        front = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        front.add(x);
        for(int i=1; i<front.size(); i++)
            front.add(front.remove());       
    }
    
    public int pop() {
        return front.poll();
    }
    
    public int top() {
        return front.isEmpty() ? -1 : front.peek();
    }
    
    public boolean empty() {
        return front.isEmpty();
    }
}
