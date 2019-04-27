/**
 * 运用树状数组来实现
 */
class NumArray {

    int[] nums;
    int[] bit;
    int n;

    public NumArray(int[] nums){
        this.nums = nums;

        this.n = nums.length;
        bit = new int[n+1];
        for(int i=0; i<n; ++i){
            init(i, nums[i]);
        }
    }

    /**
     * 构建树状数组
     * @param i
     * @param val
     */
    private void init(int i, int val) {
        i++;
        while(i <= n){
            bit[i] += val;
            i += (i & -i);      // lowbit操作
        }
    }

    public void update(int i, int val){
        int diff = val - nums[i];   // 计算差值
        nums[i] = val;              // 更新nums数组
        init(i, diff);              // 更新bit数组
    }

    public int sumRange(int i, int j){
        return getSum(j) - getSum(i-1);
    }

    /**
     * 获取第i个数的和
     * @param i
     * @return
     */
    private int getSum(int i) {
        int sum = 0;
        i++;
        while(i>0){
            sum += bit[i];          // 更新sum
            i -= (i & -i);           // lowbit操作
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
    }

}
