package math;

public class Majority_Element_169 {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                res = num;
                count = 1;
            }
            else if(num == res) 
                count++;
            else{
                count--;
            }
        }
        return res;
    }
}
