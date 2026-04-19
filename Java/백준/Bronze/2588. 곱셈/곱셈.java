import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] bb = new int[3];

        for (int i = 0; i < bb.length; i++) {
            bb[i] = (b % 10) * a;
            b /= 10;
        }
        for (int i = 0; i < bb.length; i++) {
            System.out.println(bb[i]);
        }
        System.out.println(bb[0] + bb[1] * 10 + bb[2] * 100);
    }
}