import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());
    String solve = br.readLine();
    solve = solve.replace("*",".*");
    Pattern pattern = Pattern.compile(solve);
    for (int i=0; i< count; i++) {
      String prob = br.readLine();

      Matcher match = pattern.matcher(prob);
      if (match.matches()) {
        System.out.println("DA");
      } else {
        System.out.println("NE");
      }
    }
  }
}
