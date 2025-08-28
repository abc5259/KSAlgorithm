package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] cnt = new int[1_000_001];
        int[] res = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }

        for (int i = 0; i < N; i++) {
            res[i] = cnt[arr[i]];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && res[stack.peek()] < res[i]) {
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int ngf : res) {
            sb.append(ngf).append(" ");
        }
        System.out.print(sb);
    }
}
// G3 오등큰수 스택
// 일단 3개의 배열 arr, cnt, res 를 쓴다.
// arr -> 입력받은 숫자를 저장하는 배열이고 동시에
// cnt -> 빈도세기 cnt 는 1000001으로 범위를 잡고 숫자의 갯수를 센다.
// res -> 빈도수 배열로 변환해서 arr과 같은 인덱스를 공유하며 arr[i]에 대한 갯수를 저장한다
// res 배열은 오큰수를 찾는 거다. 근데 저장할 때 res를 저장해주는게 아닌 arr 을 해줘야된다. <중요>
// 오큰수 NGE 알고리즘을 통해서 빈도수를 비교하고 stack에서 인덱스를 빼고 그뺀 res 배열에 arr[i] 원본 값을 넣어준다
// 그리고 스택에 push 하고 나머지 스택에 남아있는 인덱스의 값은 다 -1로 처리한다 왜냐면 오큰수가 없기 떄