import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String var1 = br.readLine();
    String solve = "";

    for (int i = 0; i < Integer.parseInt(var1); i++) {
      String[] problem = br.readLine().split(" ");

      String arg1 = problem[0];
      String[] arg2 = problem[1].split("");

      for (String arg2char : arg2) {
        for (int x=0; x< Integer.parseInt(arg1); x++) {
          solve += arg2char;
        }
      }
      if (i != Integer.parseInt(var1)){
        solve += "\n";
      }
    }
    System.out.println(solve);
  }
}
