package BOJ.JaeIk.programmers;

import java.util.*;

class JadenCase문자열만들기 {
    static StringBuilder sb = new StringBuilder();

    public String solution(String s) {
        String[] tokens = s.split(" ");

        for(int i=0; i<tokens.length; i++){
            String now = tokens[i];
            String change = "";

            if(now.length() == 0)change+=" ";
            else{
                change += now.substring(0, 1).toUpperCase();
                change += now.substring(1, now.length()).toLowerCase();
                change += " ";
            }

            sb.append(change);
        }

        String answer = sb.toString();

        if(s.substring(s.length()-1, s.length()).equals(" "))return answer;
        else return answer.substring(0, answer.length()-1);
    }
}