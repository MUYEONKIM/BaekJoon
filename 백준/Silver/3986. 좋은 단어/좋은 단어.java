import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    int count = 0;

    for(int i=0; i< num; i++) {
      String[] prob = br.readLine().split("");
      Stack<String> sol = new Stack<>();

      for (String str: prob) {

        if (!sol.isEmpty() && sol.peek().equals(str)) {
          sol.pop();
        } else {
          sol.push(str);
        }

      }
      if(sol.isEmpty()) {
        count++;
      }
    }
    System.out.println(count);
  }
}
