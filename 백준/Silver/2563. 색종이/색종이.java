import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String count = br.readLine();
    boolean[][] extent = new boolean[100][100];
    int sum = 0;

    for (int i = 0; i < Integer.parseInt(count); i++) {
      String[] prob = br.readLine().split(" ");
      int x = Integer.parseInt(prob[0]);
      int y = Integer.parseInt(prob[1]);

      for (int q = x; q < x + 10; q++) {
        for (int w = y; w < y + 10; w++) {
          extent[q][w] = true;
        }
      }
    }

    for (boolean[] row : extent) {
      for (boolean ele : row) {
        if (ele == true ){
          sum += 1;
        }
      }
    }
    System.out.println(sum);
  }
}
