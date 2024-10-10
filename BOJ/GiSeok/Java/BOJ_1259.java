package BOJ.GiSeok.Java;

import java.io.*;

public class BOJ_1259 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String num = br.readLine();
            if (num.equals("0")) break;

            boolean flag = false;
            for (int i = 0; i < num.length() / 2; i++) {
                if (num.charAt(i) != num.charAt(num.length()-i-1)) { flag = true; break; }
            }

            if (flag) System.out.println("no");
            else System.out.println("yes");
        }
    }
}