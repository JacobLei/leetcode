public class A169_MajorityElement {

    // 摩尔投票法
    public int majorityElement(int[] nums){
        int ret = 0;
        int cnt = 0;

        for(int num : nums){
            if(cnt == 0){
                ret = num;
                ++cnt;
            }else{
                if(num == ret)
                    ++cnt;
                else
                    --cnt;
            }
        }

        return ret;
    }

    //  位运算法
    public int majorityElement2(int[] nums){
        int ret = 0;
        int size = nums.length;

        for(int i=0; i<32; ++i){
            int ones = 0;
            int zeros = 0;
            for(int num : nums){
                if(ones > size/2 || zeros > size/2)      // 如果统计位数过半
                    break;
                if((num & (1<<i)) != 0)
                    ++ones;
                else
                    ++zeros;
            }
            if(ones > zeros )
                ret |= (1<<i);
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int[] nums2 = {2,2,1,1,1,2,2};
        A169_MajorityElement majorityElement = new A169_MajorityElement();
        System.out.println(majorityElement.majorityElement2(nums));
        System.out.println(majorityElement.majorityElement2(nums2));
    }
}
