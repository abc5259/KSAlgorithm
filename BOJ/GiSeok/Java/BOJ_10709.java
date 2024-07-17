/**
 * 10709 - 기상캐스터 [성공|00:14:20]
 * 실버5, 구현, 시도1
 * 
 * 도시의 구역을 입력받을 때마다 해당 구역이 구름이면 0, 구름이 있음을 표시하고
 * 다음 구역부터는 이전 구역 + 1을 저장한다.
 * 만약 계속해서 구름이 나오지 않으면 구름이 있음이 표시되지 않으니까 계속 -1이 저장됨
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10709 {
    // 세로 H, 가로 W인 직사각형으로 된 도시 JOI
    // 각 구역의 하늘에는 구름이 있을 수도 있고 없을 수도 있다.
    // 모든 구름은 1분마다 1칸씩 동쪽으로 이동
    // 각 구역에 대해 몇 분뒤 하늘에 구름이 오는지를 예측

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] city = new int[H][W];
        for (int i = 0; i < H; i++) {
            String sectors = br.readLine();

            boolean flag = false;
            for (int j = 0; j < W; j++) {
                char sector = sectors.charAt(j);

                if (sector == 'c') { city[i][j] = 0; flag = true; }

                if (!flag) city[i][j] = -1;
                else if (flag && sector != 'c') city[i][j] = city[i][j - 1] + 1;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(city[i][j] + " ");
            }
            System.out.println();
        }
    }
}
