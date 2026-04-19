import java.io.*;
import java.util.*;

public class Main {

    static long[] minSide = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long N = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] Dice = new int[6];
        for (int i = 0; i < 6; i++) {
            Dice[i] = Integer.parseInt(st.nextToken());
        }
        setMinSide(Dice);

        long res = 0L;

        if (N == 1) {
            Arrays.sort(Dice);
            for (int i = 0; i < 5; i++) {
                res += Dice[i];
            }
        } else {
            res += minSide[0] * (((N - 1) * (N - 2) * 4) + (N - 2) * (N - 2));
            res += (minSide[0] + minSide[1]) * ((N - 2) * 4 + (N - 1) * 4);
            res += (minSide[0] + minSide[1] + minSide[2]) * 4;
        }

        System.out.println(Long.toString(res));
    }

    static void setMinSide(int[] Dice) {
        minSide[0] = Math.min(Dice[0], Dice[5]);
        minSide[1] = Math.min(Dice[1], Dice[4]);
        minSide[2] = Math.min(Dice[2], Dice[3]);

        Arrays.sort(minSide);
    }
}
