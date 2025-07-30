import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vertex = Integer.parseInt(br.readLine());
    int count = Integer.parseInt(br.readLine());
    boolean[] visited = new boolean[vertex + 1];
    int solve = 0;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    for(int i=0; i <= vertex; i++) {
      ArrayList<Integer> nodeGraph = new ArrayList<>();
      graph.add(nodeGraph);
    }

    for(int i=0; i < count; i++) {
      String[] prob = br.readLine().split(" ");
      int first = Integer.parseInt(prob[0]);
      int second = Integer.parseInt(prob[1]);

      graph.get(first).add(second);
      graph.get(second).add(first);
    }

    visited[1] = true;

    for (int primaryNode: graph.get(1)) {
      visited[primaryNode] = true;
      for(int ppNode : graph.get(primaryNode)) {
        if (!visited[ppNode]) {
          visited[ppNode] = true;
        }
      }
    }

    for(boolean sol: visited) {
      if (sol) {
        solve++;
      }
    }

    System.out.println(solve -1);
  }
}
