class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++)
            strs[i] = nums[i] + "";
        
        Arrays.sort(strs, new Comparator<String>(){
           @Override
            public int compare(String i, String j){
                String s1 = i+j;
                String s2 = j+i;
                return -s1.compareTo(s2);
            }
        });
        
        if(strs[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s:strs)
            sb.append(s);
        return sb.toString();
    }
}