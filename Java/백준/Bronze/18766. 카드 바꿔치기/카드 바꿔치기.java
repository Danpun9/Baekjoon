import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] card1 = new String[n];
            String[] card2 = new String[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                card1[i] = st.nextToken();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                card2[i] = st.nextToken();
            }

            Arrays.sort(card1);
            Arrays.sort(card2);

            boolean isCheat = false;
            for (int i = 0; i < n; i++) {
                if (!card1[i].equals(card2[i])) {
                    isCheat = true;
                    break;
                }
            }

            if (isCheat) {
                sb.append("CHEATER\n");
            } else {
                sb.append("NOT CHEATER\n");
            }
        }

        System.out.println(sb);
    }
}