import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] parent;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(br.readLine());

        H += T / 3600;
        M += (T % 3600) / 60;
        S += (T % 3600) % 60;

        if (S >= 60) {
            M += S / 60;
            S %= 60;
        }

        if (M >= 60) {
            H += M / 60;
            M %= 60;
        }

        if (H >= 24) {
            H %= 24;
        }

        StringBuilder sb = new StringBuilder().append(H).append(" ").append(M).append(" ").append(S);

        System.out.println(sb);
    }
}
