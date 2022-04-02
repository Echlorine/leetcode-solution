class Solution11 {
    public static int maxArea(int[] height) {
        int begin=0, end=height.length-1;
        int v=0,vmax=0;
        for (int i=0; i<height.length;i++){
            //计算当前容积
            v = height[begin] < height[end] ? height[begin] : height[end];
            v *= (end - begin);
            if (height[begin] < height[end]){
                begin++;
            }
            else{
                end--;
            }
            vmax = v > vmax ? v : vmax;
        }
        return vmax;
    }
}