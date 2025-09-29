import java.io.*;

public class Main {
    static int sol = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        for(int i=0; i< cnt; i++) {
            String[] prob = br.readLine().split(" ");

            String calc = prob[0];

            switch (calc) {
                case "add":
                        sol |= (1 << Integer.parseInt(prob[1]));
                    break;
                case "remove":
                        sol &= ~(1 << Integer.parseInt(prob[1]));
                    break;
                case "check":
                    if((sol & (1 << Integer.parseInt(prob[1]))) == (1 << Integer.parseInt(prob[1]))) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    sol ^= (1 << Integer.parseInt(prob[1]));
                    break;
                case "all":
                    sol = (1 << 21) - 1;
                    break;
                case "empty":
                    sol = 0;
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
