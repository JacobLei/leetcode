public class A11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        // res为所求面积，初始化为0， left为左指针， right为右指针
        int res = 0, left = 0, right = height.length-1;

        while(left < right){
            // 保留最大面积
            res = Math.max(res, Math.min(height[left], height[right]) * (right-left));
            // 比较左右指针指向的数据，移动较小数据的指针
            if(height[left]<height[right])
                ++left;    // 左指针向右移动
            else
                --right;    // 右指针向左移动
        }
        return res;
    }

    public static void main(String[] args) {
        A11_ContainerWithMostWater containerWithMostWater = new A11_ContainerWithMostWater();
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int res = containerWithMostWater.maxArea(nums);
        System.out.println(res);
    }
}
