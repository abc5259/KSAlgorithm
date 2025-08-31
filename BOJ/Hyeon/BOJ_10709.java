package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] sky = new int[H][W];

        for (int i = 0; i < H; i++) {
            String weather = br.readLine();
            for (int j = 0; j < W; j++) {
                if (weather.charAt(j) == 'c') {
                    sky[i][j] = 0;
                } else {
                    if (j > 0 && sky[i][j - 1] >= 0) {
                        sky[i][j] = sky[i][j - 1] + 1;
                    } else {
                        sky[i][j] = -1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int[] line : sky) {
            for (int cloud : line) {
                sb.append(cloud).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
// S5 기상캐스터 시뮬레이션
// 그냥 쉽게 조건 걸어서 풀었다.
// 날씨 라인을 입력받고 여기서 c 라면 0으로 채우고
// . 일때는 이게 c가 앞에 있는지에 대한 여부를 봐야되기 때문에 맨 앞칸을 제외한 j > 0과
// sky[i][j-1] 이 -1이 아니라면 그냥 앞칸 +1 해버리면되고 아니면 -1 대입하면된다.