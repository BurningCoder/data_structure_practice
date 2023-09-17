import java.util.NoSuchElementException;

public class bst<Key extends Comparable<Key>,Value> extends UR_BST<Key, Value> {
    private treeNode<Key,Value> head;
    private int size = 0;
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
         return size;
    }

    @Override
    public boolean contains(Key key) {
        if(key == null) throw new IllegalArgumentException();
        else{
            treeNode<Key,Value> curNode = head;
            while(curNode != null){
                if( curNode.getKey().equals(key)) return true;
                else if(curNode.getKey().compareTo(key) > 0){
                    curNode = curNode.getLeft();
                }
                else{
                    curNode = curNode.getRight();
                }
            }
            return false;
        }
    }

    @Override
    public Value get(Key key) {
        if(key == null) throw new IllegalArgumentException();
        else{
            treeNode<Key, Value> curNode = head;
            while(curNode != null){
                if(curNode.getKey().equals(key)) return curNode.getValue();
                else if( curNode.getKey().compareTo(key) > 0){
                    curNode = curNode.getLeft();
                }
                else{
                    curNode = curNode.getRight();
                }
            }
            return null;
        }
    }

    @Override
    public void put(Key key, Value val) {
        if(key == null) throw new IllegalArgumentException();
        else {
            treeNode<Key,Value> newNode = new treeNode<>(key,val,null,null);
            if(head == null){
                head = newNode;
                size ++;
                return;
            }
            treeNode<Key,Value> curNode = head;
            while(curNode != null){
                if(newNode.getKey().compareTo(curNode.getKey()) < 0){
                    if(curNode.getLeft() == null){
                        curNode.setLeft(newNode);
                        size ++;
                        return;
                    }
                    curNode = curNode.getLeft();
                }
                else {
                    if(curNode.getRight() == null){
                        size ++;
                        curNode.setRight(newNode);
                        return;
                    }
                    curNode = curNode.getRight();
                }
            }
        }
    }

    @Override
    public void deleteMin() {
        if(head == null) throw new NoSuchElementException();
        else{
            treeNode<Key,Value> minNode = head, parent = null;
            while(minNode.getLeft() != null){
                parent = minNode;
                minNode = minNode.getLeft();
            }
            if(minNode.getRight() != null){
                if(parent == null) head = minNode.getRight();
                else parent.setLeft(minNode.getRight());
            }
            else{
                if(parent == null) head = null;
                else{
                    parent.setLeft(null);
                }
            }
            size --;
        }
    }

    @Override
    public void deleteMax() {
        if(head == null) throw new NoSuchElementException();
        else{
            treeNode<Key,Value> maxNode = head, parent = null;
            while(maxNode.getRight() != null){
                parent = maxNode;
                maxNode = maxNode.getRight();
            }
            if(maxNode.getLeft() != null){
                if(parent == null) head = maxNode.getLeft();
                else parent.setRight(maxNode.getLeft());
            }
            else{
                if(parent == null) head = null;
                else parent.setRight(null);
            }
            size --;
        }
    }

    @Override
    public void delete(Key key) {
        if(key == null) throw new IllegalArgumentException();
        else{
            treeNode<Key,Value> curNode = head, parent = null;
            while(curNode != null){
                if(curNode.getKey().equals(key)){
                    if(curNode.getLeft() == null && curNode.getRight() == null){
                        if(parent == null){
                            head = null;
                        }
                        else if(parent.getLeft() != null && parent.getLeft() == curNode){
                            parent.setLeft(null);
                        }
                        else {
                            parent.setRight(null);
                        }
                        size --;
                        return;
                    }
                    else if(curNode.getLeft() == null){
                        if(parent == null) {
                            head = curNode.getRight();
                        }
                        else if(parent.getLeft() != null && parent.getLeft() == curNode ){
                            parent.setLeft(curNode.getRight());
                        }
                        else{
                            parent.setRight(curNode.getRight());
                        }
                        size --;
                        return;
                    }
                    else if(curNode.getRight() == null){
                        if(parent == null) {
                            head = curNode.getLeft();
                        }
                        else if(parent.getLeft() != null && parent.getLeft() == curNode ){
                            parent.setLeft(curNode.getLeft());
                        }
                        else{
                            parent.setRight(curNode.getLeft());
                        }
                        size --;
                        return;
                    }
                    else{
                        treeNode<Key,Value> suc = curNode.getRight();
                        while(suc.getLeft() != null){
                            suc = suc.getLeft();
                        }
                        Key tmpKey = suc.getKey();
                        Value tmpValue = suc.getValue();
                        delete(tmpKey);
                        curNode.setKey(tmpKey);
                        curNode.setValue(tmpValue);
                    }
                }
                else{
                    parent = curNode;
                    if(curNode.getKey().compareTo(key) > 0) {
                        curNode = curNode.getLeft();
                    }
                    else {
                        curNode = curNode.getRight();
                    }
                }
            }

        }
    }

    @Override
    public Iterable<Key> keys() {
        return new bstIterator<Key,Value>(head);
    }

    @Override
    public int height() {
        return getHigh(head);
    }
    private int getHigh(treeNode<Key,Value> node){
        if(node == null) return -1;
        int left = getHigh(node.getLeft());
        int right = getHigh(node.getRight());
        return 1 + Math.max(left,right);
    }

    @Override
    public Iterable<Key> levelOrder() {
        return new levelIterator<>(head);
    }
    public treeNode<Key,Value> getHead(){
        return head;
    }

}
