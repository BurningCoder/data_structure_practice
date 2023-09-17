import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class bstIterator<Key extends Comparable<Key>,Value> implements Iterator<Key>,Iterable<Key> {
    private Stack<treeNode<Key,Value>> nodeHolder = new Stack<>();
    private final treeNode<Key,Value> currentNode;
    bstIterator(treeNode<Key,Value> node){
        currentNode = node;
        pushing(node);
    }
    private void pushing(treeNode<Key,Value> node){
        while(node != null){
            nodeHolder.push(node);
            node = node.getLeft();
        }
    }
    @Override
    public boolean hasNext() {
        return !nodeHolder.isEmpty();
    }
    @Override
    public Key next() {
        if(!hasNext()) throw new NoSuchElementException();
        else{
            treeNode<Key,Value> curNode = nodeHolder.pop();
            if(curNode.getRight() != null){
                pushing(curNode.getRight());
            }
            return curNode.getKey();
        }
    }

    @Override
    public Iterator iterator() {
        return new bstIterator<Key,Value>(currentNode);
    }
}
