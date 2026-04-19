import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int res = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int[] al = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

            for (int j = 0; j < str.length(); j++) {
                if (al[str.charAt(j) - 'a'] == 0) {
                    al[str.charAt(j) - 'a'] = 1;
                    for (int k = 0; k < str.length(); k++) {
                        if (str.length() > j + 1)
                            if (str.charAt(j) == str.charAt(j + 1))
                                j++;
                            else
                                break;
                    }
                } else {
                    res--;
                    break;
                }
            }
        }
        bw.write(String.valueOf(n + res));
        bw.flush();
        bw.close();
    }
}
