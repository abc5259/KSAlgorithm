package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M >= 7 && N >= 3) {
            System.out.println(5 + M - 7);
        } else if (N >= 3) {
            System.out.println(Math.min(4, M));
        } else if (N == 2) {
            System.out.println(Math.min(4, (M + 1) / 2));
        } else {
            System.out.println(1);
        }
    }
}
// S3 병든 나이트 조건분기, 그리디 복습 실패
// 55분
// N 과 M이 20억이길래 절대 좌표평면은 아니겠다 싶었다 메모리 초과고려해서
// trouble shooting. 조건 분기 1개 실패.
// 그림을 그려보니 N과 M이 3과 7보다 크면 4개이상으로 계속해서 그릴 수 있었다 M 만 고려해서 지그재그하면된다.
// 그럼 1칸에 1개라서 앞에 5개 칸 만들어졌고 M개 만큼 생기고 - 7 해주면된다 5개 만든칸의 개수가7개이기에
// 그리고 N이 3보다 크거나같고 M이 작으면 어찌됐든 최대가 4인데 M의 길이에 따라 우측위로만 쭊쭉가면 되니까 4랑 함께 최소값을 구해서
// M이 더 작으면 그 값을 출력하게
// 그리고 N이 2면 M이 +1칸 /2 한 개수만큼 가질 수 있어서 이도 4와 최소를 가지게 하고
// 나머지는 1칸이다.