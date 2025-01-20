class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        Arrays.fill(arr, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                arr[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        
        return arr;
    }
}

//arrays
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize result array with -1
        
        // Traverse the array twice to handle the circular condition
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (nums[(i + j) % n] > nums[i]) {
                    result[i] = nums[(i + j) % n];
                    break;
                }
            }
        }
        
        return result;
    }
}
