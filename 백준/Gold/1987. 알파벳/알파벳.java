import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[][] graph;
    static int[] x = new int[]{0,1,-1,0};
    static int[] y = new int[]{1,0,0,-1};
    static int height;
    static int width;
    static int maxDist = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] prob = br.readLine().split(" ");

        height = Integer.parseInt(prob[0]);
        width = Integer.parseInt(prob[1]);
        graph = new int[height][width];
        boolean[] alpVisited = new boolean[26];

        for(int i =0; i< height; i++) {
            String lineProb = br.readLine();
            for(int j=0; j <width; j++) {
                graph[i][j] = lineProb.charAt(j) - 'A';
            }
        }
        dfs(0,0, 1, alpVisited);

        System.out.println(maxDist);

    }

    static void dfs(int xCoord, int yCoord, int depth, boolean[] alpVisited) {
        if(maxDist < depth) {
            maxDist = depth;
        }
        alpVisited[graph[xCoord][yCoord]] = true;
        for (int i = 0; i < 4; i++) {
            int newX = xCoord + x[i];
            int newY = yCoord + y[i];
            if (newX >= 0 && newY >= 0 && newX < height && newY < width) {
                if (!alpVisited[graph[newX][newY]]) {
                    // 헤멧던이유
                    // 이렇게 분기마다 새롭게 배열을 재생성해서 넘겨줄 수도 있지만
                    // 훨씬더 단순하게 dfs를 돌린 후에는 방문을 false로 하게 해버리면 재생성과정이
                    // 필요없게 되지 않냐
//                    ArrayList<String> newAlpVisit = new ArrayList<>(alpVisited);
//                    boolean[][] newVisited = new boolean[visited.length][];
//
//                    for (int j = 0; j < visited.length; j++) {
//                        newVisited[j] = visited[j].clone();
//                    }
                    dfs(newX, newY, depth + 1, alpVisited);

                    // 이렇게 false로 해주면 이전꺼랑 똑같은 배열의 alpVisited가 만들어지는 것이라서
                    // 굳이 alpVisited를 새롭게 생성해서 dfs마다 새롭게 만들어 줄 필요가 없음
                    alpVisited[graph[newX][newY]] = false;
                }
            }

        }


    }
}
