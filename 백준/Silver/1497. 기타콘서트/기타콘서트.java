import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static long[] guitarBit;
  static long minVal = Long.MAX_VALUE;
  static long maxVal = Long.MIN_VALUE;
  static int songCnt;
  static int guitarCnt;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] prob = br.readLine().split(" ");

    guitarCnt = Integer.parseInt(prob[0]);
    songCnt = Integer.parseInt(prob[1]);

    guitarBit = new long[guitarCnt];

    for(int i=0; i< guitarCnt; i++) {
      String[] probs = br.readLine().split(" ");
      String[] initProb = probs[1].split("");
      for(int j=0; j <songCnt; j++) {
        if(initProb[j].equals("Y")) {
          guitarBit[i] |= (1L<<j);
        }
      }
    }
    tracking(0,0,0L);
    if(minVal == 0) {
      System.out.println(-1);
      return;
    }
    System.out.println(minVal);

  }

  public static void tracking(int idx, int depth, long initGuitarBit) {
    // 해당 수에서 bit가 몇개 켜져있는지가 y 의 개수가 됨 yyynn > 1,2,4 > bitcount는 3개
    int availGuitar = Long.bitCount(initGuitarBit);
// depth가 2, 5인 놈이 두개 나옴
    // 그럼 뭐랑 비교해야 될까?
    // 2 5 3 중에서 min을 찾아야 되잖아
    // 그럼 max값에서 min
//    System.out.printf("avail %d : depth  %d : initGuitarBit %s \n",availGuitar, depth, Long.toBinaryString(initGuitarBit));
//    if (idx == guitarCnt - 1) {
//      // 그럼 여기서 depth가 0 1 2 3 4가 나오는데
//      // 함수가 종료될때의 depth들 중에서 min을 뽑아야 되는것이다
//      // 함수가 종료될때의 조건이 뭐가 있지?
//      // 아래가 함수의 종료 조건인데 여기서 중요한건 availGuitar가 종료될때 가장 큰 값이다
//      // 그럼 종료조건은 idx가 끝까지 돌거나, bitcount가 다 차거나했는데
//      // 여기서 나온 maxGuitar가 가장 큰 값일 때 depth중 가장 작은 값
//      if(depth < minVal) {
//      }
//      return;
//    }
    if(maxVal == availGuitar) {
      if(minVal > depth) {
        minVal = depth;
      }
    }

    if (availGuitar > maxVal) {
      maxVal = availGuitar;
      minVal = depth;
    }

    if(idx == guitarBit.length || availGuitar == songCnt) {
      return;
    }

    // 현재 기타 선택안했을때
    tracking(idx+1, depth, initGuitarBit);
    // 현재 기타 선택했을때
    tracking(idx+1, depth+1, initGuitarBit | guitarBit[idx]);

  }

}
