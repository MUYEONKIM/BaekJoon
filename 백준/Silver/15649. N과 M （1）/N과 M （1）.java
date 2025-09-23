import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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

    int[] output = new int[cnt];
    perm(probList, output, visited, 0, nums,cnt);

  }

  public static void perm(int[] arr, int[] output, boolean[] visited, int stx, int n, int r) {
    if(stx == r) {
      for(int a: output) {
        System.out.print(a + " ");
      }
      System.out.println();
      return;
    }

    for(int i=0; i <n ; i++) {
      if(visited[i] != true) {
        visited[i] = true;
        output[stx] = arr[i];
        perm(arr, output, visited, stx + 1, n, r);
        visited[i] = false;
      }
    }
  }
}
