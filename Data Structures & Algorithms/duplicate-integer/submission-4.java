class Solution {
    public boolean hasDuplicate(int[] nums) {
              HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            if(!set.contains(val)){
                set.add(val);
            }else{
                return true;
            }
        }
        return false;  
    }
}