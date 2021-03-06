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
 
import java.util.Date;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.io.*;

/**
 * Classe de gestão do complexo de hoteis
 * @author Rui Couto
 * @version 1.0
 * 
 * @author anr
 * @version 2.0 (2016/17)
 * 
 * @author MaterialPOO
 * @version 2018/19
 * 
 */
public class HoteisInc implements Serializable {

    
   /**
   * Gestão do map de comparadores.
   * A classe HoteisInc guarda os diferentes comparadores que as instâncias 
   * desta classe podem invocar para ordenar as suas instâncias de hotel.
   * Como é suposto que estes comparadores possam ser utilizados por todas as cadeias de 
   * hotéis (todas as instâncias de HoteisInc) faz sentido guardar numa variável de
   * classe.
   */   
  
    
  private static Map<String,Comparator<Hotel>> comparadores = new HashMap<>();
    
  public static void juntaOrdenacao(String nome, Comparator<Hotel> ordem) {
       comparadores.put(nome, ordem);
  }
  
 
  public static Comparator<Hotel> getOrdem(String nome) {
      return comparadores.get(nome);
  }
    
    
    /** Nome da cadeia */
    private String nome;
    /** Mapeamento de código de hotel para hotel */
    private Map<String, Hotel> hoteis;
    
    /**
     * Construtor vazio
     */
    public HoteisInc() {
        nome = "HoteisInc";
        hoteis = new HashMap<String, Hotel>();

    }

    /**
     * Construtor por cópia
     * @param c 
     */
    public HoteisInc(HoteisInc c) {
        this.nome = c.getNome();
        this.hoteis = c.getHoteis();

    }

    /**
     * Construtor por parâmetro
     * @param hoteis 
     */
    public HoteisInc(String nome, Map<String, Hotel> hoteis) {
        this.nome = nome;           // String são imutáveis
        this.hoteis = new HashMap<String,Hotel>();
        setHoteis(hoteis);
    }

    /**
     * Obter o nome da cadeia de hoteis
     * @return o nome
     */
    public String getNome() {
        return this.nome;    // Strings são imutáveis (não é necessário clone)
    }
    
   /**
     * Actualizar o nome da cadeia de hoteis
     * @return o nome
     */
    public void setNome(String nome) {
        this.nome = nome;    // Strings são imutáveis (não é necessário clone)
    }
    
    /**
     * Obter uma cópia do mapeamento de hoteis
     * (Método auxiliar para os construtores)
     * @return um Map
     */
    private Map<String, Hotel> getHoteis() {
        return this.hoteis.entrySet()
                          .stream()
                          .collect(Collectors.toMap(e->e.getKey(), e->e.getValue().clone()));
    }

    /**
     * Definir os hoteis
     * (Método auxiliar para os construtores)
     * @param hoteis 
     */
    private void setHoteis(Map<String, Hotel> hoteis) {
        this.hoteis = hoteis.entrySet()
                            .stream()
                            .collect(Collectors.toMap(e->e.getKey(), e->e.getValue().clone()));
    }   
    
    // Métodos pedidos na AULA 1
    
    /**
     * Verificar a existência de um hotel, dado o seu código.
     */
    public boolean existeHotel(String cod) {
        return this.hoteis.containsKey(cod);
    }
    
     /**
     * Devolver a quantidade de hotéis existentes na cadeia.
     */
    public int quantos() {
        return this.hoteis.size();
    }
    
    /**
     * Devolver o número total de hotéis de uma dada localidade.
     */
    public int quantos(String loc) {
        return (int) this.hoteis.values().stream()
                    .filter( h -> h.getLocalidade().equals(loc))
                    .count();                    
    }
    
    /**
     * Devolver a quantidade de hotéis de um dado tipo.
     */
    public int quantosT(String tipo) {
        int c = 0;
        for(Hotel h : this.hoteis.values()) {
            String cn = h.getClass().getSimpleName();
            if(cn.equals(tipo)) {
                c++;
            }
        }
        return c;
    }
    
   /**
     * Devolver a ficha de um hotel, dado o seu código
     * 
     * utilizar, no sítio em que seja legítimo fazer I/O, como:
     * 
     * try {
     *   Hotel h = <objecto>.getHotel(cod);
     * }
     * catch (HotelInexistenteException e) {....}
     * 
     */
    public Hotel getHotel(String cod) throws HotelInexistenteException {
        Hotel h;
        if(!hoteis.containsKey(cod)) {
            throw new HotelInexistenteException(cod);
        }
        h = hoteis.get(cod).clone();
        
        return h;
    }
    
