package ua.batimyk;

public class NumberConverter {
    
    public static String toString(int i){
     // int j = 0;
      String s = "";
      double n = Math.abs(Math.log10(i));
           
    
      for(int j = 0; j <= n; j++)
      {
          System.out.println( Math.floorDiv(i, (int)Math.pow(10, j)));
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
         ir += (s.charAt(i)-48)*(int)Math.pow(10,s.length()- i - 1);
      }      
             
      return sign*ir;
    }
    
    
   /* public static String toString(double d){
      Srting s;
      return s;
    }
    
    
    
    public static double toDouble(String s) {
      double d;
      return d;
    }*/
    
    public static void main(String[] ars) {
    
       System.out.println(toString(12345));
       System.out.println(toString(1));
       System.out.println(toInt("-1"));
       System.out.println(toInt("12345"));
       System.out.println(toInt("-12345"));
       
       System.out.println(123%100);
       System.out.println(Math.floorDiv(123,100));
       
    }
    
}
