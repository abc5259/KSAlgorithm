package BOJ.JaeIk.programmers;

import java.util.*;

class 광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int diamond = picks[0];
        int iron = picks[1];
        int stone = picks[2];

        int totalPick = diamond+iron+stone;

        int n = minerals.length;

        int[][] mineralGroup = new int[totalPick][6];

        for(int i=0; i<Math.min(totalPick*5, n); i+=5){
            int sum = 0;
            int damage = 0;

            for(int j=i; j<Math.min(i+5, n); j++){
                switch(minerals[j]){
                    case "diamond":
                        damage = 25;
                        break;
                    case "iron":
                        damage = 5;
                        break;
                    case "stone":
                        damage = 1;
                        break;
                }

                sum += damage;
                mineralGroup[i/5][j%5+1] = damage;
            }

            mineralGroup[i/5][0] = sum;
        }

        Arrays.sort(mineralGroup, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[0] - o1[0];
            }
        });

        for(int i=0; i<totalPick; i++){
            int[] temp = mineralGroup[i];
            String pick = "";

            if(diamond>0){
                diamond--;
                pick = "diamond";
            } else if (iron > 0) {
                iron--;
                pick = "iron";
            } else if (stone > 0) {
                stone--;
                pick = "stone";
            }

            for(int j=1; j<6; j++){
                switch(pick){
                    case "diamond":
                        answer += (int) Math.ceil(temp[j] / 25.0);
                        break;
                    case "iron":
                        answer += (int) Math.ceil(temp[j] / 5.0);
                        break;
                    case "stone":
                        answer += temp[j];
                        break;
                }
            }
        }

        return answer;
    }
}