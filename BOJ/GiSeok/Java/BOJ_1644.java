/**
 * 1644 - 소수의 연속합 [실패|01:18:18]
 * 골드3, 에라토스테네스의 체, 시도5
 * 
 * 에라토스테네스의 체를 몰랐음.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1644 {
    // 시간제한 2초, 메모리제한 128MB
    // 하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다.
    // 3 -> 3 (1가지)
    // 41 -> 2+3+5+7+11+13 = 11+13+17 = 41 (3가지)
    // 53 -> 5+7+11+13+17 = 63 (2가지)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> sosu = new ArrayList<>();
        int[] a = new int[n+1];
        for (int i = 2; i < n + 1; i++)
            a[i] = i;

        for (int i = 2; i < n + 1; i++) {
            if (a[i] == 0) continue;

            for (int j = i*2; j < n+1; j+=i)
                a[j] = 0;
        }

        for (int i = 2; i < n + 1; i++)
            if (a[i] != 0) sosu.add(i);

        int ret = 0;
        if (n != 1) {

            int start = 0;
            int end = 0;
            int sum = 0;
            
            while (true) {
                // n보다 작은데 end가 더이상 갈 수 없다면
                // 가능한 경우의 수가 없으므로 if (sum >= n) 후에 else if 로 end의 범위를 검사하는 것.
                if (sum >= n) sum -= sosu.get(start++);
                else if (end == sosu.size()) break;
                else sum += sosu.get(end++);
                if (sum == n) ret++;
            }
        }

        System.out.println(ret);

    }
}
