class Solution {
    public int largestRectangleArea(int[] heights) {
                int maxArea = 0;
        Stack<int[]> stack = new Stack<>();  // [index, height]

        for(int i = 0; i < heights.length; i++){
            int start = i;

            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                int width = i - index;
                maxArea = Math.max(maxArea, height * width);
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()){
            int[] top = stack.pop();
            int height = top[1];
            int width = heights.length - top[0];
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
        // int maxArea = 0;

        // for(int i = 0; i < heights.length; i++){
        //     int minHeight = heights[i];
            
        //     for(int j = i; j < heights.length; j++){
        //         minHeight = Math.min(minHeight, heights[j]);
        //         int width = j - i + 1;
        //         int area = minHeight * width;
        //         maxArea = Math.max(maxArea, area);
        //     }
        // }
        // return maxArea;
    }
}
