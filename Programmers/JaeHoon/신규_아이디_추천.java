package Programmers.JaeHoon;


public class 신규_아이디_추천 {
  class Solution {
    public String solution(String new_id) {
        new_id = step_1(new_id);
        new_id = step_2(new_id);
        new_id = step_3(new_id);
        new_id = step_4(new_id);
        new_id = step_5(new_id);
        new_id = step_6(new_id);
        new_id = step_7(new_id);
        return new_id;
    }
    public String step_1(String id) {
        return id.toLowerCase();
    }
    public String step_2(String id) {
        String newId = "";
        for(int i=0; i<id.length(); i++) {
            char c = id.charAt(i);
            if(!(c >= 'a' && c<='z') && !(c - '0' >=0 && c - '0' <= 9) && c != '-' && c != '_' && c != '.' )
                continue;
            newId += c+"";
        }
        return newId;
    }
    public String step_3(String id) {
        String newId = "";
        int dotLength = 0;
        boolean isDot = false;
        for(int i=0; i<id.length(); i++) {
            char c = id.charAt(i);
            if(c == '.') {
                if(isDot) {
                    isDot = true;
                    continue;
                }
                newId += c+"";
                isDot = true;
            }else {
                isDot = false;
                newId += c+"";
            }
        }
        return newId;
    }
    public String step_4(String id) {
        
        if(id.charAt(0) == '.') {
            id = id.substring(1,id.length());
        }
        if(id.length() > 0 && id.charAt(id.length() - 1) == '.') {
            id = id.substring(0,id.length() - 1);
        }
        return id;
    }
    public String step_5(String id) {
        if(id.equals("")) {
            return "a";
        }
        return id;
    }
    public String step_6(String id) {
        if(id.length() >= 16) {
            String newId = id.substring(0,15);
            if(newId.charAt(newId.length()-1) == '.') {
                return newId.substring(0,14);
            }
            return newId;
        }
        return id;
    }
    public String step_7(String id) {
        if(id.length() <= 2) {
            char endC = id.charAt(id.length() - 1);
            while(id.length() < 3) {
                id += endC+"";
            }
            return id;
        }
        return id;
    }
  }
}
