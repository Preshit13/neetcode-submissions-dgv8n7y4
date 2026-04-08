class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        int low = 1;
        int high = max;
        int result = max;

        while(low <= high){
            int mid = low + (high - low)/2;
            long hours = 0;
            for(int i = 0; i < piles.length; i++){
                hours += Math.ceil((double) piles[i]/mid);
            }

            if(hours <= h){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result; 
    }
}
