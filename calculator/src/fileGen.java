
import java.io.FileWriter;
public class fileGen {
    public static void addFile(String[] inputArray, String fileName) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        for(String key: inputArray){
            writer.write(key + "\n"+"");
        }
        writer.close();
    }
}
