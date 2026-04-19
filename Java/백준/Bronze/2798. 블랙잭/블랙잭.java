import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] card = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < card.length; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < card.length; i++) {
            for (int j = i + 1; j < card.length; j++) {
                for (int k = j + 1; k < card.length; k++) {
                    if (card[i] + card[j] + card[k] > M)
                        continue;
                    else if (card[i] + card[j] + card[k] > max)
                        max = card[i] + card[j] + card[k];
                }
            }
        }

        System.out.println(max);

    }
}