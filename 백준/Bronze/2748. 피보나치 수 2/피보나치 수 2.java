import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      long initVal = 0;
      long secVal = 1;
      long sol = 1;
      long count = Integer.parseInt(br.readLine());
      long num = 1;

      while (num < count) {
        sol = initVal + secVal;

        initVal = secVal;
        secVal = sol;
        num++;
      };

      System.out.println(sol);
    }

}
