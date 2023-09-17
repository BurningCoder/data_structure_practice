import java.security.Key;

public class test {


    public static void main(String[] args) {
        hashTable<String,String> x = new hashTable<>(1);
        x.put("10","22");
        x.put("11","23");
        x.put("12","24");
        x.put("13","25");
        x.put("14","26");
        x.put("17","20");
        x.put("18","30");
        x.put("22","36");
        x.put("23","42");
        x.put("25","41");
        x.put("26","40");
        x.put("27","32");
        for(Object y: x.keys()){
            System.out.println(x.get((String) y));
        }
        System.out.println( "18 "+x.get("18"));

        x.delete("27");
        System.out.println("is 27 exists "+ x.contains("27"));
        for(Object y: x.keys()){
            System.out.println(x.get((String) y));
        }
    }
}
