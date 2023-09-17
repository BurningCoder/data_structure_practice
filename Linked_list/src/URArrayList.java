
import java.util.Collection;
import java.util.Iterator;

// why the warning keep exist and how to fix that problem
public class URArrayList<E> implements URList<E>, Iterable<E>{
    private E[] mainArray;
    private int length = 0;
    private int allocationSize = 0;
    URArrayList(int x) {
        allocationSize = x;
        mainArray = (E[]) new Object[x];
    }

    @Override
    public boolean add(E o) {
        if(length == allocationSize) {
            reSize();
        }

        mainArray[length] = o;
        length ++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > length + 1) return;
        if(length == allocationSize) reSize();
        for(int i = length ; i > index; i--){
            mainArray[i] = mainArray[i - 1];
        }
        mainArray[index] = element;
        length++;
    }
    @Override
    public boolean addAll(Collection c) {
        for(E e : (Iterable<? extends E>) c){
            if(length == allocationSize) reSize();
            add(e);
        }
        return true;
    }
    @Override
    public boolean addAll(int index, Collection c) {
        if(index < 0 || index > length + 1) return false;
        int cnt = 0;
        for(E e : (Iterable<? extends E>) c){
            if(length == allocationSize) reSize();
            add(cnt + index,e);
            cnt ++;
        }
        return false;
    }
    @Override
    public void clear() {
        mainArray = (E[]) new Object[allocationSize];
        length = 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < length; i++){
            if(mainArray[i] == o) return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if(index >= length) return null;
        return mainArray[index];
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < length; i++){
            if(mainArray[i] == o) return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Iterator iterator() {
        return new arrayListIterator(mainArray);
    }

    @Override
    public E remove(int index) {
        if( index >= length) return null;
        E e = mainArray[index];
        for(int i = index; i < length - 1; i++){
            mainArray[i] = mainArray[i + 1];
        }
        length --;
        mainArray[length] = null;
        return e;
    }

    @Override
    public boolean remove(Object o) {
        if(isEmpty()) return false;
        for(int i = 0; i < length; i ++)
        {
            if(mainArray[i] == o){
                remove(i);
            }
        }
        return true;
    }

    @Override
    public E set(int index, E element) {
        if(index >= length) return null;
        mainArray[index] = element;
        return element;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public URList subList(int fromIndex, int toIndex) {
        if( fromIndex >= length || toIndex >= length) return null;
        URArrayList<E> ans = new URArrayList<>(toIndex - fromIndex + 1);
        return ans;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[length];
        for(int i = 0; i < length; i++){
            a[i] = mainArray[i];
        }
        return a;
    }

    @Override
    public boolean removeAll(Collection c) {
        for(E e : (Iterable<? extends E>) c){
            if(isEmpty()) return false;
            while(contains(e)){
                remove((Object) e);
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for(E e: (Iterable<? extends E>) c){
            boolean flag = false;
            flag = contains(e);
            if(!flag) return false;
        }
        return true;
    }
    @Override
    public boolean equals(Object o){
        for(E e: (Iterable<? extends E>) o){
            boolean flag = false;
            boolean[] sign = new boolean[length];
            for(int i = 0; i < length;i++){
                if(mainArray[i] == e && !sign[i]){
                    sign[i] = true;
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }
        return true;
    }
    private void reSize(){
        int newAllocationSize = allocationSize * 2;
        E[] tmp = (E[]) new Object[newAllocationSize];
        for(int i = 0; i < length; i ++){
            tmp[i] = mainArray[i];
        }
        mainArray = tmp;
        allocationSize = newAllocationSize;
    }
    public void ensureCapacity(int minCapacity){
        if(getCapacity() < minCapacity){
            reSize();
        }
    }
    public int getCapacity(){
        return allocationSize - length;
    }


}
