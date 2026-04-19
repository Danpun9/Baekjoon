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

        int input = Integer.parseInt(br.readLine());

        prime = new boolean[123456 * 2 + 1];
        getPrime();

        while (input != 0) {
            int cnt = 0;
            for (int i = input * 2; i > input; i--) {
                if (prime[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");

            input = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}