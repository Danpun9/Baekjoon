import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toUpperCase();

        int[] res = new int[26];

        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i) - 'A']++;
        }

        int max = -1;
        char maxL = '?';
        for (int i = 0; i < res.length; i++) {
            if (res[i] > max) {
                max = res[i];
                maxL = (char) ('A' + i);
            } else if (res[i] == max) {
                maxL = '?';
            }
        }
        bw.write(maxL);
        bw.flush();
        bw.close();
    }
}
