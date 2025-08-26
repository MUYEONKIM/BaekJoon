import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] price = br.readLine().split(" ");

    int[] visit = new int[101];
    int solve = 0;

    for(int i=0; i < 3; i++) {
      String[] time = br.readLine().split(" ");
      int start = Integer.parseInt(time[0]);
      int end = Integer.parseInt(time[1]);

      for (int startTime = start; startTime < end; startTime++) {
        visit[startTime] += 1;
      }
    }

    for (int count: visit) {
      if (count == 1) {
        solve += Integer.parseInt(price[0]);
      } else if (count == 2) {
        solve += Integer.parseInt(price[1]) * 2;
      } else if (count == 3) {
        solve += Integer.parseInt(price[2]) * 3;
      }
    }

    System.out.println(solve);
  }
}
