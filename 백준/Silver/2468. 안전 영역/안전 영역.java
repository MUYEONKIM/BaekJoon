import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,1,0,-1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int len = Integer.parseInt(br.readLine());
    int count = 0;
    int[] solList = new int[101];

    graph = new int[len][len];
    visited = new boolean[len][len];

    for(int i = 0 ; i< len; i++) {
      String[] prob = br.readLine().split(" ");

      for(int j = 0; j <len; j++) {
        graph[i][j] = Integer.parseInt(prob[j]);
      }
    }

    for(int depth = 0; depth <= 100 ; depth++) {
      for(int i = 0 ; i< len; i++) {
        for(int j = 0; j <len; j++) {
            if (graph[i][j] > depth && !visited[i][j]) {
                dfs(i,j,depth);
                count++;
            }
        }
      }
      visited = new boolean[len][len];
      solList[depth] = count;
      count = 0;
    }

    int maxSol = 0;
    for(int max: solList) {
      if (maxSol < max) {
        maxSol = max;
      }
    }
    System.out.println(maxSol);



  }

  public static void dfs(int x, int y, int depth) {
    visited[x][y] = true;

    for(int i =0; i< 4; i++) {
      int newx = x + dx[i];
      int newy = y + dy[i];

      if(newx >=0 && newy >=0 && newx < graph.length && newy < graph.length) {
        if(graph[newx][newy] > depth && !visited[newx][newy]) {
          dfs(newx, newy, depth);
        }
      }
    }
  }

}
