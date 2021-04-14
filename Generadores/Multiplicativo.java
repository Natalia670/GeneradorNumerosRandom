public class Multiplicativo{
    public static void main(String [] args){
        int resultado = multiplicativo(117, 1000, 43, 10);
    }

    public static int multiplicativo(int semilla, int modulo, int a, int iteraciones){
        if(iteraciones == 0) {
            return semilla;
        } else {
            int resIteracion = (a * multiplicativo(semilla, modulo, a, iteraciones-1)) % modulo;
            System.out.println("X" + iteraciones + ":");
            System.out.println("Numero aleatorio: " + resIteracion);
            return resIteracion;
        }
    }
}