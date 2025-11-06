package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16434 {
    static long MAX_HP, attack;
    static int N;
    static dungeon[] dungeons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        attack = Long.parseLong(st.nextToken());

        dungeons = new dungeon[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            long t = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());
            dungeons[i] = new dungeon(t, a, h);
        }
        lowerBound();
        System.out.println(MAX_HP);
    }

    static void lowerBound() {
        long lo = 0;
        long hi = Long.MAX_VALUE;

        while (lo + 1 < hi) {
            long mid = (hi - lo) / 2 + lo;

            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        MAX_HP = hi;
    }

    static boolean check(long maxHP) {
        long currentHP = maxHP;
        long currentAttack = attack;

        for (int i = 0; i < N; i++) {
            if (dungeons[i].t == 1) {
                long monsterAttack = dungeons[i].a;
                long monsterHP = dungeons[i].h;

                long cnt = (monsterHP + currentAttack - 1) / currentAttack;

                currentHP -= monsterAttack * (cnt - 1);

                if (currentHP <= 0) {
                    return false;
                }
            } else {
                currentAttack += dungeons[i].a;
                currentHP += dungeons[i].h;

                if (currentHP > maxHP) {
                    currentHP = maxHP;
                }
            }
        }
        return true;
    }

    static class dungeon {
        long t;
        long a;
        long h;

        public dungeon(long t, long a, long h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }
}
// G4 드래곤 앤 던전 이분탐색
// 113분
// 와,, 간만에 벽느끼는 문제 다시 풀어서 곱씹어 봐야 할듯