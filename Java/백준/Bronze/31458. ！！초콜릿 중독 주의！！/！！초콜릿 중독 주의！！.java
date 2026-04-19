import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();

            boolean res = false;

            int location;
            if (str.indexOf("0") != -1) {
                location = str.indexOf("0");
            } else {
                location = str.indexOf("1");
                res = true;
            }

            if (location != str.length() - 1) {
                res = true;
            }

            if (location % 2 != 0) {
                res = !res;
            }

            if (res) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb);
    }
}