import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] prob = br.readLine().split(" ");
    Map<String, String> pokeNumMap = new HashMap<String, String>();
    Map<String, String> pokeNameMap = new HashMap<String, String>();

    int count = Integer.parseInt(prob[0]);
    int probCount = Integer.parseInt(prob[1]);

    for (int i =0 ; i < count ; i++) {
      String pokemon = br.readLine();
      pokeNumMap.put(Integer.toString(i+1), pokemon);
      pokeNameMap.put(pokemon, Integer.toString(i+1));
    }

    for (int i=0 ;i < probCount; i++) {
      String problem = br.readLine();

      if (pokeNumMap.get(problem) == null) {;
        System.out.println(pokeNameMap.get(problem));
      } else {
        System.out.println(pokeNumMap.get(problem));
      }
    }

  }

}
