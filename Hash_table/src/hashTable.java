public class hashTable<Key, Value> extends UR_HashTable<Key,Value> {

    private final int minCap = 4;
    private int capacity = 0;
    private int size = 0, maxCollision = 0;
    private double loadFactor = 0;
    private hashNode<Key,Value>[] mainArray;
    private boolean[] emptySinceStart;
    hashTable(){
        mainArray = new hashNode[minCap];
        emptySinceStart = new boolean[minCap];
        capacity = minCap;
    }
    hashTable(int cap){
        mainArray = new hashNode[minCap];
        emptySinceStart = new boolean[cap];
        capacity = cap;
    }
    @Override
    public void put(Key key, Value val) {
        if(loadFactor > 0.6) resize(capacity * 2);
        hashNode tmp = new hashNode<>(key,val);
        int index = hash(key), n = capacity, cnt = 0;
        while(cnt < n){
            if(mainArray[index] == null){
                mainArray[index] = tmp;
                emptySinceStart[index] = true;
                size++;
                maxCollision = capacity / 3;
                loadFactor = (double) size / (double) capacity;
                if( cnt > maxCollision) resize(capacity*2);
                return;
            }
            index = (index + 1) % n;
            cnt++;
        }

    }
    @Override
    public Value get(Key o) {
        int index = hash(o), n = capacity, cnt = 0;
        while(emptySinceStart[index] && cnt < n){
            if(mainArray[index] != null && mainArray[index].getKey() == o){
                Value ans = (Value) mainArray[index].getVal();
                if( cnt > maxCollision) resize(capacity*2);
                return ans;
            }
            index = (index + 1) %n;
            cnt ++;
        }

        return null;
    }
    @Override
    public void delete(Key o) {
        int index = hash(o), n = capacity, cnt = 0;
        while(emptySinceStart[index] && cnt < n){
            if(mainArray[index] != null && mainArray[index].getKey() == o){
                mainArray[index] = null;
                if( cnt > maxCollision) resize(capacity*2);
                size--;
                return ;
            }
            index = (index + 1) %n;
            cnt ++;
        }
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public boolean contains(Key o) {
        int index = hash(o), n = capacity, cnt = 0;
        while(!emptySinceStart[index] && cnt < n){
            if(mainArray[index] != null && mainArray[index].getKey() == o){
                if( cnt > maxCollision) resize(capacity*2);
                return true;
            }
            index = (index + 1) %n;
            cnt ++;
        }
        return false;
    }
    @Override
    public Iterable keys() {
        return new keyIterator<Key>(mainArray,capacity);
    }
    private void resize(int cap){
        if( cap <= capacity) return;
        int n = capacity;
        capacity = cap;
        hashNode[] newArray = new hashNode[cap];
        emptySinceStart = new boolean[capacity];
        size = 0;
        for(int i = 0; i < n; i++){
            if(mainArray[i] != null){
                hashNode tmp = mainArray[i];
                int cnt = 0, index = hash((Key) tmp.getKey());
                while(cnt <capacity){
                    if(newArray[index] == null){
                        emptySinceStart[index] = true;
                        size ++;
                        newArray[index] = tmp;
                        break;
                    }
                    index = (index + 1) % capacity;
                    cnt++;
                }
            }
        }
        mainArray = newArray;
        maxCollision = capacity / 3;
        loadFactor = (double) size / (double) capacity;
    }
    private int hash(Key key){
        return key.hashCode() % capacity;
    }
}
