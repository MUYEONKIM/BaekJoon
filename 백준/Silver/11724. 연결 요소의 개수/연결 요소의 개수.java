import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] node = br.readLine().split(" ");
      int vertex = Integer.parseInt(node[0]);
      int trunk = Integer.parseInt(node[1]);
      int sol = 0;
      visited = new boolean[vertex + 1];


      for (int i = 0; i <= vertex; i++) {
        ArrayList<Integer> graphNode = new ArrayList<Integer>();
        graph.add(graphNode);
      }

      for (int count = 0; count < trunk; count++) {
        String[] line = br.readLine().split(" ");
        int u = Integer.parseInt(line[0]);
        int v = Integer.parseInt(line[1]);

        graph.get(u).add(v);
        graph.get(v).add(u);
      }

      for (int i = 1; i <=vertex; i++) {
        if(!visited[i]) {
          DFS(i);
          sol++;
        }
      }

      System.out.println(sol);
    }

  static void DFS(int nodeIndex) {
      if (visited[nodeIndex] == true) {
        return;
      }
      visited[nodeIndex] = true;
      for (int chan: graph.get(nodeIndex)) {
        DFS(chan);
      }
  }
}
