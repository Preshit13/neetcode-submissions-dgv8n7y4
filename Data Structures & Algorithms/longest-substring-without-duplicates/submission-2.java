class Solution {
    public int lengthOfLongestSubstring(String s) {
    HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int maxLength = 0;
        
        while(r < s.length()){
                if(!set.contains(s.charAt(r))){
                    set.add(s.charAt(r));
                    maxLength = Math.max(maxLength, r - l + 1);
                    r++;
                }else{
                    set.remove(s.charAt(l));
                    l++;
                }
        }
        return maxLength;
    }
}
