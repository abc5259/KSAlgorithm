package Programmers.JaeHoon;

public class 양궁대회 {

class Solution {
    int[] arr;
    int maxDif = 0;
    int dif = 0;
    int[] answer;
    public int[] solution(int n, int[] info) {
        arr = new int[11];
        answer = new int[11];
        for(int i=0; i<11; i++) {
            if(info[i] > 0)
                dif += (10 - i);
        }
        solve(0,0,n,info);
        return maxDif == 0 ? new int[]{-1} : answer;
    }
    public void solve(int depth,int sum,int n, int[] info) {
        if(depth == 11) {
            if(sum != n) return;
            int aScore = 0;
            int bScore = 0;
            for(int i=0; i<11; i++) {
                if(info[i] == 0 && arr[i] == 0) continue;
                else if(info[i] < arr[i]) {
                    bScore += 10 - i;
                }else {
                    aScore += 10 - i;
                }
            }
            if(bScore - aScore > maxDif) {
                maxDif = bScore - aScore;
                answer = arr.clone();
            }
            else if(bScore - aScore == maxDif) {
                for(int i=10; i>=0; i--) {
                    if(arr[i] == answer[i]) continue;
                    else if(arr[i] < answer[i]) break;
                    else {
                        answer = arr.clone();
                        break;
                    }
                }
                
            }
            return;
        }
        
        for(int i=0; i<=n - sum; i++) {
            arr[depth] = i;
            solve(depth + 1, sum + i, n,info);
            arr[depth] = 0;
        }
    }
}
}
