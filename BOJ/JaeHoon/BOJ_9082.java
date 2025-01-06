package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            String str1 = br.readLine();
            int[] items = new int[N];
            for(int i=0; i<N; i++) {
                items[i] = str1.charAt(i) - '0';
            }

            String str2 = br.readLine();
            char[] arr = new char[N];
            for(int i=0; i<N; i++) {
                arr[i] = str2.charAt(i);
            }

            int answer = 0;
            for(int i=0; i<N; i++) {
                if(i == 0) {
                    if(items[i] != 0 && items[i+1] != 0) {
                        items[i]--;
                        items[i+1]--;
                        answer++;
                    }
                }
                else if(i == N-1) {
                    if(items[N-1] != 0 && items[N-2] != 0) {
                        items[N-1]--;
                        items[N-2]--;
                        answer++;
                    }
                }
                else {
                    if(items[i-1] != 0 && items[i] != 0 && items[i+1] != 0) {
                        items[i]--;
                        items[i+1]--;
                        items[i-1]--;
                        answer++;
                    }
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
