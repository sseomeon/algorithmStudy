package programmers;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] arrIdx = new int[9];

        // numbers에 숫자가 있을 경우 arrIdx배열 위치로 표시
        for (int i : numbers) {
            if (i != 0)
                arrIdx[i - 1] = 1;
        }

        // arrIdx 배열을 통해 numbers에 없는 숫자 합계 구하기
        for (int i = 0; i < arrIdx.length; i++) {
            if (arrIdx[i] == 0)
                answer += (i + 1);
        }

        return answer;
    }
}