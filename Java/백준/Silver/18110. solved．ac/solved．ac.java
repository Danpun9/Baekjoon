import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n];
        while (n-- > 0) {
            score[n] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(score);

        int TrimmedMean = (int) Math.round(score.length * 0.15);
        double sum = 0;
        for (int i = TrimmedMean; i < score.length - TrimmedMean; i++) {
            sum += score[i];
        }

        System.out.println((int) Math.round(sum / (score.length - TrimmedMean * 2)));
    }
}