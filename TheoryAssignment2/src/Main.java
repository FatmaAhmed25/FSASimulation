import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        DFASimulation[] problems = new DFASimulation[10];
        problems[0] = new Problem1();
        problems[1] = new Problem2();
        problems[2] = new Problem3();
        problems[3] = new Problem4();
        problems[4] = new Problem5();
        problems[5] = new Problem6();
//        problems[6] = new Problem7();
//        problems[7] = new Problem8();
//        problems[8] = new Problem9();
        problems[9] = new Problem10();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                int problemNumber = Integer.parseInt(line.trim());
                bw.write(problemNumber+"\n");
                while (!(line = br.readLine()).toLowerCase().equals("end") ) {
                    boolean accepted = problems[problemNumber - 1].isAccepted(line);
                    if (accepted)
                        bw.write("True" + "\n");
                    else
                        bw.write("False" + "\n");
                }
                bw.write("x\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
