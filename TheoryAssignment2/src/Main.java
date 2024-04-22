import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Define array of problem-solving classes
        DFASimulation[] problems = new DFASimulation[10];
        problems[0] = new Problem1();
        problems[1] = new Problem2();
        problems[2] = new Problem3();
        problems[3] = new Problem4();
        problems[4] = new Problem5();
        problems[9]=new Problem10();


        // Add solutions for the other problems similarly

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("end")) {
                    //bw.write("x\n"); // Mark end of problem input in output file
                    continue;
                }
                int problemNumber = 10;
                while (!(line = br.readLine()).equals("end")) {
                    boolean accepted = problems[problemNumber - 1].isAccepted(line);
                    bw.write(problemNumber + "\n" + accepted + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
