package BufferReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LargeDataFileProcessing {
    public static void main(String[] args) {
        String inputFileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\transactions.txt";
        String outputFileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\filtered_transactions.txt";
        double thresholdAmount = 1000.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 3) {
                    try {
                        double transactionAmount = Double.parseDouble(fields[2]);
                        if (transactionAmount > thresholdAmount) {

                            writer.write(line);
                            writer.newLine();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            System.out.println("Filtered transactions inscribed in " + outputFileName + "!");
        } catch (IOException e) {
            System.err.println("Error processing transactions: " + e.getMessage());
        }
    }
}

