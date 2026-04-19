import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String num = br.readLine();

            BigInteger prime = new BigInteger(num);

            if (prime.isProbablePrime(10))
                System.out.println(prime);
            else
                System.out.println(prime.nextProbablePrime());
        }
    }
}