package math;

public class Statistics_from_a_Large_Sample_1093 {
    public double[] sampleStats(int[] count) {
        int n = count.length;
        int len = 0;
        double min = 0, max = 0, sum = 0;
        double mode = 0, mode_count = 0;
        
        for(int i = 0; i < n; i++){
            if(count[i] != 0){
                min = i;
                break;
            }
        }
        
        for(int i = n - 1; i >= 0; i--){
            if(count[i] != 0){
                max = i;
                break;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(count[i] == 0) continue;
            
            if(count[i] > mode_count){
                mode = i;
                mode_count = count[i];
            }
            
            len += count[i];
            sum += count[i] * i;
        }
        
        double mean = sum / len;
        
        // Index of median1 and median2
        int m1 = (len + 1) / 2;
        int m2 = (len + 2) / 2;
        boolean findM1 = false;
        double median1 = 0, median2 = 0;
        
        for(int i = 0; i < n; i++){
            if(count[i] == 0) continue;
            m1 -= count[i];
            m2 -= count[i];
            
            if(!findM1 && m1 <= 0){
                median1 = i;
                findM1 = true;
            }
            else if(!findM1 && m1 == 1){
                for(int j = i + 1; j < n; j++){
                    if(count[j] != 0){
                        median1 = j;
                        findM1 = true;
                        break;
                    }
                }
            }
            
            if(m2 <= 0){
                median2 = i;
                break;
            }
            else if(m2 == 1){
                for(int j = i + 1; j < n; j++){
                    if(count[j] != 0){
                        median2 = j;
                        break;
                    }
                }
            }
            
        }
        double median = (median1 + median2) / 2;
        return new double[]{min, max, mean, median, mode};
    }
}
