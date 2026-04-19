import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] cres = { 1, 1, 2, 2, 2, 8 };
        int[] res = { 0, 0, 0, 0, 0, 0 };

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            res[i] = Integer.parseInt(st.nextToken());
            if (res[i] != cres[i])
                res[i] = cres[i] - res[i];
            else
                res[i] = 0;
            bw.write(String.valueOf(res[i]) + " ");
        }
        
        bw.close();

    }
}
