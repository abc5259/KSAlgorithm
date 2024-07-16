/**
 * 2828 - 사과 담기 게임 [성공|00:14:37]
 * 실버5, 구현, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2828 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int left = 1;
        int ret = 0;
        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine());
            int right = left + M - 1;

            if (left > apple) {
                ret += (left - apple);
                left = apple;
            }
            else if (right < apple) {
                ret += (apple - right);
                left += (apple - right);
            }
        }

        System.out.println(ret);
    }
}
