/**
 * 2559 - 수열
 * 슬라이딩 윈도우, 실버3, 시도2
 * 첨에 조합, 순열로 풀 수 있다고 생각했는데, 조합이나 순열은 배열 안에서 무작위로 뽑는 경우의 수이기 때문에 문제 취지에 맞지 않는다.
 * 그래서 단순하게 슬라이딩 윈도우를 생각해서 풀었다.
 * 시간 복잡도는 N = 100,000 | K = 50,000 일 때가 최악이고 계산해보면 25억이 나옴.
 */
package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;

        int[] temp = new int[100000];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 100000; i++)
            temp[i] = i;

        for (int i = 0; i <= N - K; i++) {
            int sum = 0;
            for (int j = i; j < i + K; j++)
                sum += temp[j];
            if (max < sum) max = sum;
        }

        System.out.println(max);
    }
}
