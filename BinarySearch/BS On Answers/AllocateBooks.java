//linear O(N * (sum(arr[])-max(arr[])+1))
import java.util.ArrayList;
public class Solution {
    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size();
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                pagesStudent += arr.get(i);
            } else {
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n)
            return -1;

        int low = Integer.MIN_VALUE; 
        int high=0;
        for (int num : arr) {
            if (num > low) {
                low = num;
            }
            high += num;
        }

        for(int pages=low;pages<=high;pages++){
            int count=countStudents(arr,pages);
            if(count==m){
                return pages;
            }
        }
        return -1;
    }

}

//BS O(N * log(sum(arr[])-max(arr[])+1))
import java.util.ArrayList;
public class Solution {
    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size();
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                pagesStudent += arr.get(i);
            } else {
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n)
            return -1;

        int low = Integer.MIN_VALUE; 
        int high=0;
        for (int num : arr) {
            if (num > low) {
                low = num;
            }
            high += num;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}