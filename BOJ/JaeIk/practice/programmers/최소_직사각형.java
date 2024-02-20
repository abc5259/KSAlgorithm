package BOJ.JaeIk.practice.programmers;

import java.util.*;

class 최소_직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int height = 0;

        for(int i=0; i<sizes.length; i++){
            for(int j=0; j<sizes[0].length; j++){
                if(sizes[i][0] < sizes[i][1]){
                    int temp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = temp;
                }

                if(j==0){
                    width = Math.max(width, sizes[i][j]);
                }
                if(j==1){
                    height = Math.max(height, sizes[i][j]);
                }
            }
        }

        answer = width*height;

        return answer;
    }
}