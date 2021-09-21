class 월간코드2_약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;

        // left부터 right까지 반복
        for(int val=left; val<=right; val++){
            if(val == 1){
                // 값이 1일 경우는 홀수이므로 -1
                answer -= 1;
            }else {
                // 값이 1이 아닐 경우 기본적으로 약수를 2개 가지고있음
                int cnt = 2;
                // 값의 1/2 이상인 약수는 나올 수 없으므로 for문은 2부터 val/2까지만
                for(int i=2; i<=val/2; i++){
                    if(val%i == 0) cnt++;
                }
                
                // 약수의 개수(cnt) 짝홀 체크 후 계산
                if(cnt%2 == 0) answer += val;
                else answer -= val;
            }
        }

        return answer;
    }
}