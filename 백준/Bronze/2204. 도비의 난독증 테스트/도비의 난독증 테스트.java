import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());

    while (count != 0) {
      ArrayList<String> allProblem = new ArrayList<>();
      ArrayList<String> solve = new ArrayList<>();

      for (int i = 0; i < count; i++) {
        String problem = br.readLine();

        allProblem.add(problem.toLowerCase());
        solve.add(problem);
      }

      Collections.sort(allProblem);

      for (String pb : solve) {
        String convPb = pb.toLowerCase();
        if (convPb.equals(allProblem.get(0))) {
          System.out.println(pb);
        }
      }
      count = Integer.parseInt(br.readLine());
    }
  }
}
