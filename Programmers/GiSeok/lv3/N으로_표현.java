package Programmers.GiSeok.lv3;

import java.util.*;

public class N으로_표현 {

    public int solution(int N, int number) {

        // N
        // 2
        // 2 + 2, 2 / 2, 2 - 2, 2 * 2
        // 22 + 2, 22 * 2, 22 / 2, 22 - 2
        // 2 + 2 + 2, 2 + 2 * 2, 2 + 2 / 2, 2 + 2 - 2
        // 2 * 2 + 2, 2 * 2 * 2, 2 * 2 / 2, 2 * 2 - 2
        // 2 / 2 + 2, 2 / 2 * 2, 2 / 2 / 2, 2 / 2 - 2
        // 2 - 2 + 2, 2 - 2 * 2, 2 - 2 / 2, 2 - 2 - 2

        List<Set<Integer>> p = new ArrayList<>();
        for (int i = 0; i < 9; i++) p.add(new HashSet<>());

        p.get(1).add(N);

        for (int i = 2; i < 9; i++) {
            Set<Integer> now = p.get(i);

            for (int j = 1; j < i; j++) {
                Set<Integer> a = p.get(j);
                Set<Integer> b = p.get(i - j);

                for (int c : a) {
                    for (int d : b) {
                        now.add(c + d);
                        now.add(c - d);
                        now.add(c * d);

                        if (c != 0 && d != 0) now.add(c / d);
                    }
                }
            }

            now.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for (int i = 1; i < 9; i++) {
            if (p.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
