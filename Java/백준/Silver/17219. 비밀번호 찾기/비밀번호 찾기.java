import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, String> idpw = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String id = st.nextToken();
            String pw = st.nextToken();
            idpw.put(id, pw);
        }

        for (int i = 0; i < m; i++) {
            bw.write(idpw.get(br.readLine()) + "\n");
        }

        bw.close();
        br.close();
    }
}