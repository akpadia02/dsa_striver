class Solution {
    public int romanToInt(String s) {
        int[] values = new int[128];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int current = values[s.charAt(i)];
            if (i + 1 < n && current < values[s.charAt(i + 1)]) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}