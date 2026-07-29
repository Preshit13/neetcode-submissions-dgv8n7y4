class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int[] result = new int[nums.length - k + 1];
      int l = 0;
      int r = 0;
      for(int i = 0; i < nums.length - k + 1; i++){
        int count  = 0;
        r = l;
        int max = Integer.MIN_VALUE;
        while(count < k){
            if(nums[r] > max){
                max = nums[r];
            }
            r++;
            count++;
        }
        result[i] = max;;
        l++;
      }
return result;  
    }
}
