class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        
        Arrays.sort(intervals,(i1,i2) -> Integer.compare(i1[0],i2[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        
        for(int[] interval:intervals){
            if(interval[0]<=currentInterval[1]){
                currentInterval[1] = Math.max(currentInterval[1],interval[1]);
            } else{
                currentInterval = interval;
                result.add(currentInterval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}