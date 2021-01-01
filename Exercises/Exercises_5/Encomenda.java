import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * Classe que compoe uma encomenda completa,
 * constituida nao sao pelas diversas linhas de encomenda e o seu numero,
 * como tambem pelas informacoes do cliente
 * 
 * @author Komatsu 
 * @version 19/04/2019
 */
public class Encomenda{
    private List<LinhaEncomenda> linhas;
    private String cliente;
    private int nif;
    private String morada;
    private int numero;
    private LocalDate data;

    /**
     * Construtor para objetos da classe Encomenda (por omissao)
     */
    public Encomenda(){
        this.linhas = new ArrayList<LinhaEncomenda>();
        this.cliente = "n/a";
        this.nif = 0;
        this.morada = "n/a";
        this.numero = 0;
        this.data = LocalDate.now();
    }
    
    /**
     * Construtor para objetos da classe Encomenda (por parameterizacao)
     */
    public Encomenda(List<LinhaEncomenda> enc, String c, int nf, String mor, int num, LocalDate d){
        this.linhas = new ArrayList<LinhaEncomenda>(enc.size());
        for(LinhaEncomenda l : enc)
            this.linhas.add(l);
        this.cliente = c;
        this.nif = nf;
        this.morada = mor;
        this.numero = num;
        this.data = d;
    }
    
    /**
     * Construtor para objetos da classe Encomenda (por referencia)
     */
    public Encomenda(Encomenda e){
        this.linhas = e.getLinhas();
        this.cliente = e.getCliente();
        this.nif = e.getNif();
        this.morada = e.getMorada();
        this.numero = e.getNumero();
        this.data = e.getData();
    }
    
    /**
     * Metodo que nos devolve as linhas de encomenda de uma encomenda
     * @return as linhas de encomenda
     */
    public List<LinhaEncomenda> getLinhas(){
        List<LinhaEncomenda> res = new ArrayList<LinhaEncomenda>(this.linhas.size());
        this.linhas.stream().forEach(a -> res.add(a.clone()));
        return res;
    }
    
    /**
     * Metodo que insere um conjunto de linhas de encomenda numa encomenda
     * @param l as linhas de encomenda
     */
    public void setLinhas(List<LinhaEncomenda> l){
        this.linhas = new ArrayList<LinhaEncomenda>(l.size());
        for(LinhaEncomenda aux : l)
            this.linhas.add(aux);
    }
    
    /**
     * Metodo que nos devolve o nome do cliente de uma dada encomenda
     * @return o nome do cliente
     */
    public String getCliente(){
        return this.cliente;
    }
    
    /**
     * Metodo que insere um nome de cliente numa encomenda
     * @param c o nome do cliente
     */
    public void setCliente(String c){
        this.cliente = c;
    }
    
    /**
     * Metodo que nos devolve o nif de uma dada encomenda
     * @return o nif
     */
    public int getNif(){
        return this.nif;
    }
    
    /**
     * Metodo que insere um nif numa encomenda
     * @param n o nif
     */
    public void setNif(int n){
        this.nif = n;
    }
    
    /**
     * Metodo que nos devolve a morada de uma dada encomenda
     * @return a morada
     */
    public String getMorada(){
        return this.morada;
    }
    
    /**
     * Metodo que insere uma morada numa encomenda
     * @param m a morada
     */
    public void setMorada(String m){
        this.morada = m;
    }
    
    /**
     * Metodo que nos devolve o numero de uma dada encomenda
     * @return o numero
     */
    public int getNumero(){
        return this.numero;
    }
    
    /**
     * Metodo que insere um numero numa encomenda
     * @param n o numero
     */
    public void setNumero(int n){
        this.numero = n;
    }
    
    /**
     * Metodo que nos devolve a data de uma dada encomenda
     * @return a data
     */
    public LocalDate getData(){
        return this.data;
    }
    
    /**
     * Metodo que insere uma data numa encomenda
     * @param d a data
     */
    public void setData(LocalDate d){
        this.data = d;
    }
    
    /**
     * Metodo que clona uma dada encomenda
     * @return o clone da encomenda
     */
    public Encomenda clone(){
        return new Encomenda(this);
    }
    
