import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<String> hsets = new HashSet<>();

    int count = Integer.parseInt(br.readLine());
    for (int i=0; i < count; i++) {
      String prob = br.readLine();
      hsets.add(prob);
    }
    String[] problems = hsets.toArray(new String[0]);
    Arrays.sort(problems, (o1, o2) -> {
      if (o1.length() == o2.length()) {
        return o1.compareTo(o2); // 길이가 같으면 사전 순으로 비교
      } else {
        return o1.length() - o2.length(); // 길이가 다르면 길이 차이로 비교
      }
    });

    for(String sol: problems) {
      System.out.println(sol);
    }
  }
}
