public class calQueue <E>extends calList<E>{
    public boolean push(Object o ){
        return add(o);
    }
    public E pop(){
        if(isEmpty()) return null;
        node<E> curNode = head;
        head = head.next();
        size --;
        return curNode.element();
    }
    public E top(){
        if(isEmpty()) return null;
        return head.element();
    }

}
