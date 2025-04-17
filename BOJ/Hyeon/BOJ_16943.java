package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16943 {
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int res = -1;

        String A = st.nextToken();
        String B = st.nextToken();

        arr = A.toCharArray();
        Arrays.sort(arr);

        if (A.length() > B.length()) {
            System.out.println(-1);
        } else {
            if (arr[0] != '0') {
                StringBuilder sb = new StringBuilder();
                for (char c : arr) {
                    sb.append(c);
                }
                int tmp = Integer.parseInt(sb.toString());
                if (tmp < Integer.parseInt(B)) {
                    res = tmp;
                }
            }
            while (next_perm()) {
                if (arr[0] == '0') {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                for (char c : arr) {
                    sb.append(c);
                }
                int tmp = Integer.parseInt(sb.toString());
                if (tmp >= Integer.parseInt(B)) {
                    break;
                } else {
                    res = tmp;
                }
            }
            System.out.println(res);
        }
    }

    static boolean next_perm() {
        int left = arr.length - 1;

        while (left > 0 && arr[left - 1] >= arr[left]) {
            left--;
        }
        if (left == 0) {
            return false;
        }
        int right = arr.length - 1;
        while (arr[left - 1] >= arr[right]) {
            right--;
        }
        swap(left - 1, right);

        right = arr.length - 1;
        while (left < right) {
            swap(left, right);
            left++;
            right--;
        }
        return true;
    }

    static void swap(int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
