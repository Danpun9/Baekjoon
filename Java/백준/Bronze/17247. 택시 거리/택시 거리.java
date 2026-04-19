import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] x = new int[2];
        int[] y = new int[2];

        int[][] map = new int[n][m];
        boolean check = false;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    if(!check){
                        check = !check;
                        x[0] = i;
                        x[1] = j;
                    }else {
                        y[0] = i;
                        y[1] =j;
                    }
                }
            }
        }

        x[0] = Math.abs(y[0] - x[0]);
        x[1] = Math.abs(y[1] - x[1]);

        System.out.println(x[0] + x[1]);
    }
}