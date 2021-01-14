
package rutaag;
import java.util.Arrays;
import java.util.Random;

public class RutaAG {

    public static void main(String[] args) {
        Poblacion Population = new Poblacion(2);
        Random r = new Random();
        
        Population.generarPoblacionSinRepetir(10);
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
    
    public static void Cx2(int [] dad, int [] mom ){
//        int [] padre =  { 7, 0, 1, 9, 6, 8, 5, 4, 2, 3}; 
//        int [] madre =  { 9, 6, 4, 2, 8, 1, 7, 0, 3, 5};

        System.out.println(Arrays.toString(dad));
        System.out.println(Arrays.toString(mom));

        int [] son = new int [dad.length];
        son [0] = mom [0]; // Validar Aqui.
        
        int index = 1;
        int sonValue = son[0];
        int counter;       
        
        while (index < son.length ){
            counter = 1;
            sonValue = mom[getIndex(dad,sonValue)];
            while(contains(son,sonValue,index)){
                sonValue= mom[getIndex(dad,dad[counter])];
                counter++;
            }
            son[index] = sonValue; 
            index+=1;
        }

        System.out.println(Arrays.toString(son));
    }
    
    public static int getIndex(int [] arr, int num){
        for(int position=0;position<arr.length;position++){
            if( arr[position] == num ){
                return position;
            }
        }
        return -1;
    }
    
    public static boolean contains(int [] arr, int num, int pos){
        for(int i=0;i<pos;i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }  
}
