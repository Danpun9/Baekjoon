import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane, Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        box.sort(Collections.reverseOrder());

        if (crane[0] < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int T = 0;
        while (!box.isEmpty()) {
            int boxIndex = 0;
            for (int i = 0; i < crane.length;) {
                if (boxIndex == box.size()) {
                    break;
                } else if (crane[i] >= box.get(boxIndex)) {
                    box.remove(boxIndex);
                    i++;
                } else {
                    boxIndex++;
                }
            }
            T++;
        }

        System.out.println(T);
    }
}