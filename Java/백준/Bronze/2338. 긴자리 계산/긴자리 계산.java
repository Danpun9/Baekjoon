import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        sb.append(a.add(b)).append("\n").append(a.subtract(b)).append("\n").append(a.multiply(b));

        System.out.println(sb);
    }
}
