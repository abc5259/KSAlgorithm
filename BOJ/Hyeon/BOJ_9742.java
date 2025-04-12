package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9742 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            StringTokenizer st = new StringTokenizer(str);
            String arr = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            sb.append(arr).append(" ").append(num).append(" = ");

            char[] c = arr.toCharArray();

            boolean isPerm = true;

            while (num-- > 1) {
                if (!perm(c)) {
                    isPerm = false;
                    break;
                }
            }
            if (isPerm) {
                sb.append(c);
            } else {
                sb.append("No permutation");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static boolean perm(char[] input) {
        int left = input.length - 1;
        while (left > 0 && input[left - 1] > input[left]) {
            left--;
        }
        if (left == 0) {
            return false;
        }
        int right = input.length - 1;
        while (left < right && input[left - 1] > input[right]) {
            right--;
        }
        swap(left - 1, right, input);

        right = input.length - 1;

        while (left < right) {
            swap(left, right, input);
            left++;
            right--;
        }
        return true;
    }

    static void swap(int a, int b, char[] input) {
        char tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
}

// S3 순열 순열
// 일단 입력값이 EOF일 떄까지를 읽는 br.readLine !=null && !br.readLine.isEmpty
// 이거를 알고 진행해야되고 toChar로 읽으면 되고 그다음
// perm을 통해서 확인한다.
// stringBuilder로 입력값을 계속해서 누적으로 더해야되고
// flag를 통해 조건 분기한다.