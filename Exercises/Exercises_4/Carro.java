/**
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Carro extends Stand
{
    private String marca;
    private String modelo;
    private int ano;
    private double consumo;
    private double quilometros;
    private double mediaConsumo;
    private double kmUltPercurso;
    private double mediaConsUltPercurso;
    private int regeneracao;
    private int ligado;

    /**
     * Construtor para objetos da classe Carro
     */
    public Carro()
    {
        this.marca = "";
        this.modelo = "";
        this.ano = 0;
        this.consumo = 0;
        this.quilometros = 0;
        this.mediaConsumo = 0;
        this.kmUltPercurso = 0;
        this.mediaConsUltPercurso = 0;
        this.regeneracao = 0;
        this.ligado = 0;
    }
    
    public Carro(Carro c)
    {
        this.marca = c.getMarca();
        this.modelo = c.getModelo();
        this.ano = c.getAno();
        this.consumo = c.getConsumo();
        this.quilometros = c.getQuilometros();
        this.mediaConsumo = c.getMediaConsumo();
        this.kmUltPercurso = c.getKmUltPercurso();
        this.mediaConsUltPercurso = c.getMediaConsUltPercurso();
        this.regeneracao = c.getRegeneracao();
        this.ligado = c.getLigado();
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    public double getConsumo(){
        return this.consumo;
    }
    
    public double getQuilometros(){
        return this.quilometros;
    }
    
    public double getMediaConsumo(){
        return this.mediaConsumo;
    }
    
    public double getKmUltPercurso(){
        return this.kmUltPercurso;
    }
    
    public double getMediaConsUltPercurso(){
        return this.mediaConsUltPercurso;
    }
    
    public int getRegeneracao(){
        return this.regeneracao;
    }
    
    public int getLigado(){
        return this.ligado;
    }
    
    public void ligaCarro(){
        this.ligado = 1;
        this.kmUltPercurso = 0;
        this.mediaConsUltPercurso = 0;
    }
    
    public void desligaCarro(){
        this.ligado = 0;
    }
    
    public void resetUltimaViagem(){
        this.kmUltPercurso = 0;
        this.mediaConsUltPercurso = 0;
    }
    
    public void avancaCarro(double metros, double velocidade){
        if(this.ligado == 1){
            
        }
    }
}
