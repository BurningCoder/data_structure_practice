public class calStack<E>extends calList<E>{
    calStack(){}
    public boolean push(Object o){
        node<E> tmp = new node<>((E) o, null,null);
        if (!isEmpty()) {
            tmp.setNext(head);
        }
        head = tmp;
        size ++;
        return true;
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
    public int size(){
        return size;
    }
}
