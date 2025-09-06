import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] graph;
    static StringBuilder sol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        graph = new int[cnt][cnt];
        sol = new StringBuilder();

        for(int i=0; i <cnt ; i++) {
            String[] probs = br.readLine().split("");
            for(int j=0; j<cnt; j++) {
                graph[i][j] = Integer.parseInt(probs[j]);
            }
        }

        quadTree(0,0, cnt);

        System.out.println(sol);
    }

    public static void quadTree(int x, int y, int size) {
        if (isEquals(x,y,size)) {
            sol.append(graph[x][y]);
            return;
        }

        int newSize = size / 2;
        int newX = x + newSize;
        int newY = y + newSize;

        sol.append("(");
        // 항상 그래프에 x,y 좌표를 생각할때는 인덱스 기준으로 생각해야할 것
        quadTree(x, y, newSize); // 1사분면
        quadTree(x, newY, newSize); // 2사분ㅁㄴ
        quadTree(newX, y, newSize); // 3사문면
        quadTree(newX, newY,newSize); // 4사분면
        sol.append(")");

    }

    public static boolean isEquals(int x, int y, int size) {
        int val =graph[x][y];

        for(int i=x; i< x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if( val != graph[i][j]) {
                    return false;
                };
            }
        }
        return true;
    }
}
