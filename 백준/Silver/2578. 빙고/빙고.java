import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Integer> problem = new ArrayList<>();

    List<Integer[]> mutableSolveList = new ArrayList<>(Arrays.asList(
        new Integer[]{0,1, 2, 3, 4},
        new Integer[]{5,6, 7, 8, 9},
        new Integer[]{10, 11, 12, 13, 14},
        new Integer[]{15, 16, 17, 18, 19},
        new Integer[]{20,21, 22, 23, 24},
        new Integer[]{0, 5, 10, 15, 20},
        new Integer[]{1, 6, 11, 16, 21},
        new Integer[]{2, 7, 12, 17, 22},
        new Integer[]{3, 8, 13, 18, 23},
        new Integer[]{4, 9, 14, 19, 24},
        new Integer[]{0, 6, 12, 18, 24},
        new Integer[]{4, 8, 12, 16, 20}
    ));

    int count = 0;


    for (int i = 0; i < 5; i++) {
      String[] probLine = br.readLine().split(" ");
      for (String ele : probLine) {
        problem.add(Integer.parseInt(ele));
      }
    }

    ArrayList<Integer> bingoCalledIndices = new ArrayList<>();
    int bingoCount = 0;

    for (int i = 0; i < 5; i++) {
      String[] callLine = br.readLine().split(" ");

      for (String ele : callLine) {
        int calledNumber = Integer.parseInt(ele);


        int index = problem.indexOf(calledNumber);
        bingoCalledIndices.add(index);

        Iterator<Integer[]> iterator = mutableSolveList.iterator();
        while (iterator.hasNext()) {
          Integer[] solveEle = iterator.next();
          if (bingoCalledIndices.containsAll(Arrays.asList(solveEle))) {
            bingoCount++;
            iterator.remove();
          }
        }

        count++;


        if (bingoCount >= 3) {
          System.out.println(count);
          return;
        }
      }
    }
  }
}