import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        ArrayList<String> dict = new ArrayList<>();

        for (int a = 1; a < str.length(); a++) {
            for (int b = a + 1; b < str.length(); b++) {
                StringBuffer str1 = new StringBuffer(str.substring(0, a));
                StringBuffer str2 = new StringBuffer(str.substring(a, b));
                StringBuffer str3 = new StringBuffer(str.substring(b));
                StringBuilder sb = new StringBuilder();

                sb.append(str1.reverse()).append(str2.reverse()).append(str3.reverse());
                dict.add(sb.toString());
            }
        }

        Collections.sort(dict);

        System.out.println(dict.get(0));
    }
}
