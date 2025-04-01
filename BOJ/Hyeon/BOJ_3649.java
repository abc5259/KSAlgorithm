package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3649 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (br.ready()) {
            int x = Integer.parseInt(br.readLine()) * 10_000_000;
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            two(arr, x);
        }
        System.out.print(sb);
    }

    private static void two(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;

        boolean isX = false;

        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (sum == x) {
                sb.append("yes").append(" ").append(arr[lo]).append(" ").append(arr[hi]);
                isX = true;
                break;
            } else if (sum > x) {
                hi--;
            } else {
                lo++;
            }
        }

        if (!isX) {
            sb.append("danger");
        }
        sb.append("\n");
    }
}

// G5 로봇 프로젝트 투 포인터
// 개쉽게 풀었는데 한가지 trouble이 있었다.
// trouble shooting
// 입력값이 계속 있다는것을 간과하고 br.readLine을 해버렸다. 그래서 입력을 어떻게 계속 받는지에 대해서
// br.readLine을 해버리면 바로 /n으로 종료로 탈출하기에 시작부터 while 반복문을 설정해야했고
// 탈출에 있어서는 br.ready조건을 사용했다 이는 버퍼에 값이 들어오는지 아닌지를 알 수 있었다.