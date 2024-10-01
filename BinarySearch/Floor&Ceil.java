class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int low = 0, high = n - 1;
        int floor = -1, ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x) {
                floor = arr[mid];
                low = mid + 1;
            } else if (arr[mid] > x) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                floor = arr[mid];
                ceil = arr[mid];
                break; 
            }
        }

        return new int[]{floor, ceil};
    }
}