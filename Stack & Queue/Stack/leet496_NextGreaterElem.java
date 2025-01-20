class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            boolean found = false;
            for(int j=0;j<m;j++){
                 if (nums2[j]==nums1[i]) {
                    found = true;
                }
                if(found && nums1[i]<nums2[j]){
                    arr[i]=nums2[j];
                    break;
                }else{
                    arr[i]=-1;
                }
            }
        }
        return arr;
    }
}

//stack
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] nextGreater=new int[m];
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<m;i++) {
            nextGreater[i]=-1;
        }
        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                nextGreater[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i] = nextGreater[j];
                    break;
                }
            }
        }

        return result;
    }
}

//stack+hashmap
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}