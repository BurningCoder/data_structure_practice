import java.util.Iterator;

public class hashIterator<Value> implements Iterator<Value> {
    private hashNode[] mainArray;
    private int curPos, capacity;
    hashIterator(hashNode[] array, int cap){
        mainArray = array;
        curPos = 0;
        capacity = cap;
    }
    @Override
    public boolean hasNext() {
        while(curPos < capacity && mainArray[curPos] == null){
            curPos++;
        }

        return curPos < capacity;
    }

    @Override
    public Value next() {
        Value e = (Value) mainArray[curPos].getVal();
        curPos ++;
        return e;
    }
}
