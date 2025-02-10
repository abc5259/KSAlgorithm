package Programmers.Hyeon;

import java.util.ArrayDeque;
import java.util.Deque;

public class 크레인_인형뽑기_게임 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(s.solution(board, moves));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {

            Deque<Integer>[] stack = new ArrayDeque[board.length];

            for (int i = 0; i < board.length; i++) {
                stack[i] = new ArrayDeque<>();
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[board.length - j - 1][i] > 0) {
                        stack[i].push(board[board.length - j - 1][i]);
                    }
                }
            }

            Deque<Integer> bucket = new ArrayDeque<>();

            int res = 0;

            for (int i = 0; i < moves.length; i++) {
                if (!stack[moves[i] - 1].isEmpty()) {
                    int pop = stack[moves[i] - 1].pop();
                    if (!bucket.isEmpty() && bucket.peek() == pop) {
                        bucket.pop();
                        res += 2;
                    } else {
                        bucket.push(pop);
                    }
                }
            }
            return res;
        }
    }
}
// 2019 카카오 개발자 겨울 인턴십 크레인 인형뽑기 게임
// 2차원 배열의 인형을 넣어서 뽑아둔 바구니에 바구니에서 2개이상이 연속되면 그 연속된 것을 pop 해야된다.
// 그러면 pop 할때마다 2개 씩 추가한다고 생각하면된다.
// 2차원 배열은 행 -> 열 순서인데 열 -> 행으로 역행으로 해석해서 스택에 넣고자한다
// 그때 스택을 N개 만들어야 한다. 입력되는 배열의 개수 만큼 N개의 스택을 만들어야하니까 개수만큼 new ArrayDeque 해준다.
// 그다음 역순으로 0이상일 때 스택에 푸시하고

// 뽑을 moves 배열의 값을 인덱스로 가지는 스택에서 pop 해야되는데 스택은 0부터 시작해서 배열의 값에서 -1해준다.
// 가장 위의 값이 pop 한 값과 같으면 pop 하고 2 더해준다. 다르면 push 한다.