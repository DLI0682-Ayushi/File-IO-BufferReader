package FileIO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWords {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\file1.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int totalWordCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                totalWordCount += words.length;
            }

            System.out.println("Total words in " + fileName + ": " + totalWordCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

