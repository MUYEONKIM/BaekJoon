import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Long>> solveList = new ArrayList<>();
    ArrayList<Long> firstArray = new ArrayList<>();
    for (long i = 1; i<= 30; i++) {
      firstArray.add(i);
    }
    solveList.add(firstArray);

    for (int n = 1 ;n < 30;n++) {
      ArrayList<Long> arrays = new ArrayList<>();

      arrays.add(1L);
      for(int m=1; m < 30; m++) {
        long val = solveList.get(n-1).get(m) + arrays.get(m-1);
        arrays.add(val);
      }

      solveList.add(arrays);
    }

    for (int i = 0; i < count; i++) {
      String[] problem = br.readLine().split(" ");
      int n = Integer.parseInt(problem[0]);
      int m = Integer.parseInt(problem[1]) - n;

      System.out.println(solveList.get(n-1).get(m));
    }
  }
}
