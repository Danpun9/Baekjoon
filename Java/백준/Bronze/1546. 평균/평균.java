import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        double[] scores = new double[n];
        double max = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {

            scores[i] = Integer.parseInt(st.nextToken());
            if (scores[i] > max)
                max = scores[i];
        }

        double res = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = scores[i] / max * 100;
            res += scores[i];
        }

        res /= n;
        System.out.println(res);
    }
}