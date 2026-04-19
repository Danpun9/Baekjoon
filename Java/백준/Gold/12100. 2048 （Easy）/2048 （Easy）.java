import java.io.*;
import java.util.*;

public class Main {
    static int N = 0;
    static int[][] board;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        bw.write(String.valueOf(res));
        bw.close();
        br.close();
    }

    static void dfs(int depth) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    res = Math.max(res, board[i][j]);
                }
            }
            return;
        }

        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            temp[i] = board[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            move(i);
            dfs(depth + 1);
            for (int j = 0; j < N; j++) {
                board[j] = temp[j].clone();
            }
        }
    }

    static void move(int dir) {
        switch (dir) {
            case 0: moveUp(); break;
            case 1: moveDown(); break;
            case 2: moveLeft(); break;
            case 3: moveRight(); break;
        }
    }

    static void moveUp() {
        for (int j = 0; j < N; j++) {
            int index = 0;
            int block = 0;
            for (int i = 0; i < N; i++) {
                if (board[i][j] != 0) {
                    if (block == board[i][j]) {
                        board[index - 1][j] = block * 2;
                        block = 0;
                        board[i][j] = 0;
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[index][j] = block;
                        index++;
                    }
                }
            }
        }
    }

    static void moveDown() {
        for (int j = 0; j < N; j++) {
            int index = N - 1;
            int block = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    if (block == board[i][j]) {
                        board[index + 1][j] = block * 2;
                        block = 0;
                        board[i][j] = 0;
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[index][j] = block;
                        index--;
                    }
                }
            }
        }
    }

    static void moveLeft() {
        for (int i = 0; i < N; i++) {
            int index = 0;
            int block = 0;
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    if (block == board[i][j]) {
                        board[i][index - 1] = block * 2;
                        block = 0;
                        board[i][j] = 0;
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[i][index] = block;
                        index++;
                    }
                }
            }
        }
    }

    static void moveRight() {
        for (int i = 0; i < N; i++) {
            int index = N - 1;
            int block = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (board[i][j] != 0) {
                    if (block == board[i][j]) {
                        board[i][index + 1] = block * 2;
                        block = 0;
                        board[i][j] = 0;
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[i][index] = block;
                        index--;
                    }
                }
            }
        }
    }
}
