import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());
    ArrayList<String[]> arrayList = new ArrayList<String[]>();
    for (int i = 0; i < count ; i++) {
      String[] prob = br.readLine().split(" ");
      arrayList.add(prob);
    }

    for (int q = 0; q < count; q++) {
      int rank = 1;
      for (int w = 0; w < count; w++) {
        if (q == w) {
          continue;
        }
        if (Integer.parseInt(arrayList.get(q)[0]) < Integer.parseInt(arrayList.get(w)[0]) & Integer.parseInt(arrayList.get(q)[1]) < Integer.parseInt(arrayList.get(w)[1])) {
          rank++;
        }
      }
      System.out.print(rank + " ");
    }

  }
}
