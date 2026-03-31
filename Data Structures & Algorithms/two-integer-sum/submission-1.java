class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int sum = 0;
        // int[] ans = new int[2];
        // for(int i = 0; i < nums.length-1; i++){
        //     for(int j = i+1;j<nums.length; j++){
        //      if(nums[i]+nums[j]==target){
        //         return new int[]{i,j};
        //       }
        //     }
        // }
        // return new int[]{};

        HashMap<Integer, Integer> result = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            result.put(nums[i], i);
        }

        for(int j = 0; j < nums.length; j++){
            int k = target - nums[j];
            if(result.containsKey(k) && j!=result.get(k)){
                return new int[]{j, result.get(k)};
            }
        }
        return new int[]{0, 0};
    }
}
