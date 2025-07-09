import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String first_num = br.readLine();
    String second_num = br.readLine();
    ArrayList<Integer> solve = new ArrayList<Integer>();

    List<String> second_num_list = Arrays.asList(second_num.split(""));
    Collections.reverse(second_num_list);
    int main_num = Integer.parseInt(first_num);

    for (String i : second_num_list) {
      solve.add(main_num * Integer.parseInt(i));
    }

    solve.add(main_num * Integer.parseInt(second_num));

    for (Integer i : solve) {
      System.out.println(i);
    }
  }
}
