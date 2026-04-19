import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        char[][] flag = { { 'G', '.', '.', '.' }, { '.', 'I', '.', 'T' }, { '.', '.', 'S', '.' } };

        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < K; l++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < K; k++) {
                        sb.append(flag[i][j]);
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
