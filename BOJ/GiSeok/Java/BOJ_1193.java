package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        while (N > cnt) {
            N -= cnt;
            cnt++;
        }

        if (cnt % 2 == 0)
            bw.write(N + "/" + (cnt-(N-1)) + "\n");
        else
            bw.write((cnt-(N-1)) + "/" + N + "\n");

        bw.flush();
        bw.close();
    }
}
