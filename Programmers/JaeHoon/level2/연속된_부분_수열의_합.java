package Programmers.JaeHoon.level2;

public class 연속된_부분_수열의_합 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];
            int l = 0;
            int r = 0;
            int sum = sequence[0];
            boolean isOk = false;
            while(l <= r) {
                if(sum < k) {
                    r++;
                    if(r == sequence.length) break;
                    sum += sequence[r];
                }
                else if(sum > k) {
                    sum -= sequence[l];
                    l++;
                }
                else if(sum == k) {
                    int len = r - l;
                    int currLen = answer[1] - answer[0];
                    if(!isOk) {
                        answer[0] = l;
                        answer[1] = r;
                        isOk = true;
                        r++;
                        if(r == sequence.length) break;
                        sum += sequence[r];
                        continue;
                    }
                    if(len < currLen) {
                        answer[0] = l;
                        answer[1] = r;
                    }
                    else if(len == currLen) {
                        if(l < answer[0]) {
                            answer[0] = l;
                            answer[1] = r;
                        }
                    }
                    r++;
                    if(r == sequence.length) break;
                    sum += sequence[r];
                }
            }
            return answer;
        }
    }
}
