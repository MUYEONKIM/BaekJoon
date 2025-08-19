import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());
    String[][] problems = new String[count][];
;
    for (int i=0; i < count; i++) {
      String[] problem = br.readLine().split(" ");

      problems[i] = problem;
    }

    Arrays.sort(problems, (v1, v2) -> {
      if (Integer.parseInt(v1[3]) > Integer.parseInt(v2[3])) {
        return 1;
      } else if (Integer.parseInt(v1[3]) == Integer.parseInt(v2[3])) {
        if (Integer.parseInt(v1[2]) > Integer.parseInt(v2[2])) {
          return 1;
        } else if (Integer.parseInt(v1[2]) == Integer.parseInt(v2[2])) {
          if (Integer.parseInt(v1[1]) > Integer.parseInt(v2[1])) {
            return 1;
          }
        }
      }
      return -1;
    });

    System.out.println(problems[count -1][0]);
    System.out.println(problems[0][0]);
  }
}
