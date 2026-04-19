import java.io.*;
import java.util.*;

public class Main {

    public static boolean prime[];

    public static void getPrime() {
        for (int i = 0; i < prime.length; i++)
            prime[i] = true;
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i] == false)
                continue;
            else {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        prime = new boolean[N + 1];
        getPrime();

        for (int i = M; i <= N; i++) {
            if (prime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}