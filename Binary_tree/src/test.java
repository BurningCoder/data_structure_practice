
public class test {
    public static void main(String[] args) {
        bst<Integer,String> testString = new bst<>();
        testString.put(4,"20");
        testString.put(-1,"-10");
        testString.put(10,"100");
        testString.put(2,"10");
        testString.put(5,"30");
        System.out.println(testString.size());
        for(Object x: testString.levelOrder()){
            System.out.println(x);
        }
        testString.delete(10);
        testString.deleteMax();
        System.out.println();
        for(Object x: testString.keys()){
            System.out.println(x);
        }
        System.out.println(testString.size());
        System.out.println("hello");
        System.out.flush();
        System.out.println("hello");
    }
}
