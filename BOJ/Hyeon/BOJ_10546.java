package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> participants = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            participants.put(name, participants.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < N - 1; i++) {
            String name = br.readLine();
            int cnt = participants.get(name);
            if (cnt > 1) {
                participants.put(name, cnt - 1);
            } else {
                participants.remove(name);
            }
        }

        for (String res : participants.keySet()) {
            System.out.println(res);
        }
    }
}
// S4 배부른 마라토너 HashMap
// 9분
// 그냥 맵에 넣고 빼버렸다 put 으로 -1 된 값을 하기도 하고 remove 로 map 에서 지우기도 했다
// 동명이인을 처리하는게 목적이고 N은 10만인데 Map 은 삽입 삭제 조회가 O(1) 로 접근가능
// 또 동명이인은 갯수로 따지면 value 값을 늘려주면 됐다. 중복 처리가 가능한 Map 사용