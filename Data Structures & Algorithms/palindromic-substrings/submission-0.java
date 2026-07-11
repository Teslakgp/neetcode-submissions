class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 0 || s == null) return 0;
        int totalCount = 0;

        for(int i = 0; i < s.length(); i++){
            totalCount += expandCount(s, i, i);
            totalCount += expandCount(s, i, i + 1);
        }
        return totalCount;
    }

    private int expandCount(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
