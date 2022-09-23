package learn_base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class listTest {
    public static void main(String[] args) {
        List<String> AList =new ArrayList<>();
        AList.add("a1");
        AList.add("b2");
        AList.add("c3");
        AList.add("d4");
        AList.add("e5");
        AList.add("f6");
        AList.add("g7");
        System.out.println(AList.size());
        AList.remove(2);
        System.out.println(AList.size());

        ConcurrentHashMap<String,Integer> A = new ConcurrentHashMap<>();
        A.put("123",1);
        A.put("123",2);
        System.out.println(A.get("123"));
    }
}
