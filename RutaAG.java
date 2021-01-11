
package rutaag;
import java.util.Arrays;
import java.util.Random;

public class RutaAG {

    public static void main(String[] args) {
        Poblacion Population = new Poblacion(2);
        Random r = new Random();
        
        //Population.generarPoblacionSinRepetir(10);
        // imprimir(Population.getIndividuos());
        //Population.setIndividuos(cruzaCX2(Population.getIndividuos()));
        
         Cx2();
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
    
    public static void Cx2(){
        int [] padre = { 7, 0, 1, 9, 6, 8, 5, 4, 2, 3};
        int [] madre = { 9, 6, 4, 2, 8, 1, 7, 0, 3, 5};
        int [] hijo = new int [padre.length];
        hijo [0] = madre [0];
        //System.out.println(hijo[0]);
        
        int indice = hijo[0];
        for(int i=1;i<hijo.length;i++){
            indice = getIndice(padre,indice);
            hijo[i] = madre[indice];
            indice = hijo[i];
            
            if(getIndice(hijo,indice) != -1){
                indice = corregirIndice(padre,hijo,indice, i);
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

    public static int corregirIndice(int[] padre, int[] hijo, int ind, int i) {
       
       int cnt = 0;
       do{
           ind = padre[cnt];
           System.out.println(ind);
           cnt++;
       }while(getIndice(hijo,ind) != -1 || cnt<i);
       
       
       return ind;
    }
    
    
}
