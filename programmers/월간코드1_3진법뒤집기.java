import java.util.ArrayList;

class Solution {
    public int solution(int num) {
        int answer = 0;
        ArrayList<Integer> base3 = new ArrayList<>();
        
        // 3진법으로 숫자 변환 > 뒤집어진 상태로 저장
        while(num > 0){
            base3.add(num%3);
            num /= 3;
        }
        
        // 10진법으로 숫자 변환
        for(int i=1; i<=base3.size(); i++){
            answer += (base3.get(base3.size()-i) * Math.pow(3,i-1)); 
        }
        
        return answer;
    }
}