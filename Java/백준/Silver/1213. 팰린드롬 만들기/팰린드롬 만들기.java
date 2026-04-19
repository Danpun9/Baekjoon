import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int[] letter = new int[26];

        for (int i = 0; i < str.length(); i++) {
            letter[str.charAt(i) - 'A']++;
        }

        boolean isPal = true;
        int odd = -1;
        for (int i = 0; i < 26; i++) {
            if (letter[i] % 2 != 0) {
                if (odd != -1) {
                    isPal = false;
                } else {
                    odd = i;
                    letter[i]--;
                }
            }

            if (!isPal) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < letter[i] / 2; k++) {
                sb.append((char) ('A' + i));
            }
        }

        if (odd != -1) {
            sb.append((char) ('A' + odd));
        }

        for (int i = 25; i >= 0; i--) {
            for (int k = 0; k < letter[i] / 2; k++) {
                sb.append((char) ('A' + i));
            }
        }

        System.out.println(sb);
    }
}