package Programmers.JaeHoon.level2;

import java.util.*;

public class 호텔_대실 {

    class Solution {
        public int solution(String[][] book_time) {
            int answer = 0;
            Arrays.sort(book_time, (a,b) -> a[0].compareTo(b[0]));

            ArrayList<String> rooms = new ArrayList<>();
            for(int i=0; i<book_time.length; i++) {
                boolean isOk = false;
                String end = null;
                int idx = -1;
                for(int j=0; j<rooms.size(); j++) {
                    if(book_time[i][0].compareTo(rooms.get(j)) >= 0) {
                        isOk = true;
                        if(idx == -1) {
                            idx = j;
                            end = rooms.get(j);
                        }
                        else {
                            if(rooms.get(j).compareTo(end) > 0) {
                                end = rooms.get(j);
                                idx = j;
                            }
                        }
                    }
                }
                String[] time = book_time[i][1].split(":");
                int m = (Integer.valueOf(time[1])+ 10);
                String h = m < 60 ? time[0] : (Integer.valueOf(time[0]) + 1) + "";
                m = m < 60 ? m : m % 60;
                String mStr = (m+"").length() == 1 ? "0"+m: m+"";
                String hStr = h.length() == 1 ? "0"+h: h+"";
                end = hStr + ":" + mStr;

                if(isOk) {
                    rooms.set(idx,end);
                }else {
                    rooms.add(end);
                }
            }

            return rooms.size();
        }
    }
}
