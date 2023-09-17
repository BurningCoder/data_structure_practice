public class calList<E> {
    public node<E> head = new node<>(null,null);
    public node<E> tail = new node<>(null,null);
    public int size = 0;
    calList(){}
    public boolean isEmpty() {
        return size == 0;
    }

    public final boolean add(Object o) {
        node<E> tmp = new node<>((E)o,null,null);
        if(size == 0){
            head = tmp;
        }
        else{
            tail.setNext(tmp);
            tmp.setPrev(tail);
        }
        tail = tmp;
        size ++;
        return true;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }
    public int indexOf(Object o) {
        node<E> curNode = head;
        int cnt = 0;
        while(curNode != null){
            if(curNode.element() == o) return cnt;
            curNode = curNode.next();
            cnt++;
        }
        return -1;
    }

}
