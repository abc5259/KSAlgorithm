package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10];

        while (N > 0) {
            arr[N % 10]++;
            N /= 10;
        }

        int tmp = 0, max = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                tmp += arr[i];
            } else {
                max = Math.max(max, arr[i]);
            }
        }

        if (tmp % 2 == 1) {
            max = Math.max(max, tmp / 2 + 1);
        } else {
            max = Math.max(max, tmp / 2);
        }
        System.out.println(max);
    }
}

// S5 방 번호 구현
// 쉽게 풀었다.
// 주어진 N을 문자로 볼 수 있고 charAt 을 써서 나는 N의 자연수라고 해서 while 문으로 끝자리만 반복해서 계산했다
// 배열을 통해서 각 수의 합을 구하고 6과 9는 몰빵해서 /2 해도 되고 나처럼 tmp 변수를 둬서 6과 9의 합을 따로 구한다음
// 홀수일 때와 짝수일 때를 구분해서 연산하였다.