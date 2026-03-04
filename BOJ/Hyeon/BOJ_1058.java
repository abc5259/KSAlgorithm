package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] relationship = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                relationship[i][j] = line.charAt(j);
            }
        }

        boolean[][] friends = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (relationship[i][j] == 'Y') {
                    friends[i][j] = true;

                    for (int k = 0; k < N; k++) {
                        if (i == k) {
                            continue;
                        }
                        if (relationship[j][k] == 'Y') {
                            friends[i][k] = true;
                        }
                    }
                }
            }
        }

        int max = 0;

        for (boolean[] row : friends) {
            int tmp = 0;
            for (boolean cnt : row) {
                if (cnt) {
                    tmp++;
                }
            }
            max = Math.max(max, tmp);
        }
        System.out.println(max);
    }
}
// S2 친구 구현
// 15분
// 그냥 풀었다
// 깊이가 2개밖에 없고 내가 만약 A 일대 B랑 친구인데 B의 친구인 C D 가 있다면  A 기준으로 3명이기에
// relationship 배열로 친구관계를 입력받고
// i 기준 사람일때 j 가 Y면 내친구이고 이를 friends 에 true 로 표시해두고 그 Y인 친구에서 N번
// 반복문 돌려서 Y일때도 friends[i][k] 를 true 해서 중복과 A와 A 가 안되게 조건 분기해서 max 값을 반환