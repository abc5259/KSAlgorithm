package Programmers.Hyeon.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 오픈채팅방 {
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<String> a = s.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        for (String string : a) {
            System.out.println(string);
        }
    }

    static class Solution {
        public ArrayList<String> solution(String[] record) {
            StringTokenizer st;
            HashMap<String, String> hashMap = new HashMap<>();
            ArrayList<String[]> result = new ArrayList<>();
            ArrayList<String> answer = new ArrayList<>();

            for (String s : record) {
                st = new StringTokenizer(s);
                String action = st.nextToken();
                String id = st.nextToken();

                if (action.equals("Enter")) {
                    String nickname = st.nextToken();
                    hashMap.put(id, nickname);
                    result.add(new String[]{action, id});

                } else if (action.equals("Leave")) {
                    result.add(new String[]{action, id});

                } else if (action.equals("Change")) {
                    String nickname = st.nextToken();
                    hashMap.put(id, nickname);
                }
            }
            for (int i = 0; i < result.size(); i++) {
                String name = hashMap.get(result.get(i)[1]);
                if (result.get(i)[0].equals("Enter")) {
                    answer.add(name + "님이 들어왔습니다.");
                } else {
                    answer.add(name + "님이 나갔습니다.");
                }
            }
            return answer;
        }
    }
}

// 2019 카카오 블라인드 리크루트먼트 오픈채팅방
// 로직은 생각해서 구현했지만 값이 변경되지 않았다 이는 출력할 문자열을 미리 어레이 리스트로 만들어뒀더니
// 문자열로 해석해서 hashMap에서 put 해서 값을 바꾸더라도 어레이리스트의 내용에는 달라지지않는다
// 그래서 어레이리스트에는 action과 id를 넘겨서 해당 action 일경우 id를 이용하여 value값인 nickname을 반환받아서
// 문자열로 출력한다.
