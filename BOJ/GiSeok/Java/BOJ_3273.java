/**
 * 3273 - 두 수의 합 [성공|00:09:03]
 * 실버3, 투포인터, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
    // 시간제한 1초, 메모리제한 128MB
    // n개의 서로 다른 양의 정수로 이루어진 수열이 있다.
    // 수열의 요소는 1 <= ai <= 1000000 (100만)
    // x가 주어졌을 때 ai + aj = x를 만족하는 쌍의 수 구하기

    // 1 ≤ n ≤ 100,000
    // 연속된 쌍이 아니니까 오름차순 정렬하고 sum < x, sum > x에 따라 s, e 값 조절?
    // 시간 복잡도 해봐야 17만(Arrays.sort 최악) + 10만(수열 최대). = 27만?

    static int[] a;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);
        int x = Integer.parseInt(br.readLine());


        int s = 0;
        int e = n - 1;

        int sum;
        int ret = 0;
        while (s < e) {
            sum = a[s] + a[e];
            
            if (sum == x) ret++;
            
            if (sum < x) s++;
            else e--;
        }

        System.out.println(ret);
    }
}
