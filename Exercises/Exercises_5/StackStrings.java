import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * Escreva a descrição da classe StackStrings aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class StackStrings
{
    private List<String> stack;
    private int capacidade;
    
    private static int capacidade_Inicial = 20;

    /**
     * COnstrutor para objetos da classe StackStrings
     */
    public StackStrings(){
        this.stack = new ArrayList<String>(capacidade_Inicial);
        this.capacidade = capacidade_Inicial;
    }
    
    public StackStrings(int capacidade){
        this.stack = new ArrayList<String>(capacidade);
        this.capacidade = capacidade;
    }
    
    public StackStrings(List<String> s){
        this.setStack(s);
    }

    public StackStrings(StackStrings s){
        this.stack = s.getStack();
    }
    
    public List<String> getStack(){
        List<String> res = new ArrayList<String> (this.capacidade);
        this.stack.stream().forEach(a -> res.add(a));
        return res;
    }
    
    public void setStack(List<String> s){
        this.stack = new ArrayList<String>();
        for(String aux : s){
            this.stack.add(aux);
        }
    }
    
    public int getCapacidade(){
        return this.capacidade;
    }
    
    public void setCapacidade(int c){
        this.capacidade = c;
    }
    
    public StackStrings clone(){
        return new StackStrings(this);
    }
    
    public String top(){
        String res = "";
        if(!this.stack.isEmpty())
            res = this.stack.get(0);
        return res;
    }
    
    public void push(String s){
        this.stack.add(0, s);
    }
    
    public void pop(){
        if(!this.stack.isEmpty()){
            this.stack.remove(0);
        }
    }
    
    public boolean empty(){
        return this.stack.isEmpty();
    }
    
    public int length(){
        return this.stack.size();
    }
}
