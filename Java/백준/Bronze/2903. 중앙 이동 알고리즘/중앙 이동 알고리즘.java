import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int res = 2;
        for (int i = 0; i < N; i++) {
            res = res + res - 1;
        }

        res = (int) Math.pow(res, 2);
        bw.write(String.valueOf(res));
        bw.flush();

        bw.close();
    }
}
