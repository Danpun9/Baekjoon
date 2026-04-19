import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> tree = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            tree.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(tree);

        int gcd=0;
        for (int i = 0; i < N-1; i++) {
            int dis = tree.get(i+1) - tree.get(i); 
            gcd = GCD(dis, gcd);
        }

        int res = (((tree.get(N-1) - tree.get(0)) / gcd) + 1) - N;

        System.out.println(res);
    }

    public static int GCD(int a, int b) {
        while (b != 0) { // GCD(a,b) == GCD(b,r)
            int r = a % b;
            a = b;
            b = r;
        }
        return a; // a와 b의 최대공약수
    }
}