package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18222 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        System.out.println(recursion(k));
    }

    static int recursion(long k) {
        if (k == 1) {
            return 0;
        }
        long len = 1;
        while (len < k) {
            len <<= 1;
        }

        return 1 - recursion(k - (len >> 1));
    }
}

// S2 투에-모스 문자열 재귀
// 일단 기존에는 k값보다 큰 2의 제곱수를 구하는 저장하는 배열을 만들어서 꺼내는 방식으로 접근했는데
// 일단 입력값의 k를 넣고 이보다 큰 제곱수를 len으로 구한다음 k는 len의 반 이상에 있을 것이다 왜냐하면
// 반 이하에 있는 경우는 k가 len 보다 1개 더 작은거에 있어야 하기 때무네
// 그래서 k - len>>1 한 값에 대해서 다시 재귀한다 그래서 끝까지 반복해서 내려가서 구한다