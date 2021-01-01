import java.lang.Math;
import java.time.temporal.ChronoUnit;
import java.lang.Object;
import java.time.LocalDate;

/**
 * @author Komatsu
 * @version 16/04/2019
 */
public class Video{
    private String nome;
    private byte[] conteudo;
    private LocalDate data;
    private int resolucao;
    private int durMin;
    private int durSeg;
    private String[] comentarios;
    private int qComen;
    private int likes, dislikes;

    /**
     * Construtores para objetos da classe Telemovel
     */
    public Video(){
        this.nome = "";
        this.conteudo = new byte[1];
        this.data = LocalDate.now();
        this.resolucao = 0;
        this.durMin = 0;
        this.durSeg = 0;
        this.comentarios = new String[1];
        this.qComen = 0;
        this.likes = 0;
        this.dislikes = 0;
    }
    
    public Video(String n, byte[] con, LocalDate d, int r, int dm, int ds, String[] com, int qc, int l, int dl){
        this.nome = n;
        this.conteudo = con.clone();
        this.data = d;
        this.resolucao = r;
        this.durMin = dm;
        this.durSeg = ds;
        this.comentarios = com.clone();
        this.qComen = qc;
        this.likes = l;
        this.dislikes = dl;
    }
    
    public Video(Video v){
        this.nome = v.getNome();
        this.conteudo = v.getConteudo();
        this.data = v.getData();
        this.resolucao = v.getResolucao();
        this.durMin = v.getDurMin();
        this.durSeg = v.getDurSeg();
        this.comentarios = v.getComentarios();
        this.qComen = v.getQComen();
        this.likes = v.getLikes();
        this.dislikes = v.getDislikes();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public byte[] getConteudo(){
        return this.conteudo.clone();
    }
    
    public LocalDate getData(){
        return this.data;
    }
    
    public int getResolucao(){
        return this.resolucao;
    }
    
    public int getDurMin(){
        return this.durMin;
    }
    
    public int getDurSeg(){
        return this.durSeg;
    }
    
    public String[] getComentarios(){
        return this.comentarios.clone();
    }
    
    public int getQComen(){
        return this.qComen;
    }
    
    public int getLikes(){
        return this.likes;
    }
    
    public int getDislikes(){
        return this.dislikes;
    }
    
    public void setNome(String nom){
        this.nome = nom;
    }
    
    public void setConteudo(byte[] con){
        this.conteudo = new byte[con.length];
        for(int i = 0; i < con.length; i++)
            this.conteudo[i] = con[i];
    }
    
    public void setData(LocalDate date){
        this.data = date;
    }
    
    public void setResolucao(int res){
        this.resolucao = res;
    }
    
    public void setDurMin(int dm){
        this.durMin = dm;
    }
    
    public void setDurSeg(int ds){
        this.durSeg = ds;
    }
    
    public void setComentarios(String[] coms){
        this.comentarios = new String[coms.length];
        for(int i = 0; i < coms.length; i++){
            this.comentarios[i] = coms[i];
        }
    }
    
    public void setQComen(int qc){
        this.qComen = qc;
    }
    
    public void setLikes(int l){
        this.likes = l;
    }
    
    public void setDislikes(int dl){
        this.dislikes = dl;
    }
    
    public void insereComentario(String comentario){
        if(this.qComen > this.comentarios.length){
            this.comentarios[this.qComen] = comentario;
            (this.qComen)++;
        }
    }
    
    public long qtsDiasDepois(){
        LocalDate aux = LocalDate.now();
        long dias = data.until(aux, ChronoUnit.DAYS);
        return dias;
    }
    
    public void thumbsUp(){
        (this.likes)++;
    }
    
    public String processa(){
        return (String.valueOf(conteudo));
    }
}
