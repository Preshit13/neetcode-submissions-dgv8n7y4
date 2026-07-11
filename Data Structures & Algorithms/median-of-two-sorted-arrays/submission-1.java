class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> combined = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                combined.add(nums1[i]);
                i++;
            }else{
                combined.add(nums2[j]);
                j++;
            }
        }

        while(i < nums1.length) combined.add(nums1[i++]);
        while(j < nums2.length) combined.add(nums2[j++]);

        double result = 0;
        if(combined.size() % 2 != 0){
            int mid = combined.size() / 2;
            result = combined.get(mid);
        }else{
            int mid1 = combined.size() / 2;
            int mid2 = (combined.size() / 2) - 1;
            result = (combined.get(mid1) + combined.get(mid2)) / 2.0;
        }

        return result;
    }
}
