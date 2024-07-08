/**
 * 구현, 브론즈2, 시간모름
 * 단순 구현 문제였다. 뭔가 누적합으로 풀 수 있을 거 같았는데 아니었음
 * 해당 로직의 시간 복잡도는 입력 3 + 범위 입력 3 * 100 + 로직 100 = 403
 * O(n)
 */

package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] abc = new int[4];
        abc[0] = 0;
        for (int i = 1; i < 4; i++)
            abc[i] = Integer.parseInt(st.nextToken());

        int[] park = new int[101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            for (int j = a + 1; j <= z; j++)
                park[j] += 1;
        }

        
        int sum = 0;
        for (int i = 1; i < 101; i++)
            sum += (abc[park[i]] * park[i]);

        System.out.println(sum);
    }
}
