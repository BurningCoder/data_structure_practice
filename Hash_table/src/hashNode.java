
public class hashNode<Key,Value> {
    private final Key key;
    private final Value val;
    hashNode(Key k, Value v){
        key = k;
        val =v;
    }
    public Key getKey(){
        return key;
    }
    public Value getVal(){
        return val;
    }
}

