package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
    static int k;
    static int[] arr;
    static int[] res;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            res = new int[6];

            comb(0, 0);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void comb(int depth, int start) {
        if (depth == 6) {
            for (int val : res) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            res[depth] = arr[i];
            comb(depth + 1, i + 1);
        }
    }
}
// S2 로또 백트래킹 조합 DFS
// 5분
// 걍 쉽게 풀었다
// 일단 입력을 k 가 0일때 탈출조건으로 돌리고 StringBuilder 가변객체는 루프 전에 생성한다
// 그리고 arr 은 이미 오름차순으로 입력이 주어지고
// 여기서 res 라는 로또의 값을 구하는 배열을 생성하고 오름차순으로 주어진 arr 과 k개 숫자중 6개를 선택해야했다.
// 조합을 돌린다.
// 조합은 현재의 위치를 기억해서 현재 인덱스보다 더 뒤에꺼를 선택해야되고 즉 더 큰수이고
// res 로 덮어 쓰기가 된다 백트래킹은 depth의 값을 안바꾼채로 라서
// 그래서 visit와 before 는 안써도됐다 숫자는 중복이 없고 visit 는 순열에서 보통쓰니까?
