import java.util.*;
import java.io.*;

public class Main {

    public static boolean prime[];

    public static void getPrime() {
        for (int i = 0; i < prime.length; i++)
            prime[i] = true;
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < prime.length; i++) {
            if (prime[i] == false)
                continue;
            else {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        prime = new boolean[N + 1];
        getPrime();

        int res = 0;
        int min = -1;
        for (int i = M; i <= N; i++) {
            if (prime[i] == true) {
                res += i;
                if (min == -1) {
                    min = i;
                }
            }
        }

        if (res == 0) {
            bw.write("-1");
            bw.close();
        } else {
            bw.write(String.valueOf(res) + "\n" + String.valueOf(min));
            bw.close();
        }

    }
}
