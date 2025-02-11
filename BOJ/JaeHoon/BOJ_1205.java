package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] arr = new int[P];
        Arrays.fill(arr,-1);
        if(N > 0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        int grade = 0;
        for(int i=0; i<P; i++) {
            if(i - 1 >= 0 && arr[i] == -1) {
                if(score == arr[i-1]) {
                    System.out.println(grade);
                }else {
                    System.out.println(grade + cnt);
                }
                return;
            }
            if(i - 1 >= 0 && arr[i] < score && arr[i-1] == score) {
                System.out.println(grade);
                return;
            }
            if(i != 0 && arr[i-1] == arr[i]) {
                cnt++;
            } else {
                grade += cnt;
                cnt = 1;
            }
            if(arr[i] < score) {
                System.out.println(grade);
                return;
            }
        }
        if(N < P) {
            if(score == arr[P-1]) {
                System.out.println(grade);
            }else {
                System.out.println(grade + cnt);
            }
        } else {
            System.out.println(-1);
        }
    }
}
//10 1 11
//10 9 8 7 6 5 4 3 2 1