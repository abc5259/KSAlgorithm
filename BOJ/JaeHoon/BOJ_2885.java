package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2885 {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        int cnt = 1;
        while (Math.pow(2, cnt) < K) {
            cnt++;
        }

        int size = (int) Math.pow(2, cnt);
        if(size == K) {
            System.out.println(size + " " + 0);
            return;
        }
        int result = solve(size / 2, K - size / 2);
        System.out.println(size + " " + result);
    }

    static int solve(int size, int needCnt) {
        int cnt = 1;
        while (needCnt != 0) {
            cnt++;
            size = size / 2;
            if (needCnt >= size) {
                needCnt -= size;
            }
        }
        return cnt;
    }
}
