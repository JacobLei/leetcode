public class A31_NextPermutation {
    public void nextPermutation(int[] nums) {
        // save the first index of nums[i] < nums[k] from right to left
        int i=0;
        // save the first index of nums[j] > nums[i]  from right to left
        int j=0;

        // to find the first index of nums[i] < nums[k] from right to left
        for (int k = nums.length - 2; k > 0; k--) {
            if(nums[k] < nums[k+1]) {    // 找出第一个下降的数
                i = k;
                break;
            }
        }

        // to find the first index nums[j] > nums[i] from tight to left
        for (int k = nums.length-1; k > 0; k--) {
            if(nums[k] > nums[i]){
                j = k;
                break;
            }
        }

        // swap nums[i] and nums[j]
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;

      int n = 0;
      if(i ==0 && j == 0){
          n = 0;
      }else{
          n = i + 1;
      }
      int len = nums.length - 1;
      while(n < len){
          int tmp = nums[n];
          nums[n] = nums[len];
          nums[len] = tmp;
          ++n;
          --len;
      }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        A31_NextPermutation nextPermutation = new A31_NextPermutation();
        nextPermutation.nextPermutation(nums);

        for(int l : nums){
            System.out.println(l);
        }
    }
}
