class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if(totalLen%2 == 1)
            return findKth(nums1,nums2,0,0,totalLen/2 + 1) * 1.0;
        else
            return (findKth(nums1,nums2,0,0,totalLen/2)
                   +findKth(nums1,nums2,0,0,totalLen/2 + 1)
                   )/2.0;
    }
    
    private int findKth(int[] nums1, int[] nums2, int p1, int p2, int k){
        if(nums1.length - p1 > nums2.length - p2)
            return findKth(nums2,nums1,p2,p1,k);
        
        if(nums1.length - p1 == 0)
            return nums2[p2+k-1];
        if(k == 1)
            return Math.min(nums1[p1],nums2[p2]);
        
        int k1 = Math.min(nums1.length - p1,k/2);
        int k2 = k - k1;
        
        if(nums1[p1+k1-1] < nums2[p2+k2-1])
            return findKth(nums1,nums2,p1+k1,p2,k-k1);
        else if(nums1[p1+k1-1] > nums2[p2+k2-1])
            return findKth(nums1,nums2,p1,p2+k2,k-k2);
        else
            return nums1[p1+k1-1];
    }
}