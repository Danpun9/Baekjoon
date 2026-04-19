import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long n = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());

        Long X = 0l, Y = 0l, sign = -1l;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            X += Long.parseLong(st.nextToken());
            Y -= Long.parseLong(st.nextToken());
        }

        Y += n * b;

        if (X < 0) {
            sign *= -1;
            X *= -1;
        }
        if (Y < 0) {
            sign *= -1;
            Y *= -1;
        }

        if (X == 0) {
            System.out.println("EZPZ");
        } else if (Y % X == 0) {
            System.out.println((Y / X) * sign);
        } else {
            Long gcd = GCD(X, Y);
            X /= gcd;
            Y /= gcd;

            System.out.println(sign * Y + "/" + X);
        }
    }

    static Long GCD(Long a, Long b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}