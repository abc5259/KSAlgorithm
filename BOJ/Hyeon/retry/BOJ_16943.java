package BOJ.Hyeon.retry;

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

        if (arr[0] == '0') {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != '0') {
                    swap(0, i);
                    break;
                }
            }
        }

        if (A.length() > B.length()) {
            System.out.println(-1);
        } else {
            do {
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
            } while (next_perm());
            System.out.print(res);
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

// S1 숫자 재배치 순열
// 일단 리팩토링 했다 고려해야될 조건이 상당히 까다롭다
// Trouble shooting
// 1. 숫자의 길이로 판단해서 A가 더 길면 일단 -1 도출
// 2. 처음부터 res 에 집어넣으면 안된다. 왜냐하면 순열로 구하기 때문에 424 같은 경우는 244로 돌아가서 시작해야된다.
// 3. 맨앞에 0이 나오면 안된다. 0111 이런거는 문제조건에서 방지 하기 때문에 오름차순으로 정렬하고
// 맨앞이 0일경우 0이 아닌 가장 맨앞 수를 골라서 swap 한다
// 나머지는 넥스트 퍼뮤테이션을 지켜서 했다.
// 그리고 문자배열을 정수로 만드는 과정이 있엇는데 나는 단순하게 StringBuilder 를 써서 해결했다
// 반복문으로 *= 10 해도 되는 방법이 있다.
