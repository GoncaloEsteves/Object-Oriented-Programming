/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/


import java.io.*;

/**
 * Hotel Standard, com preço variável dependendo da época
 * @author Rui
 * @author anr
 * @version 2.0
 */
public class HotelStandard extends Hotel implements CartaoPontos, Serializable {

    /** Indica se hotel se encontra em época alta */
    private boolean epocaAlta;
    
    /**
     * Construtor vazio
     */
    public HotelStandard() {
        super();
        this.epocaAlta = false;
    }

    /**
     * Construtor por cópia
     * @param c 
     */
    public HotelStandard(HotelStandard c) {
        super(c);
        this.epocaAlta = c.getEpocaAlta();
    }
    
    /**
     * Construtor por parâmetro
     * @param codigo
     * @param nome
     * @param localidade
     * @param precoBaseQuarto
     * @param epocaAlta 
     */
    public HotelStandard(String codigo, String nome, String localidade
                        , double precoBaseQuarto, boolean epocaAlta, int nquartos, int estrelas) {
        super(codigo, nome, localidade, precoBaseQuarto, nquartos, estrelas);
        this.epocaAlta = epocaAlta;
    }
    
    /**
     * Calcula o preço de uma noite no hotel
     * @return valor aumentado da taxa de época alta (se for o caso)
     */
    
    public double precoNoite() {
        return getPrecoBaseQuarto() + (this.epocaAlta?20:0);
    }

    /**
     * Indica se hotel se encontra em época alta
     * @return 
     */
    public boolean getEpocaAlta() {
        return epocaAlta;
    }

    /**
     * Define época alta
     * @param epocaAlta 
     */
    public void setEpocaAlta(boolean epocaAlta) {
        this.epocaAlta = epocaAlta;
    }
    
    /**
     * Retorna uma cópia da instância
     * @return 
     */
    public HotelStandard clone() {
        return new HotelStandard(this);
    }

    /**
     * Compara a igualdade com outro objecto
     * @param obj
     * @return 
     */
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        HotelStandard o = (HotelStandard) obj;
        return super.equals(o) && o.getEpocaAlta() == epocaAlta;
    }

    /**
     * Retorna representação textual
     * @return 
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Standard,");
        sb.append(super.toString());
        sb.append(this.epocaAlta);
        return sb.toString();
    }

    
    //interface
    
    private int pontos;
    
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    public int getPontos() {
        return this.pontos;
    }
    
}