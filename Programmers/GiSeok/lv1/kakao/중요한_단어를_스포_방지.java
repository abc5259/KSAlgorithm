package Programmers.GiSeok.lv1.kakao;

import java.util.*;

public class 중요한_단어를_스포_방지 {

    public int solution(String message, int[][] spoiler_ranges) {
        StringBuilder spoilerMessage = new StringBuilder(message);
        for (int i = 0; i < spoiler_ranges.length; i++) {
            for (int idx = spoiler_ranges[i][0]; idx <= spoiler_ranges[i][1]; idx++) {
                char ch = spoilerMessage.charAt(idx);

                if (ch != ' ') spoilerMessage.setCharAt(idx, '-');
            }
        }

        String[] split = spoilerMessage.toString().split(" ");
        Set<String> used = new HashSet<>();
        for (int i = 0; i < split.length; i++) used.add(split[i]);

        String[] original = message.split(" ");
        int ans = 0;
        for (int i = 0; i < original.length; i++) {
            if (!used.contains(original[i])) {
                ans++;
                used.add(original[i]);
            }
        }

        return ans;
    }
}
