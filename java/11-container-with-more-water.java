class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = Integer.MIN_VALUE;
        while(left < right) {
            int height1 = Math.min(height[left], height[right]);
            int area = Math.abs(left-right) * height1;
            if(height[left] < height[right]) {
                left+=1;
            } else {
                right-=1;
            }
            max = Math.max(area, max);
        }

        return max;
    }
}
