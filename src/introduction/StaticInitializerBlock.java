package introduction;

import java.util.Scanner;

public class StaticInitializerBlock {

    static boolean flag;
    static int B, H;

    static { // static initialization blocks
            Scanner sc = new Scanner(System.in);
            B = sc.nextInt();
            H = sc.nextInt();
            if (B > 0 && H > 0)
                flag = true;
            else
                System.out.println("java.lang.Exception: Breadth and height must be positive");
            sc.close();
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}
