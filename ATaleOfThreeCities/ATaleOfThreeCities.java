public class ATaleOfThreeCities{
    public double connect(int[] ax, int[] ay, int[] bx, int[] by, int[] cx, int[] cy){
        double minAB = Double.MAX_VALUE;
        for(int i = 0; i < ax.length; i++){
            for(int j = 0; j < bx.length; j++){
                minAB = Math.min(minAB, getDistance(ax[i], ay[i], bx[j], by[j]));
            }
        }
        
        double minAC = Double.MAX_VALUE;
        for(int i = 0; i < ax.length; i++){
            for(int j = 0; j < cx.length; j++){
                minAC = Math.min(minAC, getDistance(ax[i], ay[i], cx[j], cy[j]));
            }
        }
        
        double minBC = Double.MAX_VALUE;
        for(int i = 0; i < bx.length; i++){
            for(int j = 0; j < cx.length; j++){
                minBC = Math.min(minBC, getDistance(bx[i], by[i], cx[j], cy[j]));
            }
        }
        
        double result = Math.min(minAB + minAC, minAB + minBC);
        result = Math.min(result, minBC + minAC);
        return result;
    }
    
    private double getDistance(int ax, int ay, int bx, int by){
        if(ax == bx){
            return Math.abs(ay - by);
        }
        if(ay == by){
            return Math.abs(ax - bx);
        }
        return Math.sqrt(Math.pow(Math.abs(ax - bx),2) + Math.pow(Math.abs(ay - by),2));
    }
    
}
