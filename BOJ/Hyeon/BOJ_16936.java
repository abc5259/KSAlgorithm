package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16936 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] B = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(B);

        long[] tmp;
        for (int i = 0; i < N; i++) {
            tmp = new long[N];
            tmp[0] = B[i];
            int idx = 0;

            while (idx < N - 1) {
                long a = tmp[idx] * 2;
                boolean isValid = false;

                for (int j = 0; j < N; j++) {
                    if (B[j] == a) {
                        tmp[++idx] = a;
                        isValid = true;
                        break;
                    }
                }
                if (isValid) {
                    continue;
                }

                if (tmp[idx] % 3 == 0) {
                    long b = tmp[idx] / 3;
                    for (int j = 0; j < N; j++) {
                        if (B[j] == b) {
                            tmp[++idx] = b;
                            isValid = true;
                            break;
                        }
                    }
                }
                if (!isValid) {
                    break;
                }
            }
            if (idx == N - 1) {
                StringBuilder sb = new StringBuilder();
                for (long l : tmp) {
                    sb.append(l).append(" ");
                }
                System.out.print(sb);
            }
        }
    }
}

// G5 나3곱2 브루트포스
// 브루트포스 답게 일단 나3곱2에 대해서 주어진 뒤죽박죽수열을 오름차순으로 정렬하고 1개씩 비교해가면서 한다.
// 모든 수열의 숫자에 있어서 곱2가 되는지 안된다면 나3이 되는지 안된다면 바로 다음 수열로 진행한다.
// 이는 가장 먼저 시작하는 수열을 찾기 위해서 이고 가장 먼저 시작하는 수열을 찾을 경우 idx를 통해 while문으로 계쏙해서 반복한다.
// 중간에 곱2로 된다면 검사할 필요없이 다음 곱2나 나3을 찾기 위해 다시 반복문으로 진행해야되기 때문에 break 를 걸고 continue 문으로 탈출한다.
// 그런데 2개의 조건 곱2 , 나3 둘다 안맞을 경우 해당 while문을 종료하고 다음 수열의 숫자를 전달 받는다.
// 힘들게 스스로 풀었다.