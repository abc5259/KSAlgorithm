package Programmers.Hyeon.lv3;

public class 입국심사 {
    class Solution {
        int[] globalTimes;
        int N;

        public long solution(int n, int[] times) {

            this.globalTimes = times;
            N = n;

            long minMinute = Long.MAX_VALUE;
            for (int time : times) {
                if (time < minMinute) {
                    minMinute = time;
                }
            }
            return lowerBound(minMinute * n);
        }

        public long lowerBound(long min) {
            long lo = 0;
            long hi = min;

            while (lo + 1 < hi) {
                long mid = (hi - lo) / 2 + lo;

                if (check(mid)) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
            return hi;
        }

        public boolean check(long minute) {
            long cnt = 0;

            for (int time : globalTimes) {
                cnt += (minute / time);
            }
            return cnt >= N;
        }
    }
}
// lv3 입국심사 이분탐색 + 그리디
// 27분
// 풀어본 문제라서 쉽게 풀었는데도 그래도 오래걸렸다..
// 일단 1~10억분과 10억명이 주어지기 때문에 시간초과를 고려해서라도 이분 탐색을 해야했고
// 그리고 cnt 의 개수에 따라 내가 입국 심사를 할 수 있는 n 명의 인원인건데
// n보다 많이 할 수록 내가 그 시간을 줄여야 하기 때문에
// FFFF TTTT라는 결정조건으로 이어질 수 있다
// 그래서 이를 이용하여 lowerBound로 설계 하고 check 메소드로
// 그리디를 이용해서 내가 가능한 인원 수의 최대를 구하고 이가 n보다 크면
// T 로 판단해서 더 왼쪽에 T 가 있는지 hi 값을 mid 로 줄여서 나열한다
// trouble shooting
// 이때 int * int 에 대해서 는 int 로 연산하기에
// long * int 가 되게끔 오버플로우를 주의한다