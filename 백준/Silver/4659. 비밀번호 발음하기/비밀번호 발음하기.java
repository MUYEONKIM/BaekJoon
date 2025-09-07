import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Character[] solArr = new Character[]{'a', 'e', 'i', 'o', 'u'};

        while(true) {
            String prob = br.readLine();
            if (prob.equals("end")) {
                break;
            }

            StringBuilder sol = new StringBuilder();
            sol.append("<").append(prob).append("> is ");
            if(isValid(prob)) {
                sol.append("acceptable.");
            } else {
                sol.append("not acceptable.");
            }



            System.out.println(sol);
        }
    }

    public static boolean isValid(String s) {
        boolean hasVowel = false;
        for (char ch : s.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                hasVowel = true;
                break;
            }
        }
        if (!hasVowel) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                if (s.charAt(i) != 'e' && s.charAt(i) != 'o') {
                    return false;
                }
            }

            if (i > 1) {
                boolean isVowel1 = "aeiou".indexOf(s.charAt(i - 2)) != -1;
                boolean isVowel2 = "aeiou".indexOf(s.charAt(i - 1)) != -1;
                boolean isVowel3 = "aeiou".indexOf(s.charAt(i)) != -1;

                if ((isVowel1 && isVowel2 && isVowel3) || (!isVowel1 && !isVowel2 && !isVowel3)) {
                    return false;
                }
            }
        }

        return true;
    }
}
