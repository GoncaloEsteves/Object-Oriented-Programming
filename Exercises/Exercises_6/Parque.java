import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Collection;
import java.util.stream.Collectors;
/**
 * Parque 
 * 
 * @author Komz 
 * @version 26/03/2019
 */
public class Parque
{
    private String nome;
    /** String -> matricula; Lugar -> lugar ocupado**/
    private Map<String,Lugar> lugares;

    /**
     * COnstrutor para objetos da classe Parque
     */
    public Parque(){
        this.nome = "";
        this.lugares = new HashMap<>();
    }
    
    public Parque(Parque parque){
        this.lugares = parque.getLugares();
        this.nome = parque.getNome();
    }
    
    public Parque(String nome, Map<String,Lugar> lugares){
        this.setNome(nome);
        this.setLugares(lugares);
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Map<String,Lugar> getLugares(){
        Map<String,Lugar> res = new HashMap<>();
        for(String matricula : this.lugares.keySet()){
            Lugar l = this.lugares.get(matricula);
            res.put(matricula, l.clone());
        }
        return res;
    }
    
    public Map<String,Lugar> getLugares2(){
        Map<String,Lugar> res = new HashMap<>();
        Collection<Lugar> ls = this.lugares.values();
        for(Lugar l : ls){
            res.put(l.getMatricula(), l.clone());
        }
        return res;
    }
    
    public Map<String,Lugar> getLugares3(){
        Map<String,Lugar> res = new HashMap<>();
        for(Map.Entry<String,Lugar> par : this.lugares.entrySet()){
            String matricula = par.getKey();
            Lugar l = par.getValue().clone();
            res.put(matricula, l);
        }
        return res;
    }
    
    public void setLugares(Map<String,Lugar> lugares){
        this.lugares = lugares.values().stream()
                              .collect(Collectors.toMap((lugar) -> lugar.getMatricula(), (lugar) -> lugar.clone()));
    }
    
    public Set<String> todasMatriculas(){
        Set<String> res = this.lugares.keySet().stream()
                                               .collect(Collectors.toSet());
        return res;
    }
    
    public int lugares(){
        return this.lugares.size();
    }
}