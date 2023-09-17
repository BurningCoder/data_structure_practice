import java.util.*;

public class levelIterator <Key extends Comparable<Key>,Value> implements Iterable<Key>, Iterator<Key> {
    Queue<treeNode<Key,Value>> nodeHolder = new LinkedList<>();
    treeNode<Key,Value> curNode;
    levelIterator(treeNode<Key,Value> newNode ){

        curNode = newNode;
        if(newNode != null) nodeHolder.add(newNode);
    }
    private void pushing(treeNode<Key,Value> node){
        if(node.getLeft() != null) nodeHolder.add(node.getLeft());
        if(node.getRight() != null) nodeHolder.add(node.getRight());
    }
    @Override
    public Iterator<Key> iterator() {
        return new levelIterator<>(curNode);
    }

    @Override
    public boolean hasNext() {
        return !nodeHolder.isEmpty();
    }

    @Override
    public Key next() {
        if(!hasNext()) throw new NoSuchElementException();
        else {
            treeNode<Key, Value> tmp = nodeHolder.poll();
            pushing(tmp);
            return tmp.getKey();
        }
    }
}
