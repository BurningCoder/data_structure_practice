import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        IO a = new IO("input.txt");
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        for(int i = 0; i < 4; i ++){
            String x = a.readLine();
            if(i == 0){
                String[] array = x.split(" ");
                for(int j = 0; j < array.length; j++){
                    integerArrayList.add(Integer.parseInt(array[j]));
                }
            }
            if(i == 1){
                String[] array = x.split(" ");
                for(int j = 0; j < array.length; j++){
                    doubleArrayList.add(Double.parseDouble(array[j]));
                }
            }
        }
        for (Integer integer : integerArrayList) {
            System.out.println(integer);
        }
        for(Double y: doubleArrayList){
            System.out.println(y);
        }
    }
}
