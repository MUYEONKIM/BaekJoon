import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Character> lowerAsc = new ArrayList();
    ArrayList<Character> upperAsc = new ArrayList();


    String[] prob = br.readLine().split("");
    // 65 ~90
    for (int i = 0; i < 2; i++) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        lowerAsc.add(ch);
      }
    }

    for (int i = 0; i < 2; i++) {
      for (char ch = 'A'; ch <= 'Z'; ch++) {
        upperAsc.add(ch);
      }
    }


    for(int i=0; i < prob.length; i++) {
      char asc = prob[i].charAt(0);
      int ascNum = asc;
      if (ascNum >= 65 & ascNum <= 90) {
        int newNum = (asc + 13) % 65;
        prob[i] = String.valueOf(upperAsc.get(newNum));
      } else if (ascNum >= 97 & ascNum <= 122) {
        int newNum = (asc + 13) % 97;
        prob[i] = String.valueOf(lowerAsc.get(newNum));
      }
    }

    for(String sol: prob) {
      System.out.print(sol);
    }
  }
}
