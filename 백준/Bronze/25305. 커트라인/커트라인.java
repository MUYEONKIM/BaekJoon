import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] prob = br.readLine().split(" ");

    int count = Integer.parseInt(prob[0]);
    int rank = Integer.parseInt(prob[1]);

    String[] problem = br.readLine().split(" ");
    Integer[] convProb = new Integer[count];

    for (int i=0; i < count; i++){
      convProb[i] = Integer.parseInt(problem[i]);
    }

    Arrays.sort(convProb, Collections.reverseOrder());


    System.out.println(convProb[rank - 1]);

  }
}
