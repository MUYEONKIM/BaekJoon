import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] probs = br.readLine().split(" ");

    int cnt = Integer.parseInt(probs[0]);
    long minScore = Long.parseLong(probs[1]);
    long maxScore = Long.parseLong(probs[2]);
    long diffScore = Long.parseLong(probs[3]);
    int sol = 0;
    String[] probArgs = br.readLine().split(" ");
    for(int i=0; i < (1 << cnt); i++) {
      long sum = 0;
      long maxVal =Long.MIN_VALUE;
      long minVal = Long.MAX_VALUE;
      int subSet = 0;

      for (int j =0; j < cnt; j++) {
        if((i & (1 << j)) == 1<<j) {
          long value = Long.parseLong(probArgs[j]);
          sum += value;
          subSet++;
          if(value > maxVal) {
            maxVal = value;
          }
          if(value < minVal) {
            minVal = value;
          }
        }
      }

      if(subSet >0) {
        if (sum <= maxScore && sum >= minScore && (maxVal - minVal) >= diffScore) {
          sol++;
        }
      }
    }
    System.out.println(sol);

  }

}
