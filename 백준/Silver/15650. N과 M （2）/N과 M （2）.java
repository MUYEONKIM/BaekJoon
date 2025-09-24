import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] prob = br.readLine().split(" ");

    int nums = Integer.parseInt(prob[0]);
    int cnt = Integer.parseInt(prob[1]);

    int[] probList = new int[nums];
    boolean[] visited = new boolean[nums];

    for(int i=0; i< nums; i++) {
      probList[i] = i+1;
    }

    combination(probList, visited, 0, nums, cnt);
  }

  static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
    if(r == 0) {
      for (int i = 0; i < n; i++) {
        if(visited[i]) {
          System.out.print(arr[i] + " ");
        }
      }
      System.out.println();
      return;
    }

    for(int i = start; i < n; i++) {
      visited[i] = true;
      combination(arr, visited, i + 1, n, r - 1);
      visited[i] = false;
    }
  }
}
