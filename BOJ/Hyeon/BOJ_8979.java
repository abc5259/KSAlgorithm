package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Nation[] nations = new Nation[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            nations[i] = new Nation(num, gold, silver, bronze);
        }

        Arrays.sort(nations);

        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (nations[i].num == K) {
                idx = i;
                break;
            }
        }

        while (idx > 0) {
            if ((nations[idx].gold == nations[idx - 1].gold) && (nations[idx].silver == nations[idx - 1].silver) && (nations[idx].bronze == nations[idx - 1].bronze)) {
                idx--;
            } else {
                break;
            }
        }

        System.out.println(idx + 1);
    }

    static class Nation implements Comparable<Nation> {
        int num;
        int gold;
        int silver;
        int bronze;

        Nation(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation n) {
            if (this.gold == n.gold) {
                if (this.silver == n.silver) {
                    if (this.bronze == n.bronze) {
                        return this.num - n.num;
                    }
                    return n.bronze - this.bronze;
                }
                return n.silver - this.silver;
            }
            return n.gold - this.gold;
        }
    }
}
// S5 올림픽 정
// 30분
// 각 나라를 메달별로 정렬한 다음
// 구하고자 하는 K의 나라의 인덱스를 구한다
// 그 나라보다 앞에 있는 나라들이 만약 같은 메달일 경우 내 등수는 현저히 줄어든다
// 그래서 idx 가 만약에 0이면 바로 1등이 출력되면 되고
// idx 가 0이상일 경우 나보다 앞의 나라랑 비교했을 떄 같다면 idx 를 줄여서 등수를 줄일 수 있고
// 다르다면 그냥 그대로 idx + 1이 등수가 된다.