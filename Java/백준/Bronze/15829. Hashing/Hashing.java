import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger res = new BigInteger("0");

        br.readLine();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            BigInteger a = new BigInteger(Long.toString(str.charAt(i) - 'a' + 1));
            res = res.add(a.multiply(BigInteger.valueOf(31).pow(i)));
        }
        res = res.remainder(BigInteger.valueOf(1234567891));
        System.out.println(res);
    }
}
