import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder sol = new StringBuilder();

        while (((s=br.readLine()) != null) ) {
            if(s.equals("1")) {
                sol.append("1\n");
                continue;
            }

            BigInteger prob = new BigInteger(s);
            BigInteger num = BigInteger.ONE;
            while (1==1) {
                num = num.multiply(BigInteger.TEN).add(BigInteger.ONE);

                if (num.remainder(prob).equals(BigInteger.ZERO)) {
                    sol.append(num.toString().length()).append("\n");
                    break;
                }
            }
        } System.out.println(sol);

    }
}
