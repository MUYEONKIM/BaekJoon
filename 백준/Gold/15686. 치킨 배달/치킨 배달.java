import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static int globalmin = 1000000;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] coords = br.readLine().split(" ");

    int N = Integer.parseInt(coords[0]);
    int M = Integer.parseInt(coords[1]);
    ArrayList<Integer[]> homeCoords = new ArrayList<>();
    ArrayList<Integer[]> chickenCoords = new ArrayList<>();
    ArrayList<ArrayList<Integer>> distnace = new ArrayList<>();

    for(int i = 0; i<N; i++) {
      ArrayList<Integer> node = new ArrayList<>();
      graph.add(node);
      String[] prob = br.readLine().split(" ");

      for(int q =0; q< prob.length; q++) {
        int num = Integer.parseInt(prob[q]);

        if (num == 1) {
          Integer[] hmcoord = new Integer[]{i, q};
          homeCoords.add(hmcoord);
        } else if (num == 2) {
          Integer[] chiccoord = new Integer[]{i, q};
          chickenCoords.add(chiccoord);
        }
        graph.get(i).add(num);
      }
    }
    // 굳이 반복문 순회를 다하지말고 인덱스 끼리만 비교하는게 더 빠를듯
    // chiken집 하나당 모든집 비교를 해야된다 ㅎㅎ

    for(Integer[] chickenCoord: chickenCoords) {
        int chickenX = chickenCoord[0];
        int chickenY = chickenCoord[1];
      ArrayList<Integer> distanceSol = new ArrayList<>();

      for(Integer[] homeCoord: homeCoords) {
          int homeX = homeCoord[0];
          int homeY = homeCoord[1];

        int dist = Math.abs(homeX - chickenX) + Math.abs(homeY - chickenY);

        distanceSol.add(dist);
      }
      distnace.add(distanceSol);
    }
    ArrayList<ArrayList<Integer>> newSelect = new ArrayList<>();
    comb(distnace,newSelect , 0, M);

    System.out.println(globalmin);
  }

  // 배열 개에서 인덱스 중 작은것들의 모든 합
  public static void isMin(ArrayList<ArrayList<Integer>> arrs) {
    ArrayList<Integer> minList = new ArrayList<>();
    minList.addAll(arrs.get(0));

    for(ArrayList<Integer> array: arrs) {
      for(int i=0; i<array.size(); i++) {

        int minVal = minList.get(i);
        int newMinVal = array.get(i);
        if (minVal > newMinVal) {
          minList.set(i, newMinVal);
        }
      }
    }
    int sum = 0;
    for(int val : minList) {
      sum += val;
    }

    if(globalmin > sum) {
      globalmin = sum;
    }
  }

  public static void comb(ArrayList<ArrayList<Integer>> arr, ArrayList<ArrayList<Integer>> selected, int startIdx, int m) {
    if (selected.size() == m) {
      isMin(selected);
      return;
    }

    // 백트래킹을 이용한 조합 생성
    for (int i = startIdx; i < arr.size(); i++) {
      selected.add(arr.get(i)); // 현재 요소를 선택
      comb(arr, selected, i + 1, m); // 다음 요소 탐색
      selected.remove(selected.size() - 1); // 백트래킹: 선택한 요소 되돌리기
    }
  }
}
