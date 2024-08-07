package InsurancePolicySystem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Policy {
    private int policyId;
    private String policyHolderName;
    private double policyAmount;
    public Policy(int policyId, String policyHolderName, double policyAmount) {
        this.policyId = policyId;
        this.policyHolderName = policyHolderName;
        this.policyAmount = policyAmount;
    }
    public double getPolicyAmount() {
        return policyAmount;
    }
}

class PolicyManager {
    public static void main(String[] args) {
        String inputFileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\policies.txt";
        String outputFileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\summary.txt";
        int totalPolicies = 0;
        double totalPolicyAmount = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 3) {
                    try {
                        int policyId = Integer.parseInt(fields[0]);
                        String policyHolderName = fields[1];
                        double policyAmount = Double.parseDouble(fields[2]);
                        Policy policy = new Policy(policyId, policyHolderName, policyAmount);
                        totalPolicies++;
                        totalPolicyAmount += policy.getPolicyAmount();
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            writer.write("Total Number of Policies: " + totalPolicies);
            writer.newLine();
            writer.write("Total Policy Amount: " + totalPolicyAmount);

            System.out.println("Summary inscribed in " + outputFileName + "!");
        } catch (IOException e) {
            System.err.println("Error processing policies: " + e.getMessage());
        }
    }
}
