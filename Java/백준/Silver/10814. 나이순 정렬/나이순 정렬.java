import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] data = new String[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i][0] = st.nextToken();
            data[i][1] = st.nextToken();
        }

        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(String[] str1, String[] str2) {
                return Integer.parseInt(str1[0]) - Integer.parseInt(str2[0]);
            }
        });

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + " " + data[i][1]);
        }
    }
}