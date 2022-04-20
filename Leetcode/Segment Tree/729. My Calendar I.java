/*
Algorithm: 
----------------------------------------------------------------
The fundamental need of this problem is to have an efficient
Data structure which keeps objects sorted and enables fast 
insertion. Which is what is built from the scratch in this
solution. The DS built in here is simply a binary search tree
each node of which holds a interval (start and end dates) 
and returns a boolean based on the fact that if insertion at 
appropriate place is possible. The Tree is so made that each
node of which contains complete information regarding a 
particular interval (the start and the end dates) and points 
towards the left and the right nodes of it. Now building up 
the tree goes like this-
1. If the Tree is null then bild the root node considering the 
first input interval and return `True` since insertion is 
possible.
2. If the start date of the newer node is more than or equal to 
the current node and if the right node of the current node is 
null then place the current node as the right node of it and 
return `True`. 
3. If it is not null then traverse through the Tree recursively 
to find appropriate place where it can be inserted.
4. Similar approach of having the left child is taken when the 
end date is lesser than or equals to the start date of the 
current node. 
5. If none of the above two criterion satisfied then the 
insertion is not possible and hence it returns `False`. 
----------------------------------------------------------------
*/

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
