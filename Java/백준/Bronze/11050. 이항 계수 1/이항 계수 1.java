import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int res = Factorial(N) / (Factorial(K) * Factorial(N - K));

        System.out.println(res);
    }

    static int Factorial(int n) {
        if (n != 0)
            return n * Factorial(n - 1);
        else
            return 1;
    }
}