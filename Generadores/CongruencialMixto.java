public class CongruencialMixto{
    public static void main(String [] args){
        int m = 100; 
        int a = 7;
        int c = 29;
        int semilla = 37;
        int iteraciones = 5;
        comprobacion(m, a, c);
        int resultado = congruencial(semilla, m, a, c, iteraciones);
        System.out.println(resultado);
    }

    public static int congruencial(int semilla, int modulo, int a, int c, int iteraciones){
        if(iteraciones == 0) {
            return semilla;
        } else {
            int resIteracion = (a * congruencial(semilla, modulo, a, c, iteraciones-1)+c) % modulo;
            System.out.println("X" + iteraciones + ":");
            System.out.println("Numero aleatorio: " + resIteracion);
            return resIteracion;
        }
    }

    public static void comprobacion(int m, int a, int c){
        if (maximoComunDivisor(c, m) == 1) System.out.println("Pasa primera regla");
        else System.out.println("No pasa primera regla");

        if(segundaRegla(m, a)) System.out.println("Pasa segunda regla");
        else System.out.println("No pasa segunda regla");

        if(terceraRegla(m, a)) System.out.println("Pasa tercera regla");
        else System.out.println("No pasa tercera regla");        
    } 

    public static int maximoComunDivisor(int a, int b) {
        if (b == 0) return a;
        return maximoComunDivisor(b, a % b);
    }

    public static int numPrimo(int numero) {
        if (numero <= 1) {
            return 0;
        }
        int contador = 0;
        for (int i = (int) Math.sqrt(numero); i > 1; i--) {
            if (numero % i == 0) {
                //System.out.println("Contador " + contador + " Numero " + numero + " i " + i);
                contador++;
                return i;
            }
        }
        return numero;
    }

    public static boolean segundaRegla(int m, int a){
        int q = numPrimo(m);
        System.out.println("q " + q + " de m " + m);
        if (m %  q == 0 && (a-1) % q == 0){
            return true;
        } 
        return false;
    }

    public static boolean terceraRegla(int m, int a){
        if (m % 4 == 0 && (a-1) % 4 == 0){
            return true;
        } 
        return false;
    }
}