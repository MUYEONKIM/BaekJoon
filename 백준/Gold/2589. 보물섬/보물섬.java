import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String[][] graph;
    static int[] dx = new int[]{0,1,-1,0};
    static int[] dy = new int[]{1,0,0,-1};
    static int height;
    static int width;
    static int maxDist = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] prob = br.readLine().split(" ");

        height = Integer.parseInt(prob[0]);
        width = Integer.parseInt(prob[1]);
        graph = new String[height][width];

        for(int i =0; i< height; i++) {
            String[] lineProb = br.readLine().split("");
            for(int j=0; j <width; j++) {
                graph[i][j] = lineProb[j];
            }
        }

        for(int i =0; i< height; i++) {
            for(int j=0; j <width; j++) {
                if (graph[i][j].equals("L")) {
                    boolean[][] visited = new boolean[height][width];

                    bfs(visited, i, j);
                }
            }
        }

        System.out.println(maxDist);
    }

    public static void bfs(boolean[][] visited,int x, int y) {
        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[]{x,y, 0});
        int maxMove = 0;
        // que가 빌때까지
        while (!que.isEmpty()) {
            int[] current = que.poll();
            int moving = current[2];
            visited[x][y] = true;

            if(maxMove < moving) {
                maxMove = moving;
            }
            for(int i = 0; i< 4; i++) {
                int newX = current[0] + dx[i];
                int newY = current[1] + dy[i];

                // 여기서 루프 돌아가는 조건 전체 탐색
                if(newX >= 0 && newY >= 0 && newX < height && newY < width) {
                    if(graph[newX][newY].equals("L") && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        que.add(new int[]{newX, newY, moving + 1});
                    }
                }
            }
        }
        if(maxDist < maxMove) {
            maxDist = maxMove;
        }

    }
}
