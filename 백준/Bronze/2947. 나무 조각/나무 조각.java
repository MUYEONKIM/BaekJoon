import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] problem = br.readLine().split(" ");

    int[] convProb = new int[problem.length];

    for (int arg = 0 ; arg < problem.length; arg++) {
      convProb[arg] = Integer.parseInt(problem[arg]);
    }

      for(int i = 0; i < convProb.length - 1; i++) {
        for (int j = 1; j < convProb.length - i; j++) {
          if(convProb[j] < convProb[j-1]) {
            int tempVal = convProb[j-1];
            StringBuilder strbuilder = new StringBuilder();
            convProb[j-1] = convProb[j];
            convProb[j] = tempVal;

            for(int prob: convProb) {
              strbuilder.append(prob + " ");
            }

            System.out.println(strbuilder);
          }
        }
      }

  }
}
