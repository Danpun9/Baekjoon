import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());

        boolean sample = true, system = true;
        while (s1-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals(st.nextToken())) {
                continue;
            } else {
                sample = false;
            }
        }

        while (s2-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals(st.nextToken())) {
                continue;
            } else {
                system = false;
            }
        }

        if (sample && system) {
            bw.write("Accepted");
        } else if (!sample) {
            bw.write("Wrong Answer");
        } else {
            bw.write("Why Wrong!!!");
        }

        bw.close();
        br.close();
    }
}