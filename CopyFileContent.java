package FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileContent {
    public static void main(String[] args) {
        String sourceFileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\file1.txt";
        String destinationFileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\file2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Content copied successfully!");
        } catch (IOException e) {
            System.err.println("Error copying content: " + e.getMessage());
        }
    }
}

