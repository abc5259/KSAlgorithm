package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for(int i=0; i<N; i++) {
            int low = -1;
            int high = N;
            while (low + 1 < high) {
                int mid = (low + high) / 2;

                if(arr[mid] + arr[i] > 0) {
                    high = mid;
                }
                else if(arr[mid] + arr[i] < 0) {
                    low = mid;
                }
            }
            if(high == N) {
                if(min > Math.abs(arr[i] + arr[low])) {
                    min = Math.abs(arr[i] + arr[low]);
                    answer[0] = arr[i];
                    answer[1] = arr[low];
                }
            }else {
                int dif1 = Math.abs(arr[i] + arr[high]);
                if(low != -1) {
                    int dif2 = Math.abs(arr[i] + arr[low]);
                    if(min > dif2) {
                        min = dif2;
                        answer[0] = arr[i];
                        answer[1] = arr[low];
                    }
                }
                if(dif1 < min) {
                    min = dif1;
                    answer[0] = arr[i];
                    answer[1] = arr[high];
                }
            }
        }

        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
//5
//5 -7 -8 7 4
