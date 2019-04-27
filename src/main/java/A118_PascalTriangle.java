import java.util.ArrayList;
import java.util.List;

public class A118_PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0)
            return res;

        res.add(new ArrayList<>());
        res.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = res.get(i-1);

            // 第一个数为1
            row.add(1);
            // 第二个数到倒数第二个数位上一行的两个数的和
            for (int j = 1; j < preRow.size(); j++) {
                row.add(preRow.get(j-1) + preRow.get(j));
            }
            // 最后一个数为1
            row.add(1);
            res.add(row);
        }

        return res;
    }

    public static void main(String[] args) {
        A118_PascalTriangle pascalTriangle = new A118_PascalTriangle();
        List<List<Integer>> res = pascalTriangle.generate(5);
        for(List<Integer> list : res){
            for (int l : list){
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }

}
