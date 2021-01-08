package rutaag;

public class Individuo {
	
	private int genes[];
	
	Individuo(int n_genes){
		genes = new int [n_genes];
	}

	public int[] getGenesCompleto() {
		return genes;
	}
	
	public int getGen(int index) {
		return genes[index];
	}

	public void setGenes(int[] genes) {
		this.genes = genes;
	}
	
	public void setGen( int p,int valor) {
		genes[p] = valor;
	}
        
        public int getNumeroGenes(){
            return genes.length;
        }
}
