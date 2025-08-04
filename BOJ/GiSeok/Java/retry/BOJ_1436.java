package BOJ.GiSeok.Java.retry;

// 00:09:04 S5
import java.io.*;

public class BOJ_1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int i = 666;
        while (true) {
            if (String.valueOf(i).contains("666")) {
                cnt++;
            }

            if (n == cnt) {
                break;
            }
            i++;
        }

        System.out.println(i);
    }
}
