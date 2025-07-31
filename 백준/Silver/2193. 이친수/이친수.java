import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());
    if (count <= 2) {
      System.out.println(1);
      return;
    }

    long[] problem = new long[count];
    problem[0] = 1;
    problem[1] = 1;

    for (int i =2 ; i < count; i++) {
      problem[i] = problem[i-1] + problem[i-2];
    }
    System.out.println(problem[problem.length - 1]);
  }
}
