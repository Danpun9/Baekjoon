import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = new BigInteger("0");
            for (int j = 0; j < N; j++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }
            if (sum.compareTo(BigInteger.ZERO) > 0) {
                sb.append("+\n");
            } else if (sum.compareTo(BigInteger.ZERO) < 0) {
                sb.append("-\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb);
    }
}