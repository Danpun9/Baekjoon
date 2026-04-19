import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd = GCD(a, b);
            sb.append((a * b) / gcd).append("\n");
        }
        System.out.println(sb);
    }

    public static int GCD(int a, int b) {
        while (b != 0) { // GCD(a,b) == GCD(b,r)
            int r = a % b;
            a = b;
            b = r;
        }
        return a; // a와 b의 최대공약수
    }
}