import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt(); // 총 금액
        int type = sc.nextInt(); // 종류의 수
        int[] a = new int[type]; // 각각의 가격
        int[] b = new int[type]; // 각각의 개수
        int res = 0;

        for (int i = 0; i < type; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for (int i = 0; i < type; i++) {
            res += a[i] * b[i];
        }

        if (res == total)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}