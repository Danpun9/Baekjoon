import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] arr;
    static int[][] dpMax;
    static int[][] dpMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][3];
        dpMax = new int[n][3];
        dpMin = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dpMax[n - 1][0] = dpMin[n - 1][0] = arr[n - 1][0];
        dpMax[n - 1][1] = dpMin[n - 1][1] = arr[n - 1][1];
        dpMax[n - 1][2] = dpMin[n - 1][2] = arr[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dpMax[i][j] = Math.max(dpMax[i + 1][0] + arr[i][j], dpMax[i + 1][1] + arr[i][j]);
                    dpMin[i][j] = Math.min(dpMin[i + 1][0] + arr[i][j], dpMin[i + 1][1] + arr[i][j]);
                } else if (j == 2) {
                    dpMax[i][j] = Math.max(dpMax[i + 1][1] + arr[i][j], dpMax[i + 1][2] + arr[i][j]);
                    dpMin[i][j] = Math.min(dpMin[i + 1][1] + arr[i][j], dpMin[i + 1][2] + arr[i][j]);
                } else {
                    dpMax[i][j] = Math.max(dpMax[i + 1][0] + arr[i][j], dpMax[i + 1][1] + arr[i][j]);
                    dpMin[i][j] = Math.min(dpMin[i + 1][0] + arr[i][j], dpMin[i + 1][1] + arr[i][j]);
                    dpMax[i][j] = Math.max(dpMax[i + 1][2] + arr[i][j], dpMax[i][j]);
                    dpMin[i][j] = Math.min(dpMin[i + 1][2] + arr[i][j], dpMin[i][j]);
                }
            }
        }

        Arrays.sort(dpMax[0]);
        Arrays.sort(dpMin[0]);

        bw.write(dpMax[0][2] + " " + dpMin[0][0]);

        bw.close();
        br.close();
    }
}