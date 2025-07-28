import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static Queue<Integer> queue = new LinkedList<Integer>(); // 노드 담을 큐
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 인접그래프
  static ArrayList<Integer> procedure = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vertex = Integer.parseInt(br.readLine()); // 정점 개수
    String[] problem = br.readLine().split(" ");
    int[] depths = new int[vertex + 1];
    int trunk = Integer.parseInt(br.readLine());

    for (int i=0; i <= vertex; i++) {
      ArrayList<Integer> nodeGraph = new ArrayList<>();
      graph.add(nodeGraph);
    }

    for (int i=0; i < trunk; i++) {
      String[] node = br.readLine().split(" ");

      graph.get(Integer.parseInt(node[0])).add(Integer.parseInt(node[1]));
      graph.get(Integer.parseInt(node[1])).add(Integer.parseInt(node[0]));
    }
    BFS(Integer.parseInt(problem[0]), depths, problem[1]);
  }

  private static void BFS(int startNum, int[] depths, String problem) {
      queue.offer(startNum); // queue에 첫번째 노드 내가 삽입
      Arrays.fill(depths, -1);
      depths[startNum] = 0;

    while(!queue.isEmpty()) { // 비워질때 까지 반복
        int now = queue.poll(); // 현재 노드 번호를 queue에서 배출

        // 꺼낸 노드의 전체 인접 놈들 확인
        for(int i=0; i < graph.get(now).size(); i++) {
          int node = graph.get(now).get(i);

          // 방문한적 없는 node면 queue에 넣어서 다음 순서로 넣어줌
          if (depths[node] == -1) {
            queue.offer(node);
            depths[node] = depths[now] + 1;
          }
        }
      }

    System.out.println(depths[Integer.parseInt(problem)]);

  }
}


