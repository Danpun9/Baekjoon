import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        boolean[][] background = new boolean[101][101];

        int num = Integer.parseInt(br.readLine());

        int res = 0;

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (background[j][k] == false) {
                        background[j][k] = true;
                        res++;
                    }
                }
            }
        }

        bw.write(String.valueOf(res));

        bw.flush();
        bw.close();
    }
}
