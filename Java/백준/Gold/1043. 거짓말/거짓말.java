import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static ArrayList<Integer> truth;

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return find(parent[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (truth.contains(py)) {
            int temp = py;
            py = px;
            px = temp;
        }

        parent[py] = px;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        truth = new ArrayList<>();
        ArrayList<ArrayList<Integer>> party = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        if (k == 0) {
            System.out.println(m);
            return;
        } else {
            for (int i = 0; i < k; i++) {
                truth.add(Integer.parseInt(st.nextToken()));
            }
        }

        int res = 0;

        for (int i = 0; i <= m; i++) {
            party.add(new ArrayList<>());
        }

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int people = Integer.parseInt(st.nextToken());

            int root = Integer.parseInt(st.nextToken());
            party.get(i).add(root);

            for (int j = 1; j < people; j++) {
                int participant = Integer.parseInt(st.nextToken());

                union(root, participant);

                party.get(i).add(participant);
            }
        }

        for (int i = 1; i <= m; i++) {
            boolean canLie = true;

            for (int participant : party.get(i)) {
                if (truth.contains(find(parent[participant]))) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) {
                res++;
            }
        }

        System.out.println(res);
    }
}