    /**
     * Adicionar a informação de um novo hotel
     */
    public void adiciona(Hotel h) {
        this.hoteis.put(h.getCodigo(), h.clone());
    }
    
    /**
     * Calcular o valor total diário recebido, considerando uma ocupação dos hotéis de 100%.
     */
    public long total100() {
        long total = 0;
        for(Hotel h : hoteis.values()) {
            total += h.getNumeroQuartos() * h.getPrecoBaseQuarto();
        }
        return total;
    }
    
    
    public List<Hotel> getHoteisAsList() {
        return hoteis.values()
                     .stream()
                     .map(Hotel::clone)
                     .collect(Collectors.toList());
    }
    
    
    public void mudaPara(String epoca) {
        for(Hotel h : hoteis.values()) {
            if(h instanceof HotelStandard) {
                HotelStandard h2 = (HotelStandard) h;
                if(epoca.equals("alta")) {
                    h2.setEpocaAlta(true);
                } else {
                    h2.setEpocaAlta(false);
                }
            }            
        }
    }
    
    public void adiciona(Set<Hotel> hs) {
        for(Hotel h : hs) {
            adiciona(h);
        }
    }
    
    // clone, equals, toString...
    
    public List<CartaoPontos> daoPontos() {
        return hoteis.values().stream()
                    .filter(h -> h instanceof CartaoPontos)
                    .map(Hotel::clone)
                    .map(h -> (CartaoPontos) h)
                    .collect(Collectors.toList());
    }
    
    
    
    public TreeSet<Hotel> ordenarHoteis() {
        TreeSet<Hotel> t = new TreeSet<Hotel>();
        hoteis.values().forEach(h -> {
            t.add(h.clone());
        });
        return t;
    }
    
    public TreeSet<Hotel> ordenarHoteis(Comparator<Hotel> c) {
        TreeSet<Hotel> t = new TreeSet<Hotel>(c);
        hoteis.values().forEach(h -> {
            t.add(h.clone());
        });
        return t;
    }
    
    /**
     * A estratégia de colocar comparators em TreeSet necessita que o método compare
     * , do Comparator, não dê como resultado zero (caso em que o Set não permite ficar
     * com elementos repetidos). Claro que isto nem sempre é possível...
     * 
     * Uma forma de permitir continuar a ter repetições é assumir que a estrutura de
     * dados é uma lista e utilizar o método sort (método de classe de Collections) 
     * passando como parâmetro um comparator.
     */
    
    public List<Hotel> ordenarHoteisList(Comparator<Hotel> c) {
        List<Hotel> l = new ArrayList<Hotel>();
        hoteis.values().forEach(h -> {
            l.add(h.clone());
        });
        
        l.sort(c);
        return l;     
    }

    /**
     * Com a utilização de Stream pode efectuar-se directamente sobre a stream a 
     * ordenação. Através do método sorted(), para a ordem natural, ou do método 
     * sorted(c) para um comparador definido.
     */

    
    public List<Hotel> ordenarHoteisListStream(Comparator<Hotel> c) {
     return this.hoteis.values().stream()
                .map(Hotel::clone).sorted(c).collect(Collectors.toList());   
        
    }
    
    public Iterator<Hotel> ordenarHoteis(String criterio) {
        TreeSet<Hotel> r = ordenarHoteis(getOrdem(criterio)); //invocação método classe.
        return r.iterator();
    }
    
    
    //
    
    /**
     * Devolver uma cópia da instância
     * @return 
     */
    public HoteisInc clone() {
        return new HoteisInc(this);
    }

