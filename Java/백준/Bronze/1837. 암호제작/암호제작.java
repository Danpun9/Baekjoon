import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.text.*;

public class Main {
    static int[] parent;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger P = new BigInteger(st.nextToken());
        BigInteger K = new BigInteger(st.nextToken());

        BigInteger i = BigInteger.ONE;

        while (true) {
            if (i.compareTo(K) != -1) {
                System.out.println("GOOD");
                System.exit(0);
            }

            i = i.add(BigInteger.ONE);

            if (P.remainder(i).compareTo(BigInteger.ZERO) == 0 && i.compareTo(K) == -1) {
                System.out.println("BAD " + i);
                System.exit(0);
            }
        }
    }
}
