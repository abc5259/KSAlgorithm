package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] flag = new boolean[N];
        int cnt = 0;
        for(int i=0; i<N; i++) {
            int prev = i - 1 == -1 ? N-1 : i-1;
            int next = (i + 1) % N;
            if(arr[i] + 1 == arr[next]) continue;
            if(arr[i] == N && arr[next] == 1) continue;
            if(arr[prev] + 1 == arr[i]) continue;
            if(arr[prev] == N && arr[i] == 1) continue;

            cnt++;
            flag[i] = true;
        }

        for(int k=1; k<N; k++) {
            int[] arrResult = pushRight(arr, k, N);
            boolean[] flagResult = pushRight(flag, k, N);

            int start = 0;
            for(int i=0; i<N; i++) {
                if(flagResult[i]) {
                    start = i;
                    break;
                }
            }

            boolean check = true;
            for(int i=start; i<start+cnt; i++) {
                if(i >= N) {
                    check = false;
                    break;
                }
                if(!flagResult[i]) {
                    check = false;
                    break;
                }
            }

            // p < q가 아닌경우
            if(!check) continue;


            reverse(arrResult, start, start + cnt - 1);

            int firstPushCnt = 0;
            for(int i=N-1; i>=0; i--) {
                if(arrResult[i] == N) {
                    firstPushCnt = N - 1 - i;
                }
            }

            if(firstPushCnt == 0) continue;

            System.out.println(firstPushCnt);
            System.out.println((start + 1) + " " + (start + cnt));
            System.out.println(k);
            return;
        }
    }

    static int[] pushRight(int[] arr, int k, int N) {
        int[] temp = new int[N];
        for(int i=0; i<N; i++) {
            int next = (i + k) % N;
            temp[next] = arr[i];
        }
        return temp;
    }

    static boolean[] pushRight(boolean[] arr, int k, int N) {
        boolean[] temp = new boolean[N];
        for(int i=0; i<N; i++) {
            int next = (i + k) % N;
            temp[next] = arr[i];
        }
        return temp;
    }

    static void reverse(int[] arr, int start, int end) {
        int[] temp = arr.clone();

        int idx = end;
        for(int i=start; i<=end; i++) {
            arr[i] = temp[idx];
            idx--;
        }
    }
}
