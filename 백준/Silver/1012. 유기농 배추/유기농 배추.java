import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,1,0,-1};
  static Queue<int[]> que = new LinkedList<>();
  static int solveCount = 0;
  static int[][] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testCaseCount = Integer.parseInt(br.readLine());

    for(int i =0; i < testCaseCount; i++) {
      String[] prob = br.readLine().split(" ");
      int xlen = Integer.parseInt(prob[0]);
      int ylen = Integer.parseInt(prob[1]);
      int count = Integer.parseInt(prob[2]);
      graph = new int[xlen][ylen];
      boolean[][] visited = new boolean[xlen][ylen];

      for(int j=0; j<count; j++) {
        String[] dir = br.readLine().split(" ");
        int x = Integer.parseInt(dir[0]);
        int y = Integer.parseInt(dir[1]);

        graph[x][y] = 1;
      }

      for(int q = 0; q< xlen; q++) {
        for(int w = 0; w <ylen; w++) {
          if(graph[q][w] == 1 && !visited[q][w]) {

            bfs(visited, q, w, xlen, ylen);
            solveCount += 1;
          }

        }
      }
      System.out.println(solveCount);
      solveCount = 0;
    }
  }

  public static void bfs(boolean[][] visited,int x, int y, int xlen, int ylen) {
    que.offer(new int[]{x,y});

    // que가 빌때까지
    while (!que.isEmpty()) {
      int[] current = que.poll();

      visited[x][y] = true;
      for(int i = 0; i< 4; i++) {
        int newX = current[0] + dx[i];
        int newY = current[1] + dy[i];

        // 여기서 루프 돌아가는 조건 전체 탐색
        if(newX >= 0 && newY >= 0 && newX < xlen && newY < ylen) {
          if(graph[newX][newY] == 1 && !visited[newX][newY]) {
            visited[newX][newY] = true;
            que.add(new int[]{newX, newY});
          }
        }
      }
    }


  }
}
