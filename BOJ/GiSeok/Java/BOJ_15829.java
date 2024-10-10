package BOJ.GiSeok.Java;

import java.io.*;

public class BOJ_15829 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long ret = 0;
        for (int i = 0; i < l; i++) {

            long tmp = s.charAt(i) - 'a' + 1;
            for (int k = 0; k < i; k++) {
                tmp = (tmp * 31) % 1234567891;
            }

            ret = (tmp + ret) % 1234567891;
        }

        System.out.println(ret);
    }
}
