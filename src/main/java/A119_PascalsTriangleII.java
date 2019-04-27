import java.util.ArrayList;
import java.util.List;

public class A119_PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>(rowIndex+1);

        for (int i = 0; i <= rowIndex; i++) {
            res.add(0);
        }
        res.set(0, 1);
        for (int i = 1; i <= rowIndex; i++) {
            res.set(i, 1);
            for (int j = i-1; j > 0; j--) {
                res.set(j, (res.get(j) + res.get(j-1)));
            }
        }


        return res;
    }

    public static void main(String[] args) {
        A119_PascalsTriangleII pascalsTriangleII = new A119_PascalsTriangleII();
        List<Integer> res = pascalsTriangleII.getRow(3);
        for(int r : res){
            System.out.print(r + " ");
        }
    }

}
