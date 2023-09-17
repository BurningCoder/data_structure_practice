public class treeNode<Key extends Comparable<Key>,Value> {
    private Key key;
    private Value value;
    private treeNode<Key,Value> left, right;
    treeNode(Key key, Value value, treeNode<Key,Value> left, treeNode<Key,Value> right){
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public void setKey(Key key){
        this.key = key;
    }
    public void setValue(Value value){
        this.value = value;
    }
    public void setLeft(treeNode<Key,Value> left){
        this.left = left;
    }
    public void setRight(treeNode<Key,Value> right){
        this.right = right;
    }
    public Key getKey(){
        return key;
    }
    public Value getValue(){
        return value;
    }
    public treeNode<Key,Value> getLeft(){
        return left;
    }
    public treeNode<Key,Value> getRight(){
        return right;
    }
}
