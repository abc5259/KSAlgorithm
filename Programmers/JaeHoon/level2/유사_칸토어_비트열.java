package Programmers.JaeHoon.level2;

public class 유사_칸토어_비트열 {
    class Solution {
        public int solution(int n, long l, long r) {
            int answer = 0;

            return solve(n,l,r);
        }
        public int solve(int n, long l, long r) {
            long total = (long)Math.pow(5,n);

            if(total == 5) {
                int L = (int)l - 1;
                int R = (int)r - 1;

                String s = "11011";
                int add = 0;
                for(int i=L; i<=R; i++) {
                    if(s.charAt(i) == '1') add++;
                }
                return add;
            }

            long partCnt = total / 5;
            long left = (l-1) / partCnt;
            long right = (r-1) / partCnt;

            int sum = 0;
            for(long i=left+1; i<right; i++) {
                if(i == 2) continue;
                sum += (int)Math.pow(4,n-1);
            }

            if(left == right && left != 2) {
                if(l % partCnt == 0) l = partCnt;
                else l = l % partCnt;
                if(r % partCnt == 0) r = partCnt;
                else r = r % partCnt;

                sum += solve(n-1, l, r);
            }

            else {
                if(l % partCnt == 0) l = partCnt;
                else l = l % partCnt;
                if(r % partCnt == 0) r = partCnt;
                else r = r % partCnt;

                if(left != 2)
                    sum += solve(n-1,l, partCnt);
                if(right != 2)
                    sum += solve(n-1, 1,r);
            }


            return sum;

        }
    }
}
