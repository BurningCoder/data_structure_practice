
import java.util.Iterator;
import java.util.NoSuchElementException;

public class linkedListIterator<E> implements Iterator<E> {
    URNode<E> currentNode;
    URLinkedList<E> wholeList;
    public linkedListIterator(URLinkedList<E> list){
        currentNode = list.getHead();
        wholeList = list;
    }
    @Override
    public boolean hasNext() {

        return currentNode != null;
    }

    @Override
    public E next() {
        if(!this.hasNext()){
            throw new NoSuchElementException();
        }
        E x =  currentNode.element();
        currentNode = currentNode.next();
        return x;
    }
}
