//brute
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        for(int i=0;i<=n;i++){
            int flag=0;
            for(int j=0;j<n;j++){
                if(nums[j]==i){
                    flag=1;
                    break;
                }
            }
            if(flag==0) return i;
        }
        return -1;
    }
}

//O(n2)

//better 
//sorting
class Solution {
    public int missingNumber(int[] nums) {
        int c=0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(nums[i]!=c){
                return c;
            }
            c++;
        }
        return c;
    }
}
//O(NLogN)

//hash array
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int[] hash=new int[n+1];

        for(int i=0;i<n;i++){
            hash[nums[i]]=1;
        }

        for(int i=0;i<=n;i++){
            if(hash[i]==0){
                return i;
            }
        }
        return -1;
    }
}

//O(n)  time and space

//optimal
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=(n*(n+1))/2;
        int s1=0;
        for(int i=0;i<n;i++){
            s1=s1+nums[i];
        }
        return sum-s1;
    }
}

//O(n) time
//O(1) space

class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int xor1=0,xor2=0;
        for(int i=0;i<=n;i++){
            xor1=xor1^i;
        }
        for(int i=0;i<n;i++){
            xor2=xor2^nums[i];
        }
        return xor1^xor2;
    }
}