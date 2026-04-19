import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String out = "";

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp >= 'A' && temp <= 'Z') {
                out += (char) (temp - 'A' + 'a');
            } else {
                out += (char) (temp - 'a' + 'A');
            }
        }

        System.out.println(out);
    }
}