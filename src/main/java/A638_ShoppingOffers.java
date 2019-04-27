import java.util.LinkedList;
import java.util.List;

public class A638_ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        int res = 0, n = price.size();

        for (int i = 0; i < n; i++) {           // 没有优惠购买的总价
            res += price.get(i) * needs.get(i);
        }

        for(List<Integer> offer : special){
            boolean isValid = true;
            for (int i = 0; i < n; i++) {
                if(needs.get(i) - offer.get(i) < 0)
                    isValid = false;
                needs.set(i, needs.get(i) - offer.get(i));
            }
            if(isValid){
                res = Math.min(res, shoppingOffers(price, special, needs) + offer.get(offer.size()-1));
            }
            for (int i = 0; i < n; i++) {               // 回溯
                needs.set(i, needs.get(i) + offer.get(i));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<Integer> price = new LinkedList<>();
        List<List<Integer>> special = new LinkedList<>();
        List<Integer> needs = new LinkedList<>();
        price.add(2);
        price.add(5);
        List<Integer> tmp1 = new LinkedList<>();
        tmp1.add(3);
        tmp1.add(0);
        tmp1.add(5);
        special.add(tmp1);
        List<Integer> tmp2 = new LinkedList<>();
        tmp2.add(1);
        tmp2.add(2);
        tmp2.add(10);
        special.add(tmp2);
        needs.add(3);
        needs.add(2);

        A638_ShoppingOffers shoppingOffers = new A638_ShoppingOffers();
        System.out.println(shoppingOffers.shoppingOffers(price, special, needs));
    }
}
