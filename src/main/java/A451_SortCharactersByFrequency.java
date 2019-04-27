import java.util.*;
class Product{
    int count;
    StringBuffer sb = new StringBuffer("");
}

public class A451_SortCharactersByFrequency {
    public String frequencySort(String s){
        StringBuffer ret = new StringBuffer("");
        Map<Character, Product> hashMap = new HashMap<>();
        List<Product> list = new ArrayList<>();

        for(char item : s.toCharArray()){
            if(hashMap.containsKey(item)){
                Product product = hashMap.get(item);
                product.count++;
                product.sb.append(item);
            }else{
                Product product = new Product();
                product.count = 1;
                product.sb.append(item);
                list.add(product);
                hashMap.put(item, product);
            }
        }

        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.count - o1.count;
            }
        });

        for(Product product : list){
            ret.append(product.sb);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "aaaaabbccc";
        A451_SortCharactersByFrequency sortCharacters = new A451_SortCharactersByFrequency();
        System.out.println(sortCharacters.frequencySort(s));
    }
}
