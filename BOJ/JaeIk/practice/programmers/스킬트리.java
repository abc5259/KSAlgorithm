package BOJ.JaeIk.practice.programmers;


class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0; i<skill_trees.length; i++){
            String skill_tree = skill_trees[i].replaceAll("[^"+skill+"]", "");
            System.out.println("skill_tree : "+skill_tree);
            for(int j=0; j<skill.length()+1; j++){
                String sub_skill = skill.substring(0, j);
                System.out.println("sub_skill : "+sub_skill);

                if(skill_tree.equals(sub_skill)){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}