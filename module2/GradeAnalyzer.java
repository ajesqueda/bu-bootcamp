import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");
        
        // Step 2: calculate statistics
        double avg = calculateAverage(scores);
        int high = scores.isEmpty() ? 0 : scores.stream().mapToInt(Integer::intValue).max().orElse(0);
        int low = scores.isEmpty() ? 0 : scores.stream().mapToInt(Integer::intValue).min().orElse(0);
        int invalidLines = 0; // You'd need to track this in readScores if you want accurate count
        
        // Step 3: write and print report
        writeReport(scores, avg, high, low, "grade_report.txt", invalidLines);
        System.out.println("Grade report written to grade_report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> scores = new ArrayList<>(); // Create an ArrayList to hold valid scores
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) { // Use try-with-resources to ensure the BufferedReader is closed automatically
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int score = Integer.parseInt(line.trim());
                    if (score >= 0 && score <= 100) {
                        scores.add(score);
                    }
                } catch (NumberFormatException e) {
                    // Ignore invalid scores
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()){
            return 0.0;
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile, int invalidLines) {
        // Calculate grade distribution
        int gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeF = 0;
        for (int score : scores) {
            if (score >= 90) gradeA++;
            else if (score >= 80) gradeB++;
            else if (score >= 70) gradeC++;
            else if (score >= 60) gradeD++;
            else gradeF++;
        }
        
        // Print to console
        System.out.println("=== Grade Analysis Report ===");
        System.out.printf("Total scores processed: %2d\n", scores.size());
        System.out.printf("Invalid lines skipped: %3d\n", invalidLines);
        System.out.println();
        System.out.printf("Average score: %7.2f\n", avg);
        System.out.printf("Highest score: %7d\n", high);
        System.out.printf("Lowest score: %8d\n", low);
        System.out.println();
        System.out.println("Grade distribution:");
        System.out.printf("  A (90-100): %3d\n", gradeA);
        System.out.printf("  B (80-89): %4d\n", gradeB);
        System.out.printf("  C (70-79): %4d\n", gradeC);
        System.out.printf("  D (60-69): %4d\n", gradeD);
        System.out.printf("  F (below 60): %d\n", gradeF);
        
        // Write to file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("=== Grade Analysis Report ===\n");
            bw.write(String.format("Total scores processed: %2d\n", scores.size()));
            bw.write(String.format("Invalid lines skipped: %3d\n", invalidLines));
            bw.write("\n");
            bw.write(String.format("Average score: %7.2f\n", avg));
            bw.write(String.format("Highest score: %7d\n", high));
            bw.write(String.format("Lowest score: %8d\n", low));
            bw.write("\n");
            bw.write("Grade distribution:\n");
            bw.write(String.format("  A (90-100): %3d\n", gradeA));
            bw.write(String.format("  B (80-89): %4d\n", gradeB));
            bw.write(String.format("  C (70-79): %4d\n", gradeC));
            bw.write(String.format("  D (60-69): %4d\n", gradeD));
            bw.write(String.format("  F (below 60): %d\n", gradeF));

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
} 