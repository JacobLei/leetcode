public class A845_LongestMountaininArray {
    public int longestMountain(int[] A) {
        int res = 0, len = A.length;
        int[] up = new int[len], down = new int[len];

        for(int i=len -2; i>=0; i--){
            if(A[i]>A[i+1]){    // 判断递减
                down[i] = down[i+1] + 1;
            }
        }

        for(int i=0; i<len; i++){
            if(i>0 && A[i] > A[i-1]){   // 判断递增
                up[i] = up[i-1] + 1;
            }
            if(up[i]>0 && down[i]>0){
                res = Math.max(res, up[i]+down[i]+1);
            }
        }
        return res;
    }

    public int longestMountain2(int[] A) {
        int res = 0, up = 0, down = 0;
        for(int i=1; i<A.length; i++){
            if(down>0 && (A[i-1]<A[i] || A[i-1] == A[i])) up = down = 0;
            if(A[i-1]<A[i]) up++;
            if(A[i-1]>A[i]) down++;
            if(up>0 && down>0 && up + down + 1 > res)
                res = up + down + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        A845_LongestMountaininArray longestMountaininArray = new A845_LongestMountaininArray();
        int res = longestMountaininArray.longestMountain2(A);
        System.out.println(res);
    }
}
