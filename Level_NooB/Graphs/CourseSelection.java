package Graphs;

import java.util.*;;

public class CourseSelection {

    public List<Integer> ans = new ArrayList<>(); 

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer> s = new HashSet<>();
        HashMap<Integer, List<Integer>> hs = new HashMap<>();
        for (int[] pre : prerequisites) {
            int c = pre[0];
            int prereqCourse = pre[1];
            hs.putIfAbsent(c, new ArrayList<>());
            hs.get(c).add(prereqCourse);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!s.contains(i)) {
                if (!dfs(s, i, hs, new HashSet<>())) {
                    return new int[] {};
                }
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public boolean dfs(HashSet<Integer> s, int i, HashMap<Integer, List<Integer>> hs, HashSet<Integer> curr) {
        if (s.contains(i)) {
            return true;
        }
        if (!hs.containsKey(i)) {
            ans.add(i);
            s.add(i);
            return true;
        }
        curr.add(i);
        for (int pre : hs.get(i)) {
            if (curr.contains(pre) || !dfs(s, pre, hs, curr)) {
                return false;
            }
        }
        curr.remove(i);
        ans.add(i);
        s.add(i);
        return true;
    }
}
