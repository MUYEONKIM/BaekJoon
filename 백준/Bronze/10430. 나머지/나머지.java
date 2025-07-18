import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");
    int A = Integer.parseInt(str[0]);
    int B = Integer.parseInt(str[1]);
    int C = Integer.parseInt(str[2]);

    System.out.println( (A+B)%C );
    System.out.println( (A%C+B%C)%C );
    System.out.println( (A*B)%C );
    System.out.println( ((A%C)*(B%C))%C );
  }
}