
package rutaag;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RutaAG {

    public static void main(String[] args) {
        
        int numeroDeIndividuos   = 6;
        int numeroDeGeneraciones = 20;
        double indiceDeCruza     = 0.80;
        Poblacion Population = new Poblacion(numeroDeIndividuos);
        Population.generarPoblacionSinRepetir(6);
        imprimir(Population.getIndividuos());
        int [][] distancias = llenar(6);
        System.out.println("Aptitud: "+calcularAptitud(Population.getIndividuos(0).getGenesCompleto(),distancias) + "\n");
//        for( byte generacion = 0 ; generacion<numeroDeGeneraciones ; generacion++ ){
//            
//            Individuo [] nuevaPoblacion = Population.getIndividuos();
//            Random rnd = new Random();
//            
//            for( byte contador = 0 ; contador < numeroDeIndividuos ; contador++){
//                 
//                double porcentajeDeCruza = rnd.nextDouble() * 1;
//                
//                if( porcentajeDeCruza < indiceDeCruza ) {
//                    int primeraPosicionDeCruza,
//                        segundaPosicionDeCruza;
//               
//                    do {
//                        primeraPosicionDeCruza = rnd.nextInt(numeroDeIndividuos);
//                        segundaPosicionDeCruza = rnd.nextInt(numeroDeIndividuos);
//                      } while ( primeraPosicionDeCruza == segundaPosicionDeCruza );
//                      
//                    int [] individuoUno = nuevaPoblacion[primeraPosicionDeCruza].getGenesCompleto();
//                    int [] individuoDos = nuevaPoblacion[segundaPosicionDeCruza].getGenesCompleto();
//                    
//                    int [] aux = individuoUno;
//                    individuoUno = cruzaPorCX2(individuoUno,individuoDos);
//                    individuoDos = cruzaPorCX2(individuoDos,aux);
//                    
//                    nuevaPoblacion[primeraPosicionDeCruza].setGenes(individuoUno);
//                    nuevaPoblacion[segundaPosicionDeCruza].setGenes(individuoDos);
//                }
//            }
//        }
//        imprimir(Population.getIndividuos());

        //cruzaPorCX2(Population.getIndividuos(0).getGenesCompleto(), Population.getIndividuos(1).getGenesCompleto());
        //exchangeValue(Population.getIndividuos(0).getGenesCompleto());
        //System.out.println(Population.getIndividuos(4).getGen(0));
    }  
    
    static void imprimir(Individuo ind[]){
		int [] num;
		for(int i=0;i<ind.length;i++) {
			num  = ind[i].getGenesCompleto();
			System.out.print("\n"+(i+1)+" - ");
			for(int j=0;j<num.length;j++) {
				System.out.print(num[j] + " ");
			}
		}
		System.out.println(" ");
	}

    private static Individuo[] cruzaCX2(Individuo[] individuos) {
        int [] p1 = individuos[0].getGenesCompleto();
        int [] p2 = individuos[1].getGenesCompleto();
        
        //p1 = Cx2();
        
        return individuos;
    }
    
    // Recibe dos arreglos, que deben contener los mismos elementos sin repetir.
    public static int [] cruzaPorCX2(int [] dad, int [] mom ){
        int [] son = new int [dad.length];
        son [0] = mom [0]; 
        int index = 1; // Inicia en 1 porque la posicion 0 ya contiene un valor.
        int sonValue = son[0];
        int counter;       
        
        while (index < son.length ){
            counter = 1;
            sonValue = mom[getIndex(dad,sonValue)]; // Primero optiene la pocision en el arreglo dad, jala el valor que se encuenta en esa posicion de mom, y lo asigna a sonValue.
            while(contains(son,sonValue,index)){ // Si sonValue ya se encuentra en el arreglo, busca un valor que no lo contenga.
                sonValue= mom[getIndex(dad,dad[counter])];
                counter++;
            }
            son[index] = sonValue; // asigna el valor en la posicion actual del indice.
            index+=1;
        }
        return son;
    }
    
    public static void exchangeValue(int [] arr){
        Random rnd = new Random();
        int position_1, // se declara las variables necesarias para realizar el intercambio.
            position_2,
            value;
        
        do {
            position_1 = rnd.nextInt(arr.length);
            position_2 = rnd.nextInt(arr.length);
        } while ( position_1 == position_2 );
        
        // Se realiza el intercambio.
        value = arr[position_1];
        arr[position_1] = arr[position_2];
        arr[position_2] = value;
    }
    //Este metodo optiene la posicion de un numero en un arreglo.
    public static int getIndex(int [] arr, int num){
        for(int position=0;position<arr.length;position++){
            if( arr[position] == num ){
                return position;
            }
        }
        return -1;
    }
    
    // Verifica si en el arreglo ya se encuentra el mismo valor, pero solo verifica hasta determinada posicion.
    public static boolean contains(int [] arr, int num, int pos){
        for(int i=0;i<pos;i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }  

    private static Individuo[] tournamentSelection(Individuo[] individuos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static int[][] llenar(int t) {
        int [][] distancias = new int [t][t];
        Random rnd = new Random();
        System.out.println(" ");
        for(int i = 0; i<t;i++ ){
            System.out.print("= " + i + " => ");
            for(int j=0;j<t;j++){
                if(i==j){
                    distancias[i][j] = 0;
                }else{
                    distancias[i][j] = rnd.nextInt(10000) + 1;
                }
                System.out.print(distancias[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        return distancias;
    }
    
    public static int calcularAptitud(int [] arr, int [][] distancias){
        int aptitud = 0;
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                System.out.println(distancias[arr[i]][arr[0]]);
                aptitud = aptitud + distancias[arr[i]][arr[0]];
            }else{
                System.out.println(distancias[arr[i]][arr[i+1]]);
                aptitud = aptitud + distancias[arr[i]][arr[i+1]];
            }
        }
        return aptitud;
    }


}
