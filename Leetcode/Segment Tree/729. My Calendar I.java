class Tree{
    int start, end;
    Tree left, right;
    public Tree(){}
    public Tree(int start, int end){
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }
    public boolean add(Tree node){
        if(node.start >= this.end){
            if(this.right == null){
                this.right = node;
                return true;
            }
            return this.right.add(node);
        }else if(node.end<=this.start){
            if(this.left == null){
                this.left = node;
                return true;
            }
            return this.left.add(node);
        }
        return false;
    }
}

class MyCalendar {
    Tree treeNode;
    public MyCalendar() {
        this.treeNode = new Tree();
    }
    
    public boolean book(int start, int end) {
        if(this.treeNode == null){
            this.treeNode = new Tree(start, end);
            return true;
        }
        return this.treeNode.add(new Tree(start, end));
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
