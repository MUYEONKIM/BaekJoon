import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String count = br.readLine();

    int solve = 0;

    for (int i = 0; i < Integer.parseInt(count); i++) {

      String[] prob = br.readLine().split("");
      int count2 = 0;

      Loop1 :
      for (int x = 0; x< prob.length; x++) {
        for (int y = x + 1; y < prob.length; y++) {
          if (prob[x].equals(prob[y])) {
            if (y - x > 1 & !prob[y].equals(prob[y-1])) {
              count2++;
              break Loop1;
            }
          }
        }
      }

      if (count2 == 0 ) {
        solve++;
      }
    }
    System.out.println(solve);
  }
}
