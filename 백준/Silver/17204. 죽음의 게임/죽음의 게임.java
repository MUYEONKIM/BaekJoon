import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  static boolean[]isVisited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    arr=new int[n];

    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int cnt=0;
    int tmp = 0;
    boolean flag = false;
    isVisited = new boolean[n+1];


    while(true) {
      if(arr[tmp]==k) { 
        cnt++;
        break;
      }
      else if(isVisited[arr[tmp]]) {
        flag = true;
        break;
      }
      else {
        tmp=arr[tmp];
        isVisited[tmp]= true;
        cnt++;
      }
    }
    if(flag) {
      System.out.println(-1);
    }
    else {
      System.out.println(cnt);
    }

  }
}