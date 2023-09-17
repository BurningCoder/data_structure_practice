
import java.util.Iterator;

public class arrayListIterator<E> implements Iterator<E> {
    E[] curList;
    private int cur = 0;
    private int length;
    arrayListIterator(E[] inputList){
        curList = inputList;
    }
    @Override
    public boolean hasNext() {
        if(cur + 1 == curList.length) return false;
        return curList[cur] != null;
    }
    @Override
    public E next() {
        E ans = curList[cur];
        cur++;
        return ans;
    }
}
