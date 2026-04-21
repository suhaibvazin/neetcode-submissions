class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = speed.length;
        if (len == 0) return 0;
        double [][] metrics = new double [len][2];

        for(int i=0;i<len;i++){
           metrics[i][0] =(double)(target-position[i])/speed[i]; //time left
           metrics[i][1] = position[i];
        }

        Arrays.sort(metrics,(a,b)->Double.compare(b[1], a[1]));

        double currentMaxSpeed =0;
        int fleet = 0;

        for(int i=0;i<len;i++){
            double timeToReach = metrics[i][0];
            if(timeToReach > currentMaxSpeed){
                fleet++;
                currentMaxSpeed = timeToReach;
            }
        }
        return fleet;  
    }
}
