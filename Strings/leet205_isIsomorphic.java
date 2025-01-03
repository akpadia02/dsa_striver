class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m != n) {
            return false;
        } else {
            int[] maps = new int[256];
            int[] mapt = new int[256];
            for (int i = 0; i < n; i++) {
                char chars = s.charAt(i);
                char chart = t.charAt(i);
                if (maps[chars] != mapt[chart]) {
                    return false;
                }
                maps[chars] = i + 1;
                mapt[chart] = i + 1;
            }
            return true;
        }
    }
}