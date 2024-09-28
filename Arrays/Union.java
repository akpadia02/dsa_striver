class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<m;i++){
            set.add(arr2[i]);
        }
        ArrayList<Integer> unionList = new ArrayList<>(set);
        Collections.sort(unionList);
        // Return the resulting list
        return unionList;
    }
}

//Optimal 2 pointer
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> unionList = new ArrayList<>();

        int i = 0, j = 0;

        // Traverse both arrays using two pointers
        while (i < n && j < m) {
            // Skip duplicates in arr1
            while (i > 0 && i < n && arr1[i] == arr1[i - 1]) {
                i++;
            }

            // Skip duplicates in arr2
            while (j > 0 && j < m && arr2[j] == arr2[j - 1]) {
                j++;
            }

            // If we have traversed beyond array limits
            if (i >= n || j >= m) break;

            // Compare elements from both arrays
            if (arr1[i] < arr2[j]) {
                unionList.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                unionList.add(arr2[j]);
                j++;
            } else {
                // If both are equal, add one and move both pointers
                unionList.add(arr1[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements from arr1 (if any)
        while (i < n) {
            if (i == 0 || arr1[i] != arr1[i - 1]) {  // Skip duplicates
                unionList.add(arr1[i]);
            }
            i++;
        }

        // Add remaining elements from arr2 (if any)
        while (j < m) {
            if (j == 0 || arr2[j] != arr2[j - 1]) {  // Skip duplicates
                unionList.add(arr2[j]);
            }
            j++;
        }

        return unionList;
    }
}
