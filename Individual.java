package ada.genetic;
import java.util.Random;

public class Individual
{
	public static final int SIZE = 10;
    private int[] genes = new int[SIZE];
    private int fitnessValue;

    public int[] START = new int[SIZE] ;
    public int[] END = new int[SIZE] ;
    	    
    public Individual(int[] START, int[] END) {
    	for(int i=0;i<SIZE;i++){
    		
    		this.START[i] = START[i];
    		this.END[i] = END[i];
    		
    	}	
    }
    
    public Individual() {
    }

    public int getFitnessValue() {
        return fitnessValue;
    }

    public void setFitnessValue(int fitnessValue) {
        this.fitnessValue = fitnessValue;
    }

    public int getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, int gene) {
        this.genes[index] = gene;
    }

    public void randGenes() {
    	
        Random rand = new Random();
        
        for(int i=0; i<SIZE; ++i) {
            this.setGene(i, rand.nextInt(END[i]-START[i]+1)+START[i]);
            
         //   System.out.print(" " + getGene(i)); 
        }

        // System.out.println(" end of gene "); 
    }

    public String toString(){
    	String result = "";
    	
    	 for(int i=0; i<SIZE; ++i) {
             result += " " + getGene(i); 
         }
    	 return result;
    }
    
    public void mutate() {
        Random rand = new Random();
        
        int index = rand.nextInt(SIZE);
        
        // randomly assign new value to gene
        
        this.setGene(index, rand.nextInt(END[index]-START[index]+1)+START[index]);
                
        // this.setGene(index, 1-this.getGene(index));    // flip
    }

    public int evaluate() {
    	
        int fitness = 0;
        
        for(int i=0; i<SIZE; ++i) {
            fitness += this.getGene(i);
        }
        this.setFitnessValue(fitness);

        return fitness;
    }
}
