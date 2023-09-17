import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        //test for URLinkedlist

        URLinkedList<String> test1 = new URLinkedList<>();
        URLinkedList<Integer> test2 = new URLinkedList<>();
        ArrayList<String> collection1 = new ArrayList<>();
        ArrayList<String> collection2 = new ArrayList<>();
        ArrayList<String> collection3 = new ArrayList<>();
        collection1.add("a");
        collection1.add("b");
        collection1.add("c");
        collection2.add("x");
        collection2.add("z");
        collection3.add("y");
        collection3.add("z");



        test1.addAll(collection1);
        URLinkedList<String> testString = new URLinkedList<>();
        System.out.println(test1.equals(collection1));
        test1.addAll(6,collection2);
        for(Object x : test1){
            System.out.println(x);
        }
        System.out.println(test1.contains("a"));
        System.out.println(test1.get(2));
        test1.remove(1);
        System.out.println(test1.indexOf("a"));
        System.out.println();
        Object[] y = test1.toArray();
        for(Object x : y)
        {
            System.out.println(x);
        }
        System.out.println();
        Object[] z = {"a","z","d"};

        System.out.println(test1.containsAll(List.of(z)));
        System.out.println();
        test1.addFirst("e");
        test1.addLast("z");
        test1.pollFirst();
        for(Object x : test1)
        {
            System.out.println(x);
        }
        System.out.println(test1.peekLast());

        System.out.println();

        // test for urArrayList
        String[] h = {"g","f","l"};
        String[] j = {"f","a"};
        URArrayList<String> test3 = new URArrayList<>(2);
        test3.add("a");
        test3.add("b");
        test3.add("c");
        for(Object x: test3){
            System.out.println(x);
        }
        System.out.println();
        test3.addAll(1, List.of(h));
        test3.removeAll(List.of(j));
        for(Object x: test3){
            System.out.println(x);
        }
        System.out.println(test3.containsAll(List.of(h)));
        Object[] testArray = test3.toArray();
        for(Object x: testArray){
            System.out.println(x);
        }
        System.out.println(test3.indexOf("l"));
    }
}
