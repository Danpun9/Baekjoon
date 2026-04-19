import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<Integer> burger = new ArrayList<>();
        ArrayList<Integer> side = new ArrayList<>();
        ArrayList<Integer> drink = new ArrayList<>();

        int res = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            burger.add(Integer.parseInt(st.nextToken()));
            res += burger.get(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            side.add(Integer.parseInt(st.nextToken()));
            res += side.get(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            drink.add(Integer.parseInt(st.nextToken()));
            res += drink.get(i);
        }

        sb.append(res).append("\n");

        int min = Math.min(B, C);
        min = Math.min(min, D);

        Collections.sort(burger, Collections.reverseOrder());
        Collections.sort(side, Collections.reverseOrder());
        Collections.sort(drink, Collections.reverseOrder());

        for (int i = 0; i < min; i++) {
            res -= (burger.get(i) + drink.get(i) + side.get(i)) * 0.1;
        }

        sb.append(res);

        System.out.println(sb);
    }
}