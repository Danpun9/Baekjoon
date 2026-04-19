import java.io.*;

public class Main {
    static String str1, str2;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str1 = br.readLine();
        str2 = br.readLine();

        dp = new Integer[str1.length()][str2.length()];

        int res = lcs(str1.length() - 1, str2.length() - 1);

        bw.write(res + "");

        bw.close();
        br.close();
    }

    static int lcs(int c1, int c2) {
        if (c1 == -1 || c2 == -1) {
            return 0;
        }

        if (dp[c1][c2] == null) {
            dp[c1][c2] = 0;

            if (str1.charAt(c1) == str2.charAt(c2)) {
                dp[c1][c2] = lcs(c1 - 1, c2 - 1) + 1;
            } else {
                dp[c1][c2] = Math.max(lcs(c1 - 1, c2), lcs(c1, c2 - 1));
            }
        }

        return dp[c1][c2];

    }
}
