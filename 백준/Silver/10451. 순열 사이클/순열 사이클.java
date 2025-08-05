import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());

    for (int i=0; i < count; i++) {

    boolean[] visited;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    int problemCount = Integer.parseInt(br.readLine());
    int solve = 0;
    visited = new boolean[problemCount + 1];

    for (int q = 0; q<= problemCount; q++) {
      ArrayList<Integer> nodeGraph = new ArrayList<>();
      graph.add(nodeGraph);
    }

    String[] problem = br.readLine().split(" ");
    for (int w= 1; w<= problemCount; w++) {
      graph.get(w).add(Integer.parseInt(problem[w - 1]));
      graph.get(Integer.parseInt(problem[w - 1])).add(w);
    }

    for (int e = 1; e<= problemCount; e++) {
      if(!visited[e]) {
        DFS(e, visited, graph);
        solve++;
      }
    }
    System.out.println(solve);
  }
  }


  static void DFS(int nodeIndex, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
    if (visited[nodeIndex]) {
      return;
    }

    visited[nodeIndex] = true;

    for (int chan: graph.get(nodeIndex)) {
      DFS(chan, visited, graph);
    }
  }

}
