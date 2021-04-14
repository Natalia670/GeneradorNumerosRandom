public class Congruencial{
    public static void main(String [] args){
        int resultado = congruencial(4, 8, 5, 7, 10);
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
}