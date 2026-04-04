class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int length = 0;

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for(int num : set){
            if(!set.contains(num - 1)){
                int len = 1;
                while(set.contains(num + len)){
                    len++;
                }
                length = Math.max(length, len); 
            }
        }
        return length;
    }
}
