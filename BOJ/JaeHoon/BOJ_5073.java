package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[3];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
            Arrays.sort(arr);
            if(arr[2] >= arr[0] + arr[1]) sb.append("Invalid");
            else if(arr[0] == arr[1]  && arr[1] == arr[2]) sb.append("Equilateral");
            else if(arr[0] != arr[1] && arr[1] != arr[2]) sb.append("Scalene");
            else sb.append("Isosceles");

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
