import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());
    int prob = Integer.parseInt(br.readLine());
    int solve = 0;

    String[] numbers = br.readLine().split(" ");

    // [2 7 4 1 5 3]

    for (int x =0; x < numbers.length; x++) {
      for (int y = x + 1; y <numbers.length; y++) {
        int sum = Integer.parseInt(numbers[x]) + Integer.parseInt(numbers[y]);
        if (sum == prob) {
          solve++;
        };

      }
    }
    System.out.println(solve);

  }
}
