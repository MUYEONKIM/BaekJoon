import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String probs = br.readLine();
            if(probs.equals("0")) {
                break;
            }
            String[] prob = probs.split(" ");

            int cnt = Integer.parseInt(prob[0]);
            int[] probList = new int[cnt];
            boolean[] visited = new boolean[cnt];

            for(int i=0; i< cnt; i++) {
                probList[i] = Integer.parseInt(prob[i + 1]);
            }

            combination(probList, visited, 0, cnt,6);

            System.out.println();
        }
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            for (int i = 0; i < n; i++) {
                if(visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
