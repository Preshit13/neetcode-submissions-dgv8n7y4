class Solution {
    public boolean hasDuplicate(int[] nums) {
                HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length; i++){
             if(set.contains(nums[i])){
                return true;
             }else{
                set.add(nums[i]);
             }
            }
        return false;
    }
        // for(int i = 1; i < nums.length; i++){
        //     int j = i - 1;
        //     while(j >=0){
        //         if(nums[j] > nums[j+1]){
        //             swap(nums, j, j+1);
        //             j--;
        //         }else if(nums[j] == nums[j+1]){
        //             return true;
        //         }else{
        //             break;
        //         }
        //     }
        // }
        // return false;
    // }

    // public void swap(int[] nums, int first, int second){
    //     int temp = nums[first];
    //     nums[first] = nums[second];
    //     nums[second] = temp;
    // }
}