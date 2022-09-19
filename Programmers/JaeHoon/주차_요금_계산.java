package Programmers.JaeHoon;

import java.util.*;

public class 주차_요금_계산 {

class Solution {
    public ArrayList<Integer> solution(int[] fees, String[] records) {
        Map<String,ArrayList<String[]>> map = new HashMap<String,ArrayList<String[]>>();
        for(String record: records) {
            String[] splitRecord = record.split(" ");
            int minutes = getMinutes(splitRecord[0]);
            String key = splitRecord[1];
            String InAndOut = splitRecord[2];
            
            if(map.containsKey(key)) {
                if(InAndOut.equals("IN")) {
                    map.get(key).add(new String[]{String.valueOf(minutes),InAndOut});
                }else {
                    int size = map.get(key).size();
                    int prevMinutes = Integer.parseInt(map.get(key).get(size-1)[0]);
                    minutes -= prevMinutes;
                    map.get(key).set(size-1,new String[]{String.valueOf(minutes), InAndOut});
                }
            }else {
                ArrayList<String[]> value = new ArrayList<>();
                value.add(new String[]{String.valueOf(minutes),InAndOut});
                map.put(key, value);
            }
        }
        int lastMinutes = getMinutes("23:59");
        ArrayList<String[]> result = new ArrayList<>();
        for(Map.Entry<String,ArrayList<String[]>> entry : map.entrySet()) {
            String key = entry.getKey();
	        ArrayList<String[]> arr = entry.getValue();
            System.out.println("key = " + key);
            int sum = 0;
            for(int i=0; i<arr.size(); i++) {
                if(arr.get(i)[1].equals("OUT")) sum += Integer.parseInt(arr.get(i)[0]);
                else {
                    int prevMinutes = Integer.parseInt(arr.get(i)[0]);
                    sum += lastMinutes - prevMinutes;
                }
            }
            System.out.println(sum);
            result.add(new String[]{key,String.valueOf(getCost(sum,fees))});            
        }
        Collections.sort(result,(String[] a, String[] b) -> {
            return a[0].compareTo(b[0]);
        });
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<result.size(); i++)
            answer.add(Integer.parseInt(result.get(i)[1]));
        return answer;
    }
    public int getMinutes(String s) {
        return Integer.parseInt(s.substring(0,2)) * 60 + Integer.parseInt(s.substring(3,5));
    }
    public int getCost(int sum,int[] fees) {
        if(sum <= fees[0]) {
            return fees[1];
        }else {
            int basic = fees[1];
            int c = (sum - fees[0]) / fees[2];
            if((sum - fees[0]) % fees[2] == 0)  {
                basic += (c * fees[3]);
            }else {
                basic += ((c+1)* fees[3]);
            }
            return basic;
        }
    }
}
}
