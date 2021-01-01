/**
 * Escreva a descrição da classe Stand aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Stand{
    private String nome;
    private Carro[] conjunto;
    private int quantos;
    
    public static final int capacidadeInicial = 10;
    /**
     * COnstrutor para objetos da classe Stand
     */
    public Stand(){
        this.nome = "";
        this.conjunto = new Carro[capacidadeInicial];  
        this.quantos = 0;
    }
    
    public Stand(String name, Carro[] conj, int q){
        this.nome = name;
        this.conjunto = conj.clone();
        this.quantos = q;
    }
    
    public Stand(Stand s){
        this.nome = s.getNome();
        this.conjunto = s.getConjunto();
        this.quantos = s.getQuantos();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public Carro[] getConjunto(){
        return this.conjunto.clone();
    }
    
    public int getQuantos(){
        return this.quantos;
    }
    
    public void setNome(String name){
        this.nome = name;
    }
    
    public void setConjunto(Carro[] conj){
        this.conjunto = conj;
    }
    
    public void setQuantos(int q){
        this.quantos = q;
    }
    
    public Stand clone(){
        return new Stand(this);
    }
    
    public String toString(){
        String aux = new String();
        String aux2 = new String();
        for(Carro v : this.conjunto){
            aux += v.toString();
        }
        return ("Nome: " + this.nome + " - Carros: " + aux + " - Quantos: " + this.quantos);
    }
    
    public boolean equals(Object o){
        if(o == this)
            return true;
        
        if(o == null || o.getClass() != this.getClass())
            return false;
            
        else{
            Stand s = (Stand) o;
            int q = s.getQuantos();
            String name = s.getNome();
            Carro[] conj = s.getConjunto();
            return (q == (this.quantos) && name.equals(this.nome) && conj.equals(this.conjunto));
        }
    }
}
