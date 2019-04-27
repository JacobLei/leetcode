import java.util.HashMap;
import java.util.Map;

public class A535_EncodeandDecodeTinyURL {
    Map<Integer, String> hashMap = new HashMap<>();
    int i = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        hashMap.put(i, longUrl);
        return "http://tinyurl.com/"+ i++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hashMap.get(Integer.parseInt(
                shortUrl.replace(
                        "http://tinyurl.com/", "")));
    }


}
