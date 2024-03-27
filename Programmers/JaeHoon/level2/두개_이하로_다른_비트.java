package Programmers.JaeHoon.level2;

public class 두개_이하로_다른_비트 {
    class Solution {
        public long[] solution(long[] numbers) {
            long[] answer=new long[numbers.length];

            for(int i=0;i<numbers.length;i++){
                String word=Long.toString(numbers[i],2);
                word="0"+word; //만약 1111이 입력인 경우에는 단 1개도 0으로 바꿀 수 없음.
                int idx1=-1;
                int idx2=-1;

                for(int j=word.length()-1;j>=0;j--){ //오른쪽에서부터 가장 가까운 0의 인덱스를 찾음
                    if(word.charAt(j)-'0'==0){
                        idx1=j;
                        break;
                    }
                }

                for(int j=idx1+1;j<word.length();j++){ //0의 인덱스보다 1 높은 인덱스부터 가장 가까운 1을 찾음
                    if(word.charAt(j)-'0'==1){
                        idx2=j;
                        break;
                    }
                }


                StringBuilder sb=new StringBuilder(word);
                sb.setCharAt(idx1,'1'); //0을 발견한 곳을 1로 바꿔줌.
                if(idx2!=-1){ // 1을 발견 못했다면 처리 X. 발견했다면 0으로 바꿔줌
                    sb.setCharAt(idx2,'0');
                }


                answer[i]=Long.parseLong(sb.toString(),2); //10진법으로 변환

            }

            return answer;
        }
    }
}
