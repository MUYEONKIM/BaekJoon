import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] prob = br.readLine().split(" ");
    int cnt = Integer.parseInt(br.readLine());
    int sol = 0;

    int firstIdx = 1;
    int idxLen = Integer.parseInt(prob[1]) - 1;
    int lastIdx = firstIdx + idxLen;

    for(int i = 0; i < cnt; i++) {
      int appleIndex = Integer.parseInt(br.readLine());
      if(appleIndex < firstIdx) {
        int difCnt =  Math.abs(appleIndex - firstIdx);
        sol += difCnt;
        firstIdx = appleIndex;
        lastIdx = firstIdx + idxLen;
      } else if (appleIndex > lastIdx) {
        int difCnt =  Math.abs(appleIndex - lastIdx);
        sol += difCnt;
        firstIdx = appleIndex - idxLen;
        lastIdx = appleIndex;
      }
    }
    System.out.println(sol);
  }

}
