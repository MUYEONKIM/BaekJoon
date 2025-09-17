import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cnt = Integer.parseInt(br.readLine());
    int root = 0;
    for(int i = 0; i< cnt; i++) {
    }

    for(int i=0;i<cnt;i++){
      ArrayList<Integer> treeNode = new ArrayList<>();
      tree.add(treeNode);
    }

    String[] prob = br.readLine().split(" ");
    for(int i=0;i<cnt;i++){
      int p = Integer.parseInt(prob[i]);
      if(p!=-1){
        tree.get(p).add(i);
      } else {
        root = i;
      }
    }

    int remove = Integer.parseInt(br.readLine());
    removeTree(remove);

    int solcnt = 0;
    for(ArrayList<Integer> solList : tree) {
      if(solList.isEmpty()) {
        solcnt++;
      }
    }

    if(remove != root && solcnt == 0) {
      System.out.println(solcnt+1);
    } else {
      System.out.println(solcnt);
    }
  }

  public static void removeTree(int remove) {
    ArrayList<Integer> removeList = tree.get(remove);

    if (!removeList.isEmpty()) {
      for(int removeInt: removeList) {
        removeTree(removeInt);
      }
    }
    ArrayList<Integer> test = new ArrayList<>();
    ArrayList<Integer> idx = new ArrayList<>();
    idx.add(remove);
    if (tree.contains(idx)) {
      tree.set(tree.indexOf(idx) , new ArrayList<>());
    }

    test.add(-1);
    tree.set(remove, test);
  }
}


