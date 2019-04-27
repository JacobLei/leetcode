public class A667_BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for(int i=0, left = 1, right = n; left <= right; i++){
          if( k>1){
              res[i] = (k-- % 2 != 0) ? left++ : right--;
          }else{
              res[i] = left++;
          }
        }
        return res;
    }

    public static void main(String[] args) {
        A667_BeautifulArrangementII arrangement = new A667_BeautifulArrangementII();

        int[] res = arrangement.constructArray(5, 2);
        for(int r : res){
            System.out.print(r + " ");
        }
    }
}
