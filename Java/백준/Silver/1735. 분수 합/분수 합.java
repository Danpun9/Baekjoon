import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int a = (a1 * b2) + (a2 * b1);
        int b = b1 * b2;

        int gcd = GCD(a, b);

        StringBuilder sb = new StringBuilder();
        sb.append(a / gcd).append(" ").append(b / gcd);
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