import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Integer count = Integer.parseInt(br.readLine());
    // 0호도 있다
    int[] beforeFloor = new int[15];
    int sol = 0;
    ArrayList<Integer> currentFloor = new ArrayList<Integer>();

    for (int i = 0 ;i < beforeFloor.length; i++) {
      beforeFloor[i] = i + 1;
    }

      // k층
    for (int countNum = 0; countNum < count; countNum++) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());

      for (int floor = 1; floor <= k; floor++) {
        int sum = 0;
        for (int ele : beforeFloor) {
          sum += ele;
          currentFloor.add(sum);
        }
        for (int i = 0 ; i < currentFloor.size(); i++) {
          beforeFloor[i] = currentFloor.get(i);
        }
        sol = currentFloor.get(n-1);
        currentFloor.clear();
      }
      System.out.println(sol);
      beforeFloor = new int[15];
      
      for (int i = 0 ;i < beforeFloor.length; i++) {
        beforeFloor[i] = i + 1;
      }
    // n호
    }
  }

}
