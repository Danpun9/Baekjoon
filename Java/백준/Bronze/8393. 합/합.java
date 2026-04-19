import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long res = 0;
        for (int i = 0; i <= n; i++) {
            res += i;
        }
        System.out.println(res);
    }
}