class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,k);
    }
    
    private int quickSort(int[] nums,int begin,int end, int k){
        int p = begin;
        for(int i=begin;i<end;i++)
            if(nums[i] < nums[end])
                exch(nums,i,p++);
        exch(nums,p,end);
        
        int count = end - p + 1;
        if(count == k) return nums[p];
        if(count <  k) return quickSort(nums,begin,p-1,k-count);
                       return quickSort(nums,p+1,end,k);
    }
    
    private void exch(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}