    /**
     * Metodo que determina se uma encomenda e um dado objeto sao iguais
     * @param o o objeto a analisar
     * @return a conclusao da comparacao
     */
    public boolean equals(Object o){
        if(o == this)
            return true;
        
        if(o == null || o.getClass() != this.getClass())
            return false;
            
        Encomenda e = (Encomenda) o;
        return (this.linhas.equals(e.getLinhas())
             && this.cliente == e.getCliente()
             && this.nif == e.getNif()
             && this.morada == e.getMorada()
             && this.numero == e.getNumero()
             && this.data == e.getData());
    }
    
    /**
     * Metodo que determina o valor total da encomenda
     * @return o valor total
     */
    public double calculaValorTotal(){
        double total = 0;
        for(LinhaEncomenda l : this.linhas){
            total += l.calculaValorLinhaEnc();
        }
        return total;
    }
    
    public double calculaValorTotal2(){
        double total = 0;
        LinhaEncomenda l = new LinhaEncomenda();
        Iterator<LinhaEncomenda> it = this.linhas.iterator();
        while(it.hasNext()){
            l = it.next();
            total += l.calculaValorLinhaEnc();
        }
        return total;
    }
    
    /**
     * Metodo que determina o total de descontos obtidos
     * @return o total de descontos
     */
    public double calculaDescontosTotal(){
        double total = 0;
        for(LinhaEncomenda l : this.linhas){
            total += l.calculaValorDesconto();
        }
        return total;
    }
    
    public double calculaDescontosTotal2(){
        double total = 0;
        LinhaEncomenda l = new LinhaEncomenda();
        Iterator<LinhaEncomenda> it = this.linhas.iterator();
        while(it.hasNext()){
            l = it.next();
            total += l.calculaValorDesconto();
        }
        return total;
    }
    
    /**
     * Metodo que determina o numero total de produtos a receber
     * @return o numero total de produtos
     */
    public int numeroTotalProdutos(){
        int total = 0;
        for(LinhaEncomenda l : this.linhas){
            total += l.getQuantidade();
        }
        return total;
    }
    
    public int numeroTotalProdutos2(){
        int total = 0;
        LinhaEncomenda l = new LinhaEncomenda();
        Iterator<LinhaEncomenda> it = this.linhas.iterator();
        while(it.hasNext()){
            l = it.next();
            total += l.getQuantidade();
        }
        return total;
    }
    
    /**
     * Metodo que determina se um dado produto vai ser encomendado
     * @param refProduto o produto que se pretende analisar
     * @return true caso va ser, false caso contrario
     */
    public boolean existeProdutoEncomenda(String refProduto){
        boolean res = false;
        for(LinhaEncomenda l : this.linhas){
            if(refProduto == l.getReferencia())
                res = true;
        }
        return res;
    }
    
    public boolean existeProdutoEncomenda2(String refProduto){
        boolean res = false;
        Iterator<LinhaEncomenda> it = this.linhas.iterator();
        LinhaEncomenda l = new LinhaEncomenda();
        while(it.hasNext() && !res){
            l = it.next();
            if(l.getReferencia() == refProduto)
                res = true;
            }
        return res;
    }
    
    public boolean existeProdutoEncomenda3(String refProduto){
        return this.linhas.stream().anyMatch(l -> l.getReferencia() == refProduto);
    }
    
    /**
     * Metodo que adiciona uma nova linha de encomenda
     * @param linha a linha a ser adicionada
     */
    public void adicionaLinha(LinhaEncomenda linha){
        this.linhas.add(linha.clone());
    }
    
    /**
     * Metodo que, dada a referencia do produto, remove uma linha de encomenda
     * @param codProd o codigo do produto 
     */
    public void removeProduto(String codProd){
        for(LinhaEncomenda l : this.linhas){
            if(l.getReferencia() == codProd)
                this.linhas.remove(l);
        }
    }
    
    public void removeProduto2(String codProd){
        this.linhas.stream().filter(l -> l.getReferencia() != codProd);
    }
}
