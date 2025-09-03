import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = new int[]{1,0,-1,0};
  static int[] dy = new int[]{0,1,0,-1};
  static int solCnt = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] prob = br.readLine().split(" ");

    int xlen = Integer.parseInt(prob[1]);
    int ylen = Integer.parseInt(prob[0]);
    int cnt = Integer.parseInt(prob[2]);
    int solveCount = 0;
    ArrayList<Integer> sol = new ArrayList<>();


    graph = new int[xlen][ylen];
    visited = new boolean[xlen][ylen];

    for(int x=0; x <xlen; x++) {
      for(int y=0; y<ylen; y++) {
        graph[x][y] = 1;
      }
    }

    for(int i =0; i< cnt; i++) {
      String[] coord = br.readLine().split(" ");

      int[] fircoord = new int[]{Integer.parseInt(coord[0]), Integer.parseInt(coord[1])};
      int[] seccoord = new int[]{Integer.parseInt(coord[2]), Integer.parseInt(coord[3])};


      for(int x=fircoord[0]; x < seccoord[0]; x++) {
        for(int y=fircoord[1]; y< seccoord[1];y++) {
          graph[x][y] = 0;
        }
      }
    }

    for(int x = 0; x < xlen; x++) {
      for(int y =0; y<ylen; y++) {
        if (graph[x][y] == 1 && !visited[x][y]) {
          dfs(x,y,xlen, ylen);
          solveCount++;
          sol.add(solCnt);
          solCnt = 1;
        }
      }
    }

    System.out.println(solveCount);
    Collections.sort(sol);
    for(int q: sol) {
      System.out.print(q);
      System.out.print(" ");
    }

  }

  public static void dfs(int x, int y, int xlen, int ylen) {
    visited[x][y] = true;

    for(int i=0; i<4; i++) {
      int newx = x + dx[i];
      int newy = y + dy[i];

      if(newx>=0 && newy>=0 && newx< xlen && newy<ylen) {
        if(graph[newx][newy] == 1 && !visited[newx][newy]) {
          solCnt++;
          dfs(newx, newy, xlen, ylen);
        }
      }
    }
  }


}
