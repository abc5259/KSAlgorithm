package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input = "";

        while((input = br.readLine()) != null) {
            int X = Integer.parseInt(input) * 10000000;
            int N = Integer.parseInt(br.readLine());

            int[] holeArr = new int[N];
            for(int i=0; i<N; i++) {
                holeArr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(holeArr);
            int l = 0;
            int r = N-1;

            boolean answer = false;
            int[] result = new int[2];
            while (l < r) {
                int sum = holeArr[l] + holeArr[r];

                if(sum == X) {
                    answer = true;
                    result[0] = holeArr[l];
                    result[1] = holeArr[r];
                    break;
                }

                if(sum > X) {
                    r--;
                }else {
                    l++;
                }
            }

            sb.append(answer ? "yes " + result[0] + " " + result[1] + "\n": "danger\n");
        }
        System.out.println(sb);
    }
}

