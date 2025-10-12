import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine(), 2);
        int sol = 0;
        while(num != 0) {
            sol++;
            num = num - (num&(~num + 1));
        }
        System.out.println(sol);
    }
}
