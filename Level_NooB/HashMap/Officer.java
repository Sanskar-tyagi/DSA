package HashMap;

import java.util.*;;

public class Officer {
    public static void main(String[] args) {
        String keyString[] = { "a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b" };
        String Time[] = { "23:20", "11:09", "23:30", "23:02", "15:28", "22:57", "23:40", "03:43", "21:55", "20:38",
                "00:19" };
        alertNames(keyString, Time);
    }

    public static List<String> alertNames(String[] key, String[] Time) {

        HashMap<String, ArrayList<String>> cout = new HashMap<>();

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < key.length; i++) {
            String curr = key[i];
            String t = Time[i];
            if (!cout.containsKey(curr)) {
                cout.put(curr, new ArrayList<String>());
            }
            cout.get(curr).add(t);
        }

        for (String curr : cout.keySet()) {
            List<String> l1 = cout.get(curr);
            Collections.sort(l1);
            int count = 0;
            for (int i = 0; i < l1.size() - 1; i++) {
                String pre = l1.get(i);
                String next = l1.get(i + 1);
                int MM = Integer.parseInt(pre.substring(3));
                int HH = Integer.parseInt(pre.substring(0, 2));
                int h2 = Integer.parseInt(next.substring(0, 2));
                int m2 = Integer.parseInt(next.substring(3));
                System.out.println(curr + "  entered previously at " + HH + ":" + MM + " and now at " + h2 + ":" + m2);
                System.out.println();
                int totalMinutes1 = HH * 60 + MM;
                int totalMinutes2 = h2 * 60 + m2;
                int timeDifference = totalMinutes2 - totalMinutes1;
                if (timeDifference <= 60) {
                    count++;
                }
            }
            if (count >= 2) {
                ans.add(curr);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}