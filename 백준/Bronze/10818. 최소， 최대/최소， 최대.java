import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        String[] prob = br.readLine().split(" ");
        int min=Integer.parseInt(prob[0]);
        int max=Integer.parseInt(prob[0]);
        for(int i =0; i < prob.length; i++) {
            int val = Integer.parseInt(prob[i]);
            if( val > max) {
                max = val;
            }
            if(val < min) {
                min = val;
            }
        }

        System.out.print(min);
        System.out.print(" ");
        System.out.print(max);
    }
}
