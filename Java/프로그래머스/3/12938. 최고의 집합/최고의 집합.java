class Solution {
    public int[] solution(int n, int s) {
        int q = s/n;
        int r = s%n;
        
        if(q == 0)
            return new int[]{-1};
        
        
        int[] res = new int[n];
        for(int i = n-1; i>=0; i--){
            res[i] = q;
            if(r>0){
                res[i]++;
                r--;
            }
        }

        return res;
    }
}