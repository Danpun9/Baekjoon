import java.io.*;
import java.util.*;

public class Main {

    public static Boolean[][] Board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        Board = new Boolean[row][col];

        for (int i = 0; i < row; i++) {
            String temp = br.readLine();

            for (int j = 0; j < col; j++) {
                if (temp.charAt(j) == 'W')
                    Board[i][j] = true;
                else
                    Board[i][j] = false;
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                int temp = getChangeCnt(i, j);
                if (res > temp)
                    res = temp;
            }
        }

        System.out.println(res);

    }

    public static int getChangeCnt(int y, int x) {
        int cnt = 0;

        boolean tile = Board[y][x]; // 이상적 타일 배치 변수

        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (Board[i][j] != tile) { // 보드 (j,i)의 색이 tile과 다르면
                    cnt++; // 바꾼 횟수 증가
                }
                tile = (!tile); // 타일 열 변경
            }
            tile = (!tile); // 하나의 행 끝나면 다음 행으로
        }

        cnt = Math.min(cnt, 64 - cnt); // 시작 타일 W || B

        return cnt;
    }
}