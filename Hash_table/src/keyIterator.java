import java.util.Iterator;

public class keyIterator<Key> implements Iterable<Key>,Iterator<Key> {

    private final hashNode[] mainArray;
    private int curPos;
    private final int capacity;
    keyIterator(hashNode[] array, int cap){
        capacity = cap;
        mainArray = array;
        curPos = 0;
    }
    @Override
    public Iterator<Key> iterator() {
        return new keyIterator<>(mainArray,capacity);
    }

    @Override
    public boolean hasNext() {
        while(curPos < capacity && mainArray[curPos] == null){
            curPos++;
        }

        return curPos < capacity;
    }

    @Override
    public Key next() {
        Key e = (Key) mainArray[curPos].getKey();
        curPos ++;
        return e;
    }
}
