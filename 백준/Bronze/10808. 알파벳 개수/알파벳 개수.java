import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String prob = br.readLine();
    LinkedHashMap<String, Integer> solve = new LinkedHashMap<>();

    for (int i = 'a'; i <= 'z'; i++) { // 'a'의 ASCII 값인 97부터 'z'의 ASCII 값인 122까지 반복
      solve.put(String.valueOf((char) i), 0);
    }

    for (int i =0; i < prob.length(); i++) {
      String a = String.valueOf(prob.charAt(i));
      int count = solve.get(a);

      solve.put(a, count + 1);
    }

    for (Map.Entry<String, Integer> entry : solve.entrySet()) {
      System.out.printf("%d ",entry.getValue());
    }
  }

}
