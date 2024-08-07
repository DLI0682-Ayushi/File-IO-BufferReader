package BufferReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeMultipleFiles {
    public static void main(String[] args) {
        String[] inputFiles = {
                "C:\\Users\\Ayushi.Pundir\\Desktop\\file1.txt",
                "C:\\Users\\Ayushi.Pundir\\Desktop\\file2.txt",
                "C:\\Users\\Ayushi.Pundir\\Desktop\\file3.txt"
        };

        String outputFileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\merged_feedback.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String inputFile : inputFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    System.err.println("Error reading file " + inputFile + ": " + e.getMessage());
                }
            }

            System.out.println("Feedback saga inscribed in " + outputFileName + "!");
        } catch (IOException e) {
            System.err.println("Error writing merged feedback: " + e.getMessage());
        }
    }
}

