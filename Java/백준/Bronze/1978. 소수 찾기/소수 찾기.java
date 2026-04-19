import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean isPrime = true;
            for (int j = 2; j <= num / 2 && isPrime != false; j++) {
                if (num % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime == true && num != 1)
                res++;
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
