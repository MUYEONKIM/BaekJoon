import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] arg = br.readLine().split(" ");

    String[] problem = br.readLine().split(" ");
    StringBuilder solve = new StringBuilder();
    LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

    for (String privProb : problem) {
      if (map.containsKey(privProb)) {
        int cnt = map.get(privProb);
        map.put(privProb, cnt+1);
        continue;
      }
      map.put(privProb, 1);
    }

    List<Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

    Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
      }
    });

    LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
    for (Map.Entry<String, Integer> entry : entryList) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }


    for (Map.Entry<String, Integer> entry: sortedMap.entrySet()) {
          for(int i=0; i < entry.getValue(); i++) {
            solve.append(entry.getKey() + " ");
          }
    }

    System.out.println(solve);
  }
}
