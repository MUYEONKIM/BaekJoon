import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] prob = br.readLine().split(" ");

    int len = Integer.parseInt(prob[0]);
    int count = Integer.parseInt(prob[1]);
    int sum = 0;
    int maxVal = 0;
    String[] problem = br.readLine().split(" ");

    for (int i = 0; i< count; i++) {
      maxVal += Integer.parseInt(problem[i]);
    }
    sum = maxVal;
    for (int i=0; i< len - count; i++) {
      sum -= Integer.parseInt(problem[i]);
      sum += Integer.parseInt(problem[i + count]);

      if (maxVal <= sum) {
        maxVal = sum;
      }
    }
    bw.write(Integer.toString(maxVal));
    bw.flush();
  }
}
