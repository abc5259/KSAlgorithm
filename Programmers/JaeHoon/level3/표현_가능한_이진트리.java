package Programmers.JaeHoon.level3;

public class 표현_가능한_이진트리 {

    class Solution {

        public int[] solution(long[] numbers) {
            int[] answer = new int[numbers.length];
            String[] numStr = new String[numbers.length];
            for(int i=0; i<numbers.length; i++) {
                if(numbers[i] == 1) {
                    answer[i] = 1;
                    continue;
                }
                numStr[i] = Long.toBinaryString(numbers[i]);
                int k = 0;
                while((int)Math.pow(2,k) - 1 < numStr[i].length()) {
                    k++;
                }
                int len = (int)Math.pow(2,k) - 1;
                int dif =len - numStr[i].length();
                for(int j=0; j<dif; j++) {
                    numStr[i] = 0 + "" + numStr[i];
                }
                // System.out.println(numStr[i]);
                if(solve(0,numStr[i].length()-1,numStr[i],false)) answer[i] = 1;
                else answer[i] = 0;


                // System.out.println();
            }

            // solve(0,3-1,"111");

            return answer;
        }
        public boolean solve(int start, int end, String str, boolean isZero) {
            // System.out.println("start = " + start + " end = " + end);
            int total = end - start + 1;
            if(total == 3) {
                if(isZero || str.charAt(start + total / 2) == '0') {
                    for(int i=start; i<=end; i++) {
                        if(str.charAt(i) != '0') return false;
                    }
                    return true;
                }

                return true;
            }

            int mid = start + total / 2;
            if(isZero) {
                if(str.charAt(mid) != '0') return false;
            }else {
                isZero = str.charAt(mid) == '0';
            }

            if(!solve(start, mid - 1,str,isZero)) return false;
            if(!solve(mid + 1, end,str,isZero)) return false;

            return true;
        }
    }
}
