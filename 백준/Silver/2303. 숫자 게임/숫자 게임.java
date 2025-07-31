import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
  static List<List<Integer>> allCombinations;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());
    int[] solve = new int[count];
    for (int i = 0; i < count; i++) {
      String[] problemStr = br.readLine().split(" ");
      int[] problem = new int[problemStr.length];
      for (int j = 0; j < problemStr.length; j++) {
        problem[j] = Integer.parseInt(problemStr[j]);
      }

      allCombinations = new ArrayList<>();

      combinations(new Stack<>(), problem, 0, 3); // 3개 선택
      int maxValue = 0;
      for (List<Integer> arg: allCombinations) {
        int sum_one = arg.stream().collect(Collectors.summingInt(Integer::intValue)) % 10;

        if (maxValue <= sum_one) {
          maxValue = sum_one;
        }
      }
      solve[i] = maxValue;
    }

    int val = 0;
    int index = 0;
    for (int i = 0 ; i < solve.length; i++) {
      if (val <= solve[i]) {
        val = solve[i];
        index = i + 1;
      }
    }

    System.out.println(index);
  }
  static void combinations(Stack<Integer> currentCombination, int[] arr, int startIdx, int r) {
    if (currentCombination.size() == r) {
      allCombinations.add(new ArrayList<>(currentCombination));
      return;
    }

    for (int i = startIdx; i < arr.length; i++) {
      currentCombination.push(arr[i]);
      combinations(currentCombination, arr, i + 1, r);
      currentCombination.pop();
    }
  }
}