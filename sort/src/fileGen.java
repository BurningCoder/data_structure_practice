
import java.io.FileWriter;

public class fileGen {
    public static void addFile(int[] inputArray, String fileName) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        for(int key: inputArray){
            writer.write(key + "\n"+"");
        }
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        int[]test = {1,2,3,4,5};
        addFile(test,"test.txt");
    }
}
