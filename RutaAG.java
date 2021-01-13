
package rutaag;
import java.util.Arrays;
import java.util.Random;

public class RutaAG {

    public static void main(String[] args) {
        Poblacion Population = new Poblacion(2);
        Random r = new Random();
        
        Population.generarPoblacionSinRepetir(5);
        // imprimir(Population.getIndividuos());
        
         Cx2(Population.getIndividuos(0).getGenesCompleto(), Population.getIndividuos(1).getGenesCompleto());
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
		System.out.print("\n");
	}

    private static Individuo[] cruzaCX2(Individuo[] individuos) {
        int [] p1 = individuos[0].getGenesCompleto();
        int [] p2 = individuos[1].getGenesCompleto();
        
        //p1 = Cx2();
        
        return individuos;
    }
    
    public static void Cx2(int [] padre, int [] madre ){
//        int [] padre =  { 7, 0, 1, 9, 6, 8, 5, 4, 2, 3}; 
//        int [] madre =  { 9, 6, 4, 2, 8, 1, 7, 0, 3, 5};

        System.out.println(Arrays.toString(padre));
        System.out.println(Arrays.toString(madre));


        int [] hijo = new int [padre.length];
        hijo [0] = madre [0];
        
        int indice = hijo[0];
        int contador;
        for(int i=1;i<hijo.length;i++){
            
            indice = getIndice(padre,indice);
            hijo[i] = madre[indice];
            indice = hijo[i];
            
            contador = 0 ;
            while(contiene(hijo,indice,i)){
                indice=padre[contador];
                
                //System.out.println(indice +"=> "+ contador);
                contador++;
            }
            
        }
        System.out.println(Arrays.toString(hijo));
    }
    
    public static int getIndice(int [] arr, int num){
        for(int p=0;p<arr.length;p++){
            if( arr[p] == num ){
                return p;
            }
        }
        return -1;
    }
    
    public static boolean contiene(int [] arr, int num, int pos){
        for(int i=0;i<pos;i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }
    

}
