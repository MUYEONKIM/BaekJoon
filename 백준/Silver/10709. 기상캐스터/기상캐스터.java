import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] coord = br.readLine().split(" ");
    int x = Integer.parseInt(coord[0]);
    int y = Integer.parseInt(coord[1]);
    String[][] graph = new String[x][y];
    int[][] existGraph = new int[x][y];

    for(int i=0; i < x; i++) {
      String[] prob = br.readLine().split("");
      for(int j=0; j < y; j++) {
        graph[i][j] = prob[j];
        if(graph[i][j].equals("c")) {
          existGraph[i][j] = 0;
        } else {
          existGraph[i][j] = -1;
        }
      }

      for(int q =0; q< y; q++) {
        if(q+1 >= y) {
          continue;
        }
        if(existGraph[i][q] != -1) {
          if(existGraph[i][q+1] != 0) {
            existGraph[i][q+1] = existGraph[i][q] + 1;
          }
        }
      }
    }

    for(int[] t: existGraph) {
      for(int q: t) {
        System.out.print(q);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

}
