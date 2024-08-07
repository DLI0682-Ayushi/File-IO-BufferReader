package FileIO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadAndDisplay {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\file1.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
