import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int res = 0, con = 1;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'O') {
                    res += con++;
                } else {
                    con = 1;
                }
            }
            System.out.println(res);
        }
    }
}