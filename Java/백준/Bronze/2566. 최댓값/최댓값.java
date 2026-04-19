import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] data = new int[9][9];
        int max = -1;
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (max <= data[i][j]) {
                    max = data[i][j];
                    maxX = i + 1;
                    maxY = j + 1;
                }
            }
        }
        bw.write(String.valueOf(max) + "\n" + String.valueOf(maxX) + " " + String.valueOf(maxY));
        bw.flush();
        bw.close();
    }
}
