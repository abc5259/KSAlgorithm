package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Game[] gamer = new Game[N];

        int[] arr = new int[5];
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 5; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    for (int k = j + 1; k < 5; k++) {
                        max = Math.max(max, (arr[i] + arr[j] + arr[k]) % 10);
                    }
                }
            }
            gamer[t] = new Game(t + 1, max);
        }
        Arrays.sort(gamer);

        System.out.println(gamer[0].num);
    }

    static class Game implements Comparable<Game> {
        int num;
        int value;

        public Game(int num, int value) {
            this.num = num;
            this.value = value;
        }

        @Override
        public int compareTo(Game g) {
            if (this.value == g.value) {
                return g.num - this.num;
            }
            return g.value - this.value;
        }
    }
}
// S5 숫자 게임 정렬
// 19분
// N 은 1000이고 O(5^3) 에대해선 문제없을거 같아서 조합을 구하는거니까 그냥 3중 반복문 썼다
// 좀 컸으면 DFS 를 썼을 거 같은데,, 그리고 NlogN으로 끝
// 그냥 gamer 에 대해서 value 별로 순서를 정렬해서 num 이 가장 큰거를 가져야된다
// 그래서 Game 이라는 클래스를 통해 번호와 1의 자리수의 값을 필드로 가져서
// 해당 클래스의 배열을 N 개 만들고 또 이를 Comparable 을 통해 정렬을 해서 2개의 비교 즉
// 1의자리합과 또 그게 같다면 num 을 내림차순하여서 가장 큰 num과 value 를 얻은 0 번 인덱스를 반환
