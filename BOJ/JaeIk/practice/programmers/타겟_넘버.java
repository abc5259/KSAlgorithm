package BOJ.JaeIk.practice.programmers;

class 타겟_넘버 {
    static int count=0;
    public int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(numbers, 0, target, 0);

        answer = count;

        return answer;
    }

    static void dfs(int[] numbers, int depth, int target, int sum){
        if(depth==numbers.length){
            if(sum==target)count++;
        }else{
            dfs(numbers, depth+1, target, sum+numbers[depth]);
            dfs(numbers, depth+1, target, sum-numbers[depth]);
        }
    }
}