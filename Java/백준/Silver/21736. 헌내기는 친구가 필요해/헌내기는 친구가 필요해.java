import java.io.*;
import java.util.*;

class Location {
    int x, y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static char[][] Maze;
    static boolean[][] visited;
    static int res = 0;
    static int N, M;

    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Maze = new char[N][M];
        visited = new boolean[N][M];

        int x = 0, y = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                Maze[i][j] = line.charAt(j);
                if (Maze[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);
        if (res == 0)
            System.out.println("TT");
        else
            System.out.println(res);

    }

    static void bfs(int x, int y) {
        Queue<Location> q = new LinkedList<>();

        q.add(new Location(x, y));

        visited[x][y] = true;

        while (!q.isEmpty()) {
            Location loc = q.poll();

            for (int i = 0; i < 4; i++) {
                int cx = loc.x + dx[i];
                int cy = loc.y + dy[i];

                if (cx >= 0 && cx < N && cy >= 0 && cy < M && !visited[cx][cy] && Maze[cx][cy] != 'X') {
                    if (Maze[cx][cy] == 'P')
                        res++;
                    visited[cx][cy] = true;
                    q.add(new Location(cx, cy));
                }
            }
        }
    }
}
