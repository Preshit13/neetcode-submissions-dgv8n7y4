class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] preffix = new int[nums.length];
        int[] suffix = new int[nums.length];
        preffix[0] = 1;
        suffix[nums.length - 1] = 1;

        for(int i = 1 ; i < nums.length; i++){
            preffix[i] = nums[i-1]*preffix[i-1];
        }

        for(int j  = nums.length - 2; j >= 0; j--){
            suffix[j] = nums[j+1]*suffix[j+1];
        }

        for(int i = 0 ; i < nums.length; i++){
            result[i] = preffix[i]*suffix[i];
        }

        return result;
    }
}  
