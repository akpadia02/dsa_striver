public class ArrayIntersection {

    public static List<Integer> findArrayIntersection(int[] A, int[] B) {
        List<Integer> ans = new ArrayList<>();
        int m = B.length; 
        boolean[] vis = new boolean[m]; 

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i] == B[j] && !vis[j]) {
                    ans.add(A[i]); 
                    vis[j] = true;
                    break; 
                }
                if (B[j] > A[i]) break; 
            }
        }

        return ans; 
    }
}

//optimal 2 pointer
public class ArrayIntersection {

    public static List<Integer> findArrayIntersection(int[] A, int[] B) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0; // Initialize two pointers

        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                i++; // Move pointer i forward if A[i] is smaller
            } else if (A[i] > B[j]) {
                j++; // Move pointer j forward if B[j] is smaller
            } else {
                // Found a match
                // Ensure uniqueness
                if (ans.isEmpty() || ans.get(ans.size() - 1) != A[i]) {
                    ans.add(A[i]); // Add the intersecting element to the result
                }
                i++; // Move both pointers forward
                j++;
            }
        }

        return ans; // Return the result
    }
}