package Programmers.JaeHoon;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {
  public static void main(String[] args) {
    Solution s = new Solution();
    s.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
  }
  static class Solution {
    public ArrayList<String> solution(String[] record) {
        int N = record.length;
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String,String> user = new HashMap<>();
        ArrayList<String[]> recordSplit = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String[] arr = record[i].split(" ");
            String id = arr[1];
            if(!arr[0].equals("Leave")) {
                String name = arr[2];
                user.put(id, name);   
            }
            if(!arr[0].equals("Change")) {
                recordSplit.add(new String[]{arr[0],id});
            }
        }
        for(int i=0; i<recordSplit.size(); i++) {
            String name = user.get(recordSplit.get(i)[1]);
            if(recordSplit.get(i)[0].equals("Enter")) {
                answer.add(name + "님이 들어왔습니다.");
            }
            else{
                answer.add(name + "님이 나갔습니다.");
            }
        }
        return answer;
    }
}
}
