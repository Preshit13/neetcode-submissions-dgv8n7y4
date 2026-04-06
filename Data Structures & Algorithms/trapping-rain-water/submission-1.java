class Solution {
    public int trap(int[] height) {
        // int maxLeft = 0;
        // int maxRight = 0;
        // int left = 0;
        // int right = height.length - 1;
        // int water = 0;
        // while(left < right){
        //   if(height[left] < height[right]){
        //     if(height[left] >= maxLeft) maxLeft = height[left];
        //     else water += maxLeft - height[left];
        //     left++;
        //   }else{
        //     if(height[right] >= maxRight) maxRight = height[right];
        //     else water += maxRight - height[right];
        //     right--;
        //   }  
        // }
        // return water;

        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int water = 0;

        // fill maxLeft
        maxLeft[0] = height[0];
        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }

        // fill maxRight
        maxRight[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }

        // calculate water at each index
        for(int i = 0; i < n; i++){
            water += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return water;  
    }
}
