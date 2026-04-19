import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'c' && i < str.length() - 1) {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (str.charAt(i) == 'd' && i < str.length() - 1) {
                if (str.charAt(i + 1) == 'z' && i < str.length() - 2) {
                    if (str.charAt(i + 2) == '=') {
                        i += 2;
                    }
                } else if (str.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (str.charAt(i) == 'l' && i < str.length() - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if (str.charAt(i) == 'n' && i < str.length() - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if (str.charAt(i) == 's' && i < str.length() - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            } else if (str.charAt(i) == 'z' && i < str.length() - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }
            res++;
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
