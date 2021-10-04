class 월간코드1_두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        boolean[] results = new boolean[201];
        int size = 0;
        
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                // 앞서 나오지 않은 결과값이거나 동일한 인덱스가 아닐때
                if(!results[numbers[i]+numbers[j]] && i!=j){
                    results[numbers[i]+numbers[j]] = true;
                    size++;
                }
            }
        }
        
        int[] answer = new int[size];
        for(int i=0; i<results.length; i++){
            if(results[i] == true) {
                answer[answer.length-size] = i;
                size--;
            }
        }
        
        return answer;
    }
}

/**
 * 다른사람의 풀이
 * ArrayList<Integer> list = new ArrayList<> ();
 * 일할때는 리스트를 엄청 많이 쓰지만 이상하게 혼자 코테할떄는 손에 안붙고 맨날 배열만 주구장창 쓴다 ...
 * 레거시 코드에 List가 많아서 쓰는거고 나 스스로는 익숙하지 않다는 뜻이겠지
 * 
 * # List를 썼다면
 * int sum = numbers[i] + numbers[j];
 * f(! list.contains(sum)) list.add(sum);
 * Collections.sort(list);
 * >> contain이랑 sort함수로 간단히 해결 ! .. 
 */