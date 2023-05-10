package Programmers.JaeHoon;

public class 이모티콘_할인행사 {
    class Solution {
        int[] sale;
        int N;
        int[][] cusers;
        int[] cemoticons;
        int[] answer = new int[2];
        public int[] solution(int[][] users, int[] emoticons) {
            N = emoticons.length;
            sale = new int[N];
            cusers = users;
            cemoticons = emoticons;
            dfs(0);
            return answer;
        }

        public void dfs(int depth) {
            if(depth == N) {
                int[] result = new int[2];
                for(int i=0; i<cusers.length; i++) {
                    int sum = 0;
                    for(int j=0; j<N; j++) {

                        if(cusers[i][0] <= sale[j]) { //이모티콘 구매

                            double a = (100 - sale[j]) * 0.01;
                            sum += cemoticons[j] * a;
                        }
                    }

                    if(cusers[i][1] <= sum) result[0] += 1;
                    else result[1] += sum;
                }

                if(result[0] > answer[0]) {
                    answer[0] = result[0];
                    answer[1] = result[1];
                }
                else if(result[0] == answer[0]) {
                    answer[1] = Math.max(result[1],answer[1]);
                }
                return;
            }

            for(int i=10; i<=40; i+=10) {
                sale[depth] = i;
                dfs(depth+1);
            }
        }
    }
}
