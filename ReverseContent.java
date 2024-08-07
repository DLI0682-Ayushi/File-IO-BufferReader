package FileIO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseContent {
    public static void main(String[] args) {
        String inputFileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\file1.txt";
        String outputFileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\file2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            StringBuilder reversedContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                reversedContent.append(new StringBuilder(line).reverse());
                reversedContent.append(System.lineSeparator());
            }
            writer.write(reversedContent.toString());

            System.out.println("Content reversed and inscribed in " + outputFileName + "!");
        } catch (IOException e) {
            System.err.println("Error reversing content: " + e.getMessage());
        }
    }
}
