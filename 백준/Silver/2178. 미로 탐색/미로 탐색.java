import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static Queue<int[]> que = new LinkedList<>();
  static int[] dx = new int[]{1,0,-1,0};
  static int[] dy = new int[]{0,1,0,-1};
  static boolean[][] visited;
  static int[][] graph;
  static int[][] count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] prob = br.readLine().split(" ");

    int x = Integer.parseInt(prob[0]);
    int y = Integer.parseInt(prob[1]);
    graph = new int[x][y];
    visited = new boolean[x][y];
    count = new int[x][y];


    for(int i = 0; i < x; i++) {
      String[] initprob = br.readLine().split("");
      for(int q = 0; q< initprob.length; q++) {
          graph[i][q] = Integer.parseInt(initprob[q]);
          count[i][q] = 0;
        }
    }

    bfs(0, 0, x, y);
    System.out.println(count[x - 1][y - 1] + 1);
  }


  public static void bfs(int i, int j, int xlen, int ylen) {
    que.offer(new int[]{i,j});

    while(!que.isEmpty()) {
      // 첫 방문지 방문
      visited[i][j] = true;
      int[] now = que.poll();

      for(int k=0; k < 4; k++) {
        int x = now[0] + dx[k];
        int y = now[1] + dy[k];

        if(x >= 0 && y >=0 && x < xlen && y < ylen) {
          if (graph[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;
            count[x][y] = count[now[0]][now[1]] + 1;
            que.add(new int[]{x,y});
          }
        }
      }
    }

  }
}
