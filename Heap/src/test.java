public class test {
    public static void main(String[] args) {
        Heap<Integer> testInt = new Heap<>(3);
        testInt.insert(10);
        testInt.insert(8);
        testInt.insert(20);
        testInt.insert(11);
        testInt.insert(12);
        testInt.insert(19);
        testInt.insert(1);
        testInt.insert(3);
        testInt.printHeap();
        System.out.println();
        System.out.println(testInt.size());
        Integer[] x = {3,5,11,1,2,9,8,4,7,6};
        Heap<Integer> test1 = new Heap<>(x);
        System.out.println(test1.size());
        while(!test1.isEmpty()){
            System.out.println(test1.deleteMin());
        }
        System.out.println();
        for(int i = 10; i >0; i --){
            test1.insert(i);
        }
        while(!test1.isEmpty()){
            System.out.println(test1.deleteMin());
        }
    }
}
