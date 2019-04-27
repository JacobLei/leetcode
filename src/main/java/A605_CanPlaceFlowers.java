public class A605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length, cnt = 0;
        for(int i=0; i<len; i++){   // 将已种花的相邻区域标记为不能种植
            if(flowerbed[i] == 1){
                if(i-1 >=0 )
                    flowerbed[i-1] = -1;
                if(i+1<len)
                    flowerbed[i+1] = -1;
            }
        }

        for(int i=0; i<len; i++){
            if(flowerbed[i] == 0){
                cnt++;
                if(i+1<len)
                    flowerbed[i+1] = -1;
            }
        }

        return cnt >= n;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 1};
        A605_CanPlaceFlowers flowers = new A605_CanPlaceFlowers();
        boolean res = flowers.canPlaceFlowers(nums, 2);
        System.out.println(res);
    }
}
