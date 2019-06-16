package array;

public class Duplicate_Zeros_1089 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int sh = 0;
        int i = 0;
        
        for(i = 0; i + sh < n; i++){
            if(arr[i] == 0) sh++;
        }
        
        for(i = i - 1; sh > 0; i--){
            if(i + sh < n) 
                arr[i + sh] = arr[i];
            if(arr[i] == 0)
                arr[i + --sh] = 0;
        }
    }
}
