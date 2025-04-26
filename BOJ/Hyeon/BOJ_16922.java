package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_16922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> roma = new HashSet<>();
        int[] arr = {1, 5, 10, 50};

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                for (int k = 0; k <= N - j - i; k++) {
                    int l = N - i - j - k;
                    int sum = i * arr[0] + j * arr[1] + k * arr[2] + l * arr[3];
                    roma.add(sum);
                }
            }
        }
        System.out.print(roma.size());
    }
}

// S3 로마 숫자 만들기 브루트포스
// 백트래킹이 아닌 브루트포스로 해결했다. 일단 4개의 수의 갯수에 있어서 연산하면된다.
// N만큼의 갯수를 사용하고 같은 숫자의 중복 사용으로도 가능하지만 숫자의 값이 같을 경우에는 중복이 되면 갯수로 치지
// 않기 때문에 SET 자료구조를 사용해서 맨 앞의 수를 N번 쓰는거부터 해서 마지막의 수를 N번
// 쓰면서 연산되는 합계를 SET에 넣어서 갯수를 구한다.