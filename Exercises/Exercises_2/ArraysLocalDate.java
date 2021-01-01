import java.lang.Object;
import java.time.LocalDate;

/**
 * Escreva a descrição da classe ArraysLocalDate aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ArraysLocalDate
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private LocalDate[] datas;
    private int size;
    
    public ArraysLocalDate(){
        this.size = 0;
        this.datas[this.size] = LocalDate.now();
    }
    
    public ArraysLocalDate(ArraysLocalDate array){
        this.size = array.getSize();
        this.datas = array.getDatas();
    }
    
    public ArraysLocalDate(LocalDate[] dates, int tamanho){
        this.size = tamanho;
        this.datas = dates.clone();
    }
    
    public int getSize(){
        return this.size;
    }
    
    public LocalDate[] getDatas(){
        return this.datas.clone();
    }
    
    public void insereData(LocalDate data){
        this.datas[this.size] = data;
        (this.size)++;
    }       
}
