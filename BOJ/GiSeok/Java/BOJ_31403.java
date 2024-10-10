package BOJ.GiSeok.Java;

import java.io.*;

public class BOJ_31403 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        System.out.println(a + b - c);
        String s = "" + a + b;
        System.out.println(Integer.parseInt(s) - c);
    }
}
