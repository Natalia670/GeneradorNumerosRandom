import java.util.ArrayList;

public class CongruencialLinealCombinado {
    public ArrayList<Float> sem1 = new ArrayList<>();
    public ArrayList<Float> sem2 = new ArrayList<>();
    public ArrayList<Float> generador1 = new ArrayList<>();
    public ArrayList<Float> generador2 = new ArrayList<>();
    public ArrayList<Float> generador3 = new ArrayList<>();

    public void GenLinealComb(float s1, float s2, float a1, float a2, float m1, float m2,  float n){

        float result1 = s1;
        float result2 = s2;
        float mod [] = {m1, m2};
        float modMax = getModMayor(mod, 2);
     
        for (int i = 0; i<n; i++){
            sem1.add(result1);
            sem1.add(result2);

            float res1 = ( result1 * a1) % m1;
            float res2 = (result2 * a2) % m2;
           
            result1 = res1;
            result2 = res2;
       
            generador1.add(res1);
            generador2.add(res2);

           
            float sum = ((res1 - res2) % modMax + modMax) % modMax;
         

            generador3.add(sum);
        }
        
       
    }
    
    public static float getModMayor(float[] a, int total){  
     float temp;  
      for (int i = 0; i < total; i++)   
        {  
            for (int j = i + 1; j < total; j++)   
            {  
                if (a[i] > a[j])   
                {  
                    temp = a[i];  
                    a[i] = a[j];  
                    a[j] = temp;  
                }  
            }  
        }  
       return a[total-1];  
}  
    
    
    public  void tabla (){
              for(int j=0; j<generador1.size(); j++){
           System.out.print("Xn: " + generador1.get(j) + " ");
          
       
   }
                  for(int j=0; j<generador2.size(); j++){
           System.out.print("Yn: " + generador2.get(j) + " ");
            System.out.print("\n");
       
   }
                  
          for(int j=0; j<generador3.size(); j++){
           System.out.print("Wn: " + generador3.get(j) + " ");
           System.out.print("\n");
       
   }   
    }

    
   public static void main(String[] args) {
       CongruencialLinealCombinado clc = new CongruencialLinealCombinado();
       clc.GenLinealComb(1, 3, 3, 5,5,7,13 );
       clc.tabla();
       
        
      
   }
}