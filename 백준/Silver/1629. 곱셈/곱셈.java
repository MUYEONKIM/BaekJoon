import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] prob = br.readLine().split(" ");

    BigInteger a = new BigInteger(prob[0]);
    BigInteger b = new BigInteger(prob[1]);
    BigInteger c = new BigInteger(prob[2]);

    BigInteger result = a.modPow(b, c);

    System.out.println(result);
  }
}