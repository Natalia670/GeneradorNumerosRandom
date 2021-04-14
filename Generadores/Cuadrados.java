public class Cuadrados{
    public static void main(String [] args){
        int resultado = cuadradoMedio(3547, 5);
    }

    public static int cuadradoMedio(int semilla, int iteraciones){
        if(iteraciones == 0) {
            return semilla;
        } else {
            int cuadrado = semilla * semilla;
            String numInicial = "";
            String numCompuesto = "";
            numInicial = cuadrado + "";
            int medio;
            int len = numInicial.length();
            switch(len){
                case 5:
                    numCompuesto = "000"+numInicial;
                    break;
                case 6:
                    numCompuesto = "00"+numInicial;
                    break;
                case 7:
                    numCompuesto = "0"+numInicial;
                    break;
                case 8:
                    numCompuesto = numInicial;
                    break;
            }
            medio = Integer.parseInt(numCompuesto.substring(2, 6));
            //Checar como invertir lo de las iteraciones
            System.out.println("X" + iteraciones + ":");
            System.out.println("Numero aleatorio: " + medio);
            return cuadradoMedio(medio, iteraciones-1);
        }
    }
}