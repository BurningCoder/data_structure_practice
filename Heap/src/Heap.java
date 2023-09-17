public class Heap<E extends Comparable<E>> implements UR_Heap<E>{
    private Comparable[] mainArray;
    private int size, capacity;
    Heap(int cap){
        capacity = cap;
        mainArray = new Comparable[cap];
        size = 0;
    }
    Heap(E[] inputArray){
        mainArray = inputArray;
        capacity = inputArray.length;
        size = inputArray.length;
        heapify();

    }
    Heap(){
        capacity = 10;
        size = 0;
    }
    @Override
    public void insert(E item) {
        if(size == capacity) resize();
        mainArray[size] = item;
        bubble_up(size);
        size ++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public E deleteMin() {
        if(isEmpty()) return null;
        E x= (E)mainArray[0];
        mainArray[0] = mainArray[--size];
        bubble_down(0,size-1);
        return x;
    }
    private void heapify(){
        int arraySize = size;
        for(int i = arraySize / 2 -1; i >=0 ; i --){
            bubble_down(i,size - 1);
        }
    }

    private void bubble_up(int index){
        int curPos = index, parentPos = (curPos - 1) /2;
        while ( parentPos >= 0 && mainArray[curPos].compareTo((E) mainArray[parentPos]) < 0){
            swap(curPos,parentPos);
            curPos = parentPos;
            parentPos = (curPos - 1) /2;
        }
    }
    private void bubble_down(int index, int lastIndex){
        Comparable curVal = mainArray[index];
        int childIndex = index * 2 + 1, curIndex = index;
        while(childIndex <= lastIndex){
            Comparable minVal = curVal;
            int minIndex = -1;
            for(int i = 0; i < 2 && childIndex + i <= lastIndex; i++){
                if(minVal.compareTo(mainArray[childIndex + i]) > 0){
                    minVal = mainArray[childIndex + i];
                    minIndex = childIndex + i;
                }
            }
            if( minVal.equals(curVal)) return;
            swap(minIndex,curIndex);
            curIndex = minIndex;
            childIndex = minIndex * 2 + 1;
        }
    }
    public void printHeap(){
        for(int i = 0; i < size; i++){
            if(mainArray[i] != null){
                System.out.println(mainArray[i]);
            }
        }
    }
    private void swap(int x, int y){
        Comparable tmp = mainArray[x];
        mainArray[x] = mainArray[y];
        mainArray[y] = tmp;
    }
    private void resize(){
        int newCap = capacity * 2;
        Comparable[] newArray = new Comparable[newCap];
        for(int i = 0; i < capacity; i ++){
            newArray[i] = mainArray[i];
        }
        mainArray = newArray;
        capacity = newCap;
    }
}
