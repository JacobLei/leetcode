public class A838_PushDominoes {
    public String pushDominoes(String dominoes) {
        dominoes = 'L' + dominoes + 'R';
        StringBuilder res = new StringBuilder();
        for (int i = 0, j = 1; j < dominoes.length(); j++) {
            if(dominoes.charAt(j) == '.')   // 将站立点排除，寻找已经倒下的点
                continue;
            int middle = j - i - 1;         // 两个已经倒下点中间站立点的个数
            if(i > 0)
                res.append(dominoes.charAt(i));
            if(dominoes.charAt(i) == dominoes.charAt(j)){   // 向一个方向倒
                for(int k=0; k < middle; k++){
                    res.append(dominoes.charAt(i));
                }
                // 左边的向左倒，右边的向右倒，则中间的不倒
            }else if(dominoes.charAt(i) == 'L' && dominoes.charAt(j) == 'R'){
                for (int k = 0; k < middle; k++) {
                    res.append('.');
                }
            }else{ // 左边的向右倒，右边的向左倒
                for (int k = 0; k < middle/2; k++) {
                    res.append('R');
                }
                if(middle % 2 == 1)
                    res.append('.');
                for (int k = 0; k < middle/2; k++) {
                    res.append('L');
                }
            }
            i = j;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        A838_PushDominoes pushDominoes = new A838_PushDominoes();
        String res = pushDominoes.pushDominoes(dominoes);
        System.out.println(dominoes);
        System.out.println(res);
    }
}
