package BOJ.GiSeok.Java.retry.reretry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {

    static int N;
    static int[] nums;
    static int[] opNums;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        opNums = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) opNums[i] = Integer.parseInt(st.nextToken());

        // 재귀
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        re(nums[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void re(int num, int cnt) {
        if (cnt == N) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opNums[i] <= 0) continue;
            opNums[i] -= 1;
            switch (i) {
                case 0:
                    re(num + nums[cnt], cnt+1); break;
                case 1:
                    re(num - nums[cnt], cnt+1); break;
                case 2:
                    re(num * nums[cnt], cnt+1); break;
                case 3:
                    re(num / nums[cnt], cnt+1); break;
            }
            opNums[i] += 1;
        }
    }
}
