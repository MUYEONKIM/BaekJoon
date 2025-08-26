import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] prob = br.readLine().split("");
    for(int i=0; i < prob.length / 2; i++) {
      if(!prob[i].equals(prob[prob.length - i - 1])) {
        System.out.println(0);
        return;
      }
    }
    System.out.println(1);
  }
}