    /**
     * Verifica a igualdade com outro objecto
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
        HoteisInc hi = (HoteisInc) obj;
        return hi.getNome().equals(nome) && 
               hi.getHoteis().equals(hoteis);
    }

    
    
    /**
     * Devolve representação textual dos hoteis
     * @return 
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        /*
        sb.append("Nome da cadeia de hotéis: ").append(this.nome);
        sb.append("\n" + "Hotéis: ");
        sb.append("(");
        sb.append(", ");
        */
        for(Hotel h: this.hoteis.values())
          sb.append(h.toString());
        return sb.toString();
    }
    
    
    /**
     * Métodos que asseguram persistência.
     * 
     */
    
    /**
     * Método que guarda o estado de uma instância num ficheiro de texto.
     * 
     * @param nome do ficheiro
     */
    
    public void escreveEmFicheiroTxt(String nomeFicheiro) 
    throws FileNotFoundException {
       
       PrintWriter fich = new PrintWriter(nomeFicheiro);
       for(Hotel h: this.hoteis.values())
         fich.println(h.toString());
       fich.flush();
       fich.close();
     }

    /**
     * Método que lê um ficheiro de texto com linhas com informação de hotel.
     * 
     */
    
    public static HoteisInc importaCSV(String nome, String fich) 
                                                      throws FileNotFoundException, IOException {
            HoteisInc hi = new HoteisInc();
            hi.setNome(nome);
            List<String> hoteisCSV = HoteisInc.lerCSV(fich);
            
            hoteisCSV.forEach(s -> hi.adiciona(HoteisInc.csv2Hotel(s)));
            return hi;
        }
        
        private static List<String> lerCSV(String fich) throws FileNotFoundException, IOException {
            List<String> linhas = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(fich));
            String linha;
            
            while( (linha = br.readLine()) != null ) {
                linhas.add(linha);
            }
            br.close();
            return linhas;
        }
    
    /**
     * Método que dado uma String com a informação de um hotel, separada por vírgulas,
     * constrói uma instância de Hotel.
     * 
     * É um método de classe para não termos de criar uma instância vazia, nela invocar
     * o método, e depois obter uma outra instância.
     * Assim apenas temos de invocar o método no objecto classe e o método devolve uma 
     * instância de Hotel.
     * 
     */
    
     private static Hotel csv2Hotel(String csv) {
        Hotel h = null;
        String[] atributos; 
        String tipo, codigo, nome, localidade;
        Double precoB;
        int quartos, estrelas;
       
        atributos = csv.split(",");
        tipo = atributos[0];
        codigo = atributos[1];
        nome = atributos[2];
        localidade = atributos[3];
        
        // é preciso testar as possíveis excepções de as strings que forem lidas
        // não estarem no formato adequado
        // Devem ser testadas as excepções e, neste caso, opta-se por retornar null.
        
        try {
          precoB = Double.parseDouble(atributos[4]);
        } catch (NumberFormatException | NullPointerException e) {return null;}
        
        try {
          quartos = Integer.parseInt(atributos[5]);
        }  catch (NumberFormatException | NullPointerException e) {return null;} 
        
        try {
          estrelas = Integer.parseInt(atributos[6]);
        }  catch (NumberFormatException | NullPointerException e) {return null;}
          
        
        //Atenção: o campo das posições 7 também deveria ter um try/catch
        
        switch (tipo) {
            case "Standard": boolean epocaAlta = Boolean.parseBoolean(atributos[7]);
                             h = new HotelStandard(codigo, nome, localidade, precoB, epocaAlta, quartos, estrelas);
                             break;
            case "Premium":  double taxaP = Double.parseDouble(atributos[7]);
                             h = new HotelPremium(codigo, nome, localidade, precoB, taxaP, quartos, estrelas);
                             break;
            case "Discount":  double ocupa = Double.parseDouble(atributos[7]);
                             h = new HotelDiscount(codigo, nome, localidade, precoB, quartos, estrelas, ocupa);
                             break;
                             
        }
          
        return h;
    }
    
    
    /**
     * Método que guarda em ficheiro de objectos o objecto que recebe a mensagem.
     */
    
    public void guardaEstado(String nomeFicheiro) throws FileNotFoundException,IOException {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this); //guarda-se todo o objecto de uma só vez
        oos.flush();
        oos.close();
    }
    
    
    /**
     * Método que recupera uma instância de HoteisInc de um ficheiro de objectos.
     * Este método tem de ser um método de classe que devolva uma instância já 
     * construída de HoteisInc.
     * 
     * @param nome do ficheiro onde está guardado um objecto do tipo HoteisInc
     * @return objecto HoteisInc inicializado
     */
    
    public static HoteisInc carregaEstado(String nomeFicheiro) throws FileNotFoundException,
                                            IOException,
                                            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(nomeFicheiro);
        ObjectInputStream ois = new ObjectInputStream(fis);
        HoteisInc h = (HoteisInc) ois.readObject();
        ois.close();
        return h;
    }

}