import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        char[] sArr = S.toCharArray();

        long MOD = 1000000007L;
        long[][] nCr = new long[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            nCr[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                nCr[i][j] = (nCr[i - 1][j - 1] + nCr[i - 1][j]) % MOD;
            }
        }

        long totalWays = 0;

        for (int m = 0; m < N - 1; m++) {
            int k = 1;
            while (m - k + 1 >= 0 && m + k < N) {
                if (sArr[m - k + 1] == '>' && sArr[m + k] == '<') {
                    int L = m - k + 1;
                    int R = N - 1 - (m + k);
                    totalWays = (totalWays + nCr[L + R][L]) % MOD;
                    k++;
                } else {
                    break;
                }
            }
        }

        bw.write(String.valueOf(totalWays));
        bw.flush();
        
        br.close();
        bw.close();
    }
}