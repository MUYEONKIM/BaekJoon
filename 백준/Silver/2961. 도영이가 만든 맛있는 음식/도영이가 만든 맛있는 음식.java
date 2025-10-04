import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt;
    static long[] prob1;
    static long[] prob2;
    static long sol = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cnt = Integer.parseInt(br.readLine());
        prob1 = new long[cnt];
        prob2 = new long[cnt];

        for (int i =0; i< cnt; i++) {
            String[] probs = br.readLine().split(" ");

            prob1[i] = Long.parseLong(probs[0]);
            prob2[i] = Long.parseLong(probs[1]);
        }
        dfs(0, 1L, 0L, 0);
        System.out.println(sol);
    }
    public static void dfs(int depth, Long sum1, Long sum2, int count) {
        if(depth == cnt) { // 마지막 depth란 뜻은 즉 모든 경우의 수에서 제일 마지막까지 도달했을 때를 의미
            if ( count > 0) {
                long diff = Math.abs(sum1 - sum2);

                if(sol > diff) {
                    sol = Math.abs(sum1 - sum2);
                }
            }
            return;
        }

        dfs(depth + 1, sum1, sum2, count);
        dfs(depth + 1, sum1 * prob1[depth], sum2 + prob2[depth], count + 1);
    }
}
