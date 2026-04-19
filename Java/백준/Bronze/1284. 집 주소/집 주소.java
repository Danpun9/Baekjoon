import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] width = { 4, 2, 3, 3, 3, 3, 3, 3, 3, 3 };

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;

            int res = 1;

            while (N > 0) {
                res += width[N % 10] + 1;
                N /= 10;
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}
