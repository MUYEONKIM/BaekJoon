import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cnt = Integer.parseInt(br.readLine());
    ArrayList<BigInteger> sol = new ArrayList<>();

    for(int i=0; i< cnt; i++) {
      String prob = br.readLine().replaceAll("[^0-9]", " ");
      String[] convProb = prob.split(" ");
      for(String q : convProb) {
        if(!q.isEmpty()) {
          BigInteger num = new BigInteger(q);
          sol.add(num);
        }
      }

    }

    Collections.sort(sol);

    for(BigInteger t : sol) {
      System.out.println(t);
    }
  }
}
