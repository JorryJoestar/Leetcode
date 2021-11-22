class Solution {
    public void sortColors(int[] nums) {
        int lt = 0, gt = nums.length-1, i = 0;
        while(i<=gt){
            if(nums[i] == 0){
                nums[i] = nums[lt];
                nums[lt] = 0;
                lt++;
            }
            if(nums[i] == 2){
                nums[i] = nums[gt];
                nums[gt] = 2;
                gt--;
                i--;
            }
            i++;
        }
    }
}