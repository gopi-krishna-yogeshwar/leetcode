class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        boolean flag = false;
        while(left < right) {
            if((s.charAt(left) < 97 || s.charAt(left) > 122) && (s.charAt(left) < 48 || s.charAt(left) > 57)) {
                left++;
                continue;
            } 
            if((s.charAt(right) < 97 || s.charAt(right) > 122) && (s.charAt(right) < 48 || s.charAt(right) > 57)) {
                right--;
                continue;
            }

            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;right--;

        }
        return true;
    }
}
