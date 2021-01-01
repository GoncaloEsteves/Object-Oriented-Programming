/**
 * @author Komatsu 
 * @version 16/04/2019
 */
public class Circulo
{
    /**
     * Variaveis de Instancia
     */
    private double x;
    private double y;
    private double raio;

    /**
     * Construtores para objetos da classe Circulo
     */
    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }
    
    public Circulo(double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }
    
    public Circulo(Circulo c){
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }

    /** 
     * @return O valor de X
     */
    public double getX(){
        return this.x;
    }
    
    /** 
     * @return O valor de Y
     */
    public double getY(){
        return this.y;
    }
    
    /**
     * @return O valor do raio
     */
    public double getRaio(){
        return this.raio;
    }
    
    /** 
     * @param x O valor a ser introduzido
     */
    public void setX(double x){
        this.x = x;
    }
    
    /** 
     * @param y O valor a ser introduzido
     * @return     a soma de x com y 
     */
    public void setY(double y){
        this.y = y;
    }
    
    /**
     * @param raio O valor a ser introduzido
     */
    public void setRaio(double raio){
        this.raio = raio;
    }
    
    /**
     * 
     */
    public String toString(){
        return ("X: " + this.x + "; Y: " + this.y);
    }
    
    public boolean equals(Circulo c){
        return (this.x == c.getX() && this.y == c.getY());
    }
    
    public void alteraCentro(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double calculaArea(){
        return (4*3.1415*Math.pow(this.raio, 2));
    }
    
    public double calculaPerimetro(){
        return (2*3.1415*this.raio);
    }
}
