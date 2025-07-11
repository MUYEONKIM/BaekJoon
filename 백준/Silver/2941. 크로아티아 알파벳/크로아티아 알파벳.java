import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] problem = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    String sent = br.readLine();

    // indexof로 해당 문자 포함하는지를 알게 된 후에, replaceall 로 한글자로 대체해줌
    for (String arg : problem) {
      int indexs = sent.indexOf(arg);

      if (indexs >= 0) {
        sent = sent.replaceAll(arg, "A");
      }
    }

    System.out.println(sent.length());

  }
}
