package HashMap;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Two");
        hashMap.put(2, "Two");
        hashMap.put(3, "Two");
        hashMap.put(4, "Two");
        hashMap.put(5, "Two");
        System.out.println(hashMap);
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(22));
        System.out.println(hashMap.containsKey(3));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.size());
        for (Integer key : hashMap.keySet()) {
            System.out.println(key + " " + hashMap.get(key));
        }
    }

}
