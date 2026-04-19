import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] data = new int[N];
        int[] cData = new int[N];
        HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            cData[i] = data[i];
        }

        Arrays.sort(cData);

        int rank = 0;
        for (int i : cData) {
            if (!rankMap.containsKey(i)) {
                rankMap.put(i, rank++);
            }
        }

        for (int i : data) {
            int ranking = rankMap.get(i);
            sb.append(ranking).append(" ");
        }

        System.out.println(sb);
    }
}