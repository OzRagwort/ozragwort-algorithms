package com.ozragwort.code.programmers.level2;

public class q49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            answer += check(skill, tree);
        }

        return answer;
    }

    public int check(String skill, String tree) {
        int result = 1;
        int index = -1;
        boolean cont = true;

        for (int i = 0 ; i < skill.length() ; i++) {
            int tree_index = tree.indexOf(skill.charAt(i));

            if (cont && index < tree_index) {
                index = tree_index;
            } else if (tree_index == -1) {
                cont = false;
            } else {
                result = 0;
                break;
            }
        }

        return result;
    }

//    public int solution(String skill, String[] skill_trees) {
//        int answer = 0;
//
//        for (String tree : skill_trees) {
//            if (skill.startsWith(tree.replaceAll("[^" + skill + "]", ""))) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }
}
