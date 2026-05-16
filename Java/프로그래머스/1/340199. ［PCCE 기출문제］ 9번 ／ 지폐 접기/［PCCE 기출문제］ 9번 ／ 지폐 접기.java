class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (!canIn(wallet[0], wallet[1], bill[0], bill[1])){
            if(bill[0] >= bill[1])
                bill[0] /= 2;
            else
                bill[1] /= 2;
            
            answer++;
        }
        
        return answer;
    }
    
    private boolean canIn(int w1, int w2, int b1, int b2){
        int temp = w1;
        w1 = Math.max(temp, w2);
        w2 = Math.min(temp, w2);
        temp = b1;
        b1 = Math.max(temp, b2);
        b2 = Math.min(temp, b2);
        
        return w1 >= b1 && w2 >= b2;
    }
}