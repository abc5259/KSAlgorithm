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
