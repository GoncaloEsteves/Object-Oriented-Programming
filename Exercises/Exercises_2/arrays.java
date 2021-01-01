import java.lang.Math;

/**
 * Escreva a descrição da classe ex1 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class arrays
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int[] lista;

    public int minimo(int[] array){
        int m = array[0];
        for(int aux : array){
            m = Math.min(aux, m);
        }
        return m;
    }
    
    public int[] valoresCompreendidos(int[] array, int a, int b){
        int aux[] = new int[b-a+1];
        int j = 0;
        for(int i = a; i < b+1; i++){
            aux[j] = array[i];
            j++;
        }
        return aux;
    }
    
    public int[] valoresIguais(int[] array1, int[] array2){
        int i, j, k;
        int tam1 = array1.length;
        int tam2 = array2.length;
        int[] aux = new int[tam1];
        k = 0;
        for(i = 0; i < tam1; i++){
            for(j = 0; j < tam2; j++){
                if(array1[i] == array2[j]){
                    aux[k] = array1[i];
                    k++;
                }
            }
        }
        return aux;
    }
}
