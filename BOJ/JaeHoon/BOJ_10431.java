package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int[] arr = new int[20];
            int T = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 20; i++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i] = value;
                for(int j=0; j<i; j++) {
                    if(value < arr[j]) {
                        for(int k=i; k>=j+1; k--) {
                            sum++;
                            arr[k] = arr[k-1];
                        }
                        arr[j] = value;
                        break;
                    }
                }
            }
            sb.append(T).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
