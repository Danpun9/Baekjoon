import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < str[0].length(); i++) {
            boolean isSame = true;
            for (int j = 1; j < n; j++) {
                if (str[j].charAt(i) == str[0].charAt(i)) {
                    continue;
                } else {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                bw.write(str[0].charAt(i));
            } else {
                bw.write("?");
            }
        }

        bw.close();
    }
}