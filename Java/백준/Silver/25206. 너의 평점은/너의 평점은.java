import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double[][] score = new double[20][2];

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            score[i][0] = Double.parseDouble(st.nextToken());
            switch (st.nextToken()) {
                case "A+":
                    score[i][1] = 4.5;
                    break;
                case "A0":
                    score[i][1] = 4.0;
                    break;
                case "B+":
                    score[i][1] = 3.5;
                    break;
                case "B0":
                    score[i][1] = 3.0;
                    break;
                case "C+":
                    score[i][1] = 2.5;
                    break;
                case "C0":
                    score[i][1] = 2.0;
                    break;
                case "D+":
                    score[i][1] = 1.5;
                    break;
                case "D0":
                    score[i][1] = 1.0;
                    break;
                case "F":
                    score[i][1] = 0;
                    break;
                case "P":
                    score[i][1] = -1;
            }
        }

        double tscore = 0;
        int tsubject = 0;
        for (int i = 0; i < 20; i++) {
            if (score[i][1] != -1) {
                tsubject += score[i][0];
                tscore = tscore + (score[i][0] * score[i][1]);
            }
        }
        double res = tscore / tsubject;

        bw.write(String.valueOf(res));

        bw.flush();
        bw.close();
    }
}
