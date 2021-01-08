
package rutaag;
import java.util.Random;

public class RutaAG {

    public static void main(String[] args) {
        Poblacion Population = new Poblacion(2);
        Random r = new Random();
        
        Population.generarPoblacionSinRepetir(10);
        imprimir(Population.getIndividuos());
        
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
}
