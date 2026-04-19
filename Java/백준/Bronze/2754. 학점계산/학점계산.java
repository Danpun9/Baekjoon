import java.io.*;
import java.util.*;

public class Main {

    static Long[] triangle = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        double res = (int) -(str.charAt(0) - 'E');

        try {
            if (str.charAt(1) == '+') {
                res += 0.3;
            } else if (str.charAt(1) == '-') {
                res -= 0.3;
            }
        } catch (Exception e) {
            bw.write("0.0");
            bw.flush();
            return;
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }
}