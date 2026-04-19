import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String str = br.readLine();

            int[] alphabet = new int[26];
            boolean isFake = false;

            for (int i = 0; i < str.length(); i++) {
                alphabet[str.charAt(i) - 'A']++;
                if (alphabet[str.charAt(i) - 'A'] == 3) {
                    try {
                        if (str.charAt(i) == str.charAt(i + 1)) {
                            i++;
                            alphabet[str.charAt(i) - 'A'] = 0;
                        } else {
                            isFake = true;
                            break;
                        }
                    } catch (Exception e) {
                        isFake = true;
                        break;
                    }
                }
            }

            if (!isFake) {
                sb.append("OK\n");
            } else {
                sb.append("FAKE\n");
            }
        }

        System.out.println(sb);
    }
}