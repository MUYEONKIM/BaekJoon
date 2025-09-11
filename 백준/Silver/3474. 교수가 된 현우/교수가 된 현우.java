import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cnt = Integer.parseInt(br.readLine());

    for(int i=0; i< cnt ;i++) {
      int prob = Integer.parseInt(br.readLine());
      prime(prob);
    }
  }

  public static void prime(int val) {
    int sol = 0;
    while(val >= 5) {
      int temp = val / 5;
      sol += temp;
      val = temp;
    }
    System.out.println(sol);
  }
}
