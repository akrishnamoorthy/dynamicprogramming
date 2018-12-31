package dynamicprogramming;
/**
 * By Self
 */
public class RopeCuttingMaximalProduct{
    /**
     * 5 ( 3 +2 ) = 6
     * 10 ( 5+5 = 25, 4+4+2 = 32 , 3 +3 + 4 = 36)  = 36
     * 9 ( 5 + 4 = 20 , 3 + 3+ 3c= 27
      8 ( 3 +3+2  =18 ,4+4 =16 ,
      7 ( 3 + 4 = 12 , 3 +3 + 1 = 9
       MAx(n-1),
     */
    public static  void main(String args[]){
      int maxRope = 10 ;
      System.out.println(maxProduction(3));

    }

   static int  maxProduction(int length){
        int max = 0;
        if(length ==1 ){
            return 1;
        }
        if(length ==2 ){
            return 1;
        }

        for(int i = 1;i < length ; i ++){
            int current = maxProduction(length - i) * i ;
            current = current > ((length - i ) * i ) ? current : ((length - i )*i);
            if( current > max){
                max = current;
            }
        }

        return max;
    }
}
