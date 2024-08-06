/**
 * 13144 - List of Unique Numbers [실패|01:09:55]
 * 골드3, 투포인터
 * 
 * 로직 자체는 거의 비슷했으나 나는 모든 경우의 수를 찾아놓고 end를 진행하면서 중복되는 수를 만나면
 * 해당 수열의 전체 경우의 수를 구한 후 중복되는 경우의 수를 빼려고 했고,
 * 해당 풀이는 중복되는 수를 포함한 경우의 수만 더해서 나중에 더 이상 중복되는 수가 없는 수열이 되면
 * 해당 수열의 모든 경우의 수를 더하였다.
 * 
 * 수열의 한 수가 가질 수 있는 최댓값이 10만이기 때문에 long으로 해주어야 함
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13144 {
    // 시간제한 1초, 메모리제한 32MB
    // 길이가 N인 수열에서 연속한 1개 이상의 수를 뽑았을 때 같은 수가 여러 번 등장하지 않는 경우의 수?

    static int[] a;
    static boolean[] visited = new boolean[100001];
    static long ret;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;

        while (right < n) {
            if (!visited[a[right]]) visited[a[right++]] = true;
            else {
                ret += (right - left);
                visited[a[left++]] = false;
            }
        }

        ret += (long)((long)(right - left) * (long)(right - left + 1)) / 2;

        System.out.println(ret);
    }
}
