package rutaag;
import java.util.Random;
import java.util.Arrays;

public class Poblacion  {
	private int sizePoblacion;
	private Individuo [] individuos;
	
	Random rnd = new Random();
	
	 Poblacion(int sizePoblacion){
		this.sizePoblacion = sizePoblacion;
		individuos = new Individuo [sizePoblacion];
		//generarPoblacion(rnd);
	}
	 
	public void generarPoblacion(int n_genes) {
		Individuo cromosoma;
		//int s;
		for(int i=0;i<sizePoblacion;i++) {
			cromosoma = new Individuo(n_genes);
			//do{
				//s= 0;
				for(int j=0;j<n_genes;j++) {
					//Se genera un Random entre 0-40 y se divide entre 10 para que su valor quede entre 1-4
					cromosoma.setGen(j, (rnd.nextInt(n_genes) + 1)); 
					//s = s + cromosoma.getGen(j);
				}
			//}while(s!=10);
			
			individuos[i] = cromosoma;
		}
	}
        // Comparar mi metodo con la otra forma.
        public void generarPoblacionSinRepetir(int n_genes){
            
            Individuo cromosoma;
            int [] posiciones = new int[n_genes];
            int [] c_posiciones;
            int [] genesOrdenados;
            int pos;
            for(int l = 0; l < sizePoblacion; l++){
                for (int i=0;i<n_genes;i++){
                    do{
                        pos = rnd.nextInt((n_genes*100) + 1);
                        if(seRepite(posiciones,pos)){
                            pos = 0;
                         }
                    }while(pos == 0);

                    posiciones[i] = pos;
                }
                cromosoma = new Individuo(10);
                c_posiciones = posiciones.clone();
                genesOrdenados = posiciones.clone();
                Arrays.sort(posiciones);

                for(int k = 0;k<n_genes;k++){
                    genesOrdenados[k] = devolverPosicion(c_posiciones, posiciones[k]);
                    //System.out.println((k+1)+"=> "+ c_posiciones[k] + " => "+posiciones[k] + " => "+genesOrdenados[k]);
                }
                cromosoma.setGenes(genesOrdenados);
                individuos[l] = cromosoma; 
            }
        }

	public int getSizePoblacion() {
		return sizePoblacion;
	}

	public Individuo[] getIndividuos() {
		return individuos;
	}
	
	public Individuo getIndividuos(int p) {
		return individuos[p];
	}

	public void setIndividuos(Individuo[] individuos) {
		this.individuos = individuos;
	}	
	
	public void setIndividuosEspecifico(Individuo individuo,int posicion) {
		this.individuos[posicion]= individuo;
	}

	public void corregirPoblacion(int ChangeValor) {
		Individuo ind;
		int sumaValores;
		int mayor;
		int valorGen;
		int posicionMayor;
		
		for(int i=0;i<sizePoblacion;i++){
			posicionMayor = 0;
			mayor = 0; 
			sumaValores = 0;
			ind = individuos[i];
			for(byte j=0;j<4;j++){
				valorGen = ind.getGen(j);
				if(valorGen<=ChangeValor){
					ind.setGen(j, rnd.nextInt(4)+1);
				}
			}
			for(byte l=0;l<4;l++){
				valorGen = ind.getGen(l);
				sumaValores = sumaValores + valorGen;
				if(mayor<valorGen){
					mayor = valorGen;
					posicionMayor = l;
				}
			}
			
			if(sumaValores>10){
				mayor = mayor - (sumaValores-10);
				ind.setGen(posicionMayor, (mayor<0)?mayor*-1:mayor);
			}
			individuos[i] = ind;
		}
	}

    private int devolverPosicion(int[] arr, int n) {
        int pos = -1;
        for(int i = 0; i<arr.length;i++){
            if(arr[i] == n) {
                pos = i;
            }
        }
        return pos;
    }

    private boolean seRepite(int[] posiciones, int pos) {
        for(int i = 0;i<posiciones.length;i++){
            if(posiciones[i]==pos){
                return true;
            }
        }
        return false;
    }
}
