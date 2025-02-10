package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<N; i++) {
            if(arr[i] == 0) continue;
            if(i + 2 < N) {
                if(arr[i+1] == 0) {
                    sum += 3*arr[i];
                    arr[i] = 0;
                    continue;
                }
                if(arr[i+2] == 0) {
                    int min = Math.min(arr[i], arr[i + 1]);
                    sum += 5 * min;
                    if(arr[i] != min) {
                        sum += 3*(arr[i]-min);
                    }
                    arr[i] = 0;
                    arr[i+1] -= min;
                    continue;
                }
                if(arr[i+1] > arr[i+2]) {
                    int dif = arr[i+1] - arr[i+2];
                    int min = Math.min(arr[i], dif);
                    arr[i] -= min;
                    arr[i+1] -= min;
                    sum += 5 * min;
                    if(arr[i] == 0) continue;
                }
                int min = Math.min(arr[i], Math.min(arr[i+1], arr[i+2]));
                sum += 7 * min;
                if(arr[i] == min) {
                    arr[i] = 0;
                    arr[i+1] -= min;
                    arr[i+2] -= min;
                    continue;
                }
                if(arr[i+1] == min) {
                    sum += 3*(arr[i]-min);
                    arr[i] = 0;
                    arr[i+1] -= min;
                    arr[i+2] -= min;
                    continue;
                }
                if(arr[i+2] == min) {
                    arr[i] -= min;
                    arr[i+1] -= min;
                    arr[i+2] -= min;
                    int min2 = Math.min(arr[i], arr[i + 1]);
                    sum += 5 * min2;
                    if(arr[i] != min2) {
                        sum += 3*(arr[i]-min2);
                    }
                    arr[i] = 0;
                    arr[i+1] -= min2;
                }
            }
            else if(i + 1 < N) {
                if(arr[i+1] == 0) {
                    sum += 3*arr[i];
                    arr[i] = 0;
                    continue;
                }
                int min = Math.min(arr[i], arr[i + 1]);
                sum += 5 * min;
                if(arr[i] != min) {
                    sum += 3*(arr[i]-min);
                }
                arr[i] = 0;
                arr[i+1] -= min;
            }else {
                sum += 3*arr[i];
                arr[i] = 0;
            }
        }

        System.out.println(sum);
    }
}