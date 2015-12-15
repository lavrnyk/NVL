package ua.batimyk;

public class NumberConverter {
    
    public static String toString(int i){
      String s = "";
      double n = Math.abs(Math.log10(i));
    
      for(int j = 0; j <= n; j++)
      {
          s += Math.floor((i % Math.pow(10, j+1)) / Math.pow(10, n));
      }
      return s;  
    }
    
    public static int toInt(String s){
      int ir = 0;
      int sign = 1;
      int initPos = 0;
      
      if(s.charAt(0) == '-') {
          sign = -1;
          initPos = 1;
      } 
              
      for(int i = initPos; i < s.length(); i++){                 
          int digit = (s.charAt(i)-48)*(int)Math.pow(10,s.length()- i - 1);
          ir += digit;
      }

      return sign*ir;
    }
    
    
    public static String toString(double d){
        //TODO fix this method
        String s = "";
        double n = Math.abs(Math.log10(d));

        for(int j = 0; j <= n; j++)
        {
            s += Math.floor((d % Math.pow(10, j+1)) / Math.pow(10, n));
        }
        return s;
    }
    
    
    
     public static double toDouble(String s) {

         long ir = 0;
         long sign = 1;
         int  initPos = 0;
         int  arrayLength = s.length();
         int  dotPos = arrayLength;
         boolean dotFound = false;

         if(s.charAt(0) == '-') {
             sign = -1;
             initPos = 1;
         }

         int i = initPos;
         while (i < arrayLength && !dotFound )
         {
             long digit = 0;
             digit = (s.charAt(i) - 48) * (int) Math.pow(10, s.length()- i - 1);
             if(s.charAt(i) == '.') {
                 dotPos = i;
                 dotFound = true;
             }
             ir += digit;
             i++;
         }

      return sign * ir/(long) Math.pow(10,arrayLength - dotPos);
    }

    public static void main(String[] args) {
        System.out.println(toDouble("34567."));
    }

}
