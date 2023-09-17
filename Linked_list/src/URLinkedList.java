import java.io.ObjectStreamException;
import java.util.Collection;
import java.util.Iterator;

public class URLinkedList<E>  implements URList<E>,Iterable<E>{
    private URNode<E> head = new URNode<>(null,null);
    private URNode<E> tail = new URNode<>(null,null);
    private int size = 0;
    URLinkedList(){}
    public boolean add(E o) {
        URNode<E> tmp = new URNode<>(o,null,null);
        if(size == 0){
            head = tmp;
        }
        else{
            tmp.setPrev(tail);
            tail.setNext(tmp);
        }
        tail = tmp;
        size ++;
        return true;
    }
    // add the element at index
    @Override
    public void add(int index, E element) {
        URNode<E> tmp = new URNode<>(element,null,null);
        if(size == 0){
            head = tmp;
            tail = tmp;
        }
        else if( size <= index) {
            tmp.setPrev(tail);
            tail.setNext(tmp);
            tail = tmp;
        }
        else if( index == 0){
            tmp.setNext(head);
            head.setPrev(tmp);
            head = tmp;
        }
        else{
            int cnt = 0;
            URNode<E> curNode = head;
            URNode<E> nextNode;
            while(cnt < index - 1){
                curNode = curNode.next();
                cnt++;
            }
            nextNode = curNode.next();
            curNode.setNext(tmp);
            tmp.setNext(nextNode);
            tmp.setPrev(curNode);
            nextNode.setPrev(tmp);
        }
        size ++;
    }

    @Override
    public boolean addAll(Collection c) {
        for (E e : (Iterable<? extends E>) c) {
            add(e);
        }
        return true;
    }

    @Override
    // can be improved into O(n)
    public boolean addAll(int index, Collection c) {
        int cnt = 0;
        for (E e : (Iterable<? extends E>) c) {
            add(cnt + index,e);
            cnt++;
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }

    @Override
    public boolean contains(Object o) {
        URNode<E> curNode = head;
        while(curNode != null){
            if(curNode.element() == o){
                return true;
            }
            curNode = curNode.next();
        }
        return false;
    }

    @Override
    public E get(int index) {
        if(isEmpty() || index >= size) return null;
        URNode<E> curNode = head;
        int cnt = 0;
        while(curNode != null){
            if(cnt == index) return curNode.element();
            curNode = curNode.next();
            cnt ++;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        URNode<E> curNode = head;
        int cnt = 0;
        while(curNode != null){
            if(curNode.element() == o) return cnt;
            curNode = curNode.next();
            cnt++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator iterator() {

        return new linkedListIterator(this);
    }


    // need to ask ta
    @Override
    public E remove(int index) {
        if(isEmpty() || index >= size) return null;
        int cnt = 0;
        URNode<E> curNode = head;
        while(curNode != null)
        {
            if(cnt == index){
                if(cnt == 0)
                {
                    head = curNode.next();
                    curNode.next().setPrev(null);
                }
                else if( cnt == size - 1)
                {
                    System.out.println("here");
                    tail = curNode.prev();
                    curNode.setPrev(null);
                    tail.setNext(null);
                }
                else{
                    URNode<E> preNode = curNode.prev();
                    preNode.setNext(curNode.next());
                    curNode.next().setPrev(preNode);
                }
                size --;
                return curNode.element();

            }
            curNode = curNode.next();
            cnt ++;
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        int cnt = 0;
        URNode<E> curNode = head;
        while(curNode != null)
        {
            if(curNode.element() == o){

                if(cnt == 0) {
                    head = curNode.next();
                    head.setPrev(null);
                }
                else if( cnt == size - 1) {

                    tail = curNode.prev();
                    tail.setNext(null);
                }
                else{
                    URNode<E> preNode = curNode.prev();
                    preNode.setNext(curNode.next());
                    curNode.next().setPrev(preNode);
                }
                size --;
                return true;
            }
            curNode = curNode.next();
            cnt ++;
        }
        return false;
    }

    //need to ask ta
    @Override
    public E set(int index, E element) {
        if(isEmpty() || index >= size) return null;
        int cnt = 0;
        URNode<E> curNode = head;
        while(curNode != null)
        {
            if(cnt == index){
                curNode.setElement( element);
            }
            curNode = curNode.next();
            cnt ++;
        }
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public URList<E> subList(int fromIndex, int toIndex) {
        if(isEmpty() || fromIndex >= size || toIndex >= size) return null;
        int cnt = 0, gap = toIndex -fromIndex;
        URLinkedList<E> list = new URLinkedList<>();
        URNode<E> curNode = head;
        while(curNode != null){
            if( cnt == fromIndex){
                for(int i = 0; i <= gap; i ++) {
                    list.add(curNode.element());
                    curNode = curNode.next();
                }
                return list;
            }
            curNode = curNode.next();
            cnt++;
        }
        return list;
    }

    @Override
    public Object[] toArray() {
        Object[] list = new Object[size];
        int cnt = 0;
        URNode<E> curNode = head;
        while(curNode != null){
            list[cnt] = curNode.element();
            curNode = curNode.next();
            cnt++;
        }
        return list;
    }

    @Override
    public boolean removeAll(Collection c) {
        for(E e: (Iterable<? extends E>) c){
            if(isEmpty()) return false;
            while(contains(e)){
                remove((Object) e);
            }

        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        if(isEmpty()) return false;
        for(E e: (Iterable<? extends E>) c){
            URNode<E> curNode = head;
            boolean flag = false;
            while(curNode != null){
                if( curNode.element() == e)
                {
                    flag = true;
                    break;
                }
                curNode = curNode.next();
            }
            if(!flag) return false;
        }
        return true;
    }
    //tmp method for testing
    public URNode<E> getHead(){
        return head;
    }
    public void addFirst(E e){
        URNode<E> curNode = new URNode<>(e,null,null);
        if(isEmpty()){
            head = curNode;
            tail = curNode;
        }
        else {
            head.setPrev(curNode);
            curNode.setNext(head);
            head = curNode;
        }
        size++;

    }
    public void addLast(E e){
        URNode<E> curNode = new URNode<>(e, null,null);
        if(isEmpty()){
            head = curNode;
            tail = curNode;
        }
        else{
            tail.setNext(curNode);
            curNode.setPrev(tail);
            tail = curNode;
        }
        size ++;
    }
    public E peekFirst(){
        return head.element();
    }
    public E peekLast(){
        return tail.element();
    }
    public E pollFirst(){
        if(isEmpty()) return null;
        E ans = head.element();
        head = head.next();
        head.setPrev(null);
        size --;
        return ans;
    }
    public E pollLast(){
        if(isEmpty()) return null;
        E ans = tail.element();
        tail = tail.prev();
        tail.setNext(null);
        size --;
        return ans;
    }
    @Override
    public boolean equals(Object o){
        for(E e: (Iterable<? extends E>) o){
            URNode<E> curNode = head;
            boolean[] sign = new boolean[size];
            int cnt = 0;
            boolean flag = false;
            while(curNode != null){
                if( curNode.element() == e && !sign[cnt]){
                    flag = true;
                    sign[cnt] = true;
                    break;
                }
                curNode = curNode.next();
                cnt ++;
            }
            if(!flag) return false;
        }
        return true;
    }
}
