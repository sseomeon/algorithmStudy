package programmers;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (!signs[i])
                absolutes[i] = absolutes[i] * (-1);
            answer += absolutes[i];
        }
        return answer;
    }
}

/**
 * # 다른 사람 코드 참고 # answer += absolutes[i] * (signs[i]? 1: -1); (조건문? 참 : 거짓) 이
 * 형식을 잘 안써서 그런지 쉽게 떠오르지 않는다.
 */