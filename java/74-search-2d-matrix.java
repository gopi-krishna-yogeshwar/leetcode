class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int row = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[0].length-1] >= target) {
                int left1 = 0;
                int right1 = matrix[0].length-1;
                while(left1 <= right1) {
                    int mid1 = (left1 + right1) / 2;
                    if(matrix[mid][mid1] < target) {
                        left1 = mid1+1;
                    } else if(matrix[mid][mid1] > target) {
                        right1 = mid1-1;
                    } else {
                        return true;
                    }
                }
                return false;
            } else if(matrix[mid][0] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}
