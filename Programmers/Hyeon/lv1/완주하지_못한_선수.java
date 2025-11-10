package Programmers.Hyeon.lv1;

import java.util.HashMap;

public class 완주하지_못한_선수 {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> p = new HashMap<>();
            for (String part : participant) {
                p.put(part, p.getOrDefault(part, 0) + 1);
            }

            for (String c : completion) {
                p.replace(c, p.get(c) - 1);
            }

            for (String key : p.keySet()) {
                if (p.get(key) != 0) {
                    return key;
                }
            }
            return "";
        }
    }
}
// lv1 완주하지 못한 선수 해쉬맵
// 20분
// 계속 효율성을 통과못함 그냥 막 2개 해쉬맵 만들고 공간 잡고 했는데 안되나봄
// 일단 먼저 참가자를 카운팅을 한다 왜냐하면 동명이인이 있을 수 있다고 해서 그래서
// p로 카운팅 한다음에 여기서 완주자를 제거하면된다 이때
// replace vs put
// 나는 replace 라고 생각하고 했다 왜냐하면 기존의 키가있을 때 밸류만 바꿔줘야되기때문
// 근데 replace 와 put 차이가 그거가 맞다고 한다
// put 은 키 값이 없어도 상관없고 replace 는 있어야 한다
// 그렇게 해서 완주자를 제거하고 참가자의 맵을 탐색해서 정답을 찾는과정