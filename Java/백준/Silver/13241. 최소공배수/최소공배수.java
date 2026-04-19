import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long gcd = GCD(a, b);
        System.out.println(a * b / gcd);
    }

    public static long GCD(long a, long b) {
        while (b != 0) { // GCD(a,b) == GCD(b,r)
            long r = a % b;
            a = b;
            b = r;
        }
        return a; // a와 b의 최대공약수
    }
}