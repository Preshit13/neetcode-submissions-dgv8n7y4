class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int l = 0;

        for(int r = 0;r < nums.length; r++){

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[r]){
                deque.pollLast();
            }
            deque.offerLast(r);

            if(deque.peekFirst() < l){
                deque.pollFirst();
            }

            if(r - l + 1 == k){
                result[l] = nums[deque.peekFirst()];  
                l++;
            }
        }
        return result;
    }
}
