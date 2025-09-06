import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> initarr = new ArrayList<>();
        for(int i=0; i< 9;i++) {
            int val = Integer.parseInt(br.readLine());
            arr.add(val);
            initarr.add(val);
        }

        Collections.sort(arr, Collections.reverseOrder());
        System.out.println(arr.get(0));
        System.out.println(initarr.indexOf(arr.get(0)) + 1);
    }
}
