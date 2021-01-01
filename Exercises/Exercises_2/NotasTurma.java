import java.lang.Math;
import java.lang.Object;
import java.util.Arrays;

/**
 * Escreva a descrição da classe ex2 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class NotasTurma{
    private int[][] notasTurma;
    
    public NotasTurma(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                this.notasTurma[i][j] = 0;
            }
        }
    }
    
    public NotasTurma(int uc, int[] notas){
        for(int i = 0; i < 5; i++)
            this.notasTurma[i][uc] = notas[i];
    }
    
    public NotasTurma(NotasTurma pauta){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++)
                this.notasTurma[i][j] = pauta.getNota(i, j);
        }
    }
    
    public int getNota(int aluno, int uc){
        return (this.notasTurma[aluno][uc]);
    }
    
    public void setNota(int aluno, int uc, int nota){
        this.notasTurma[aluno][uc] = nota;
    }
    
    public int somaNotasUC(int uc){
        int soma = 0;
        for(int i = 0; i < 5; i++)
            soma += this.notasTurma[i][uc];
        return soma;
    }
    
    public int mediaNotasAluno(int aluno){
        int media = 0;
        int soma = 0;
        for(int i = 0; i < 5; i++)
            soma += this.notasTurma[aluno][i];
        media = soma/5;
        return media;
    }
    
    public int notaMaisAlta(){
        int max = this.notasTurma[0][0];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++)
                max = Math.max(max, this.notasTurma[i][j]);
        }
        return max;   
    }
    
    public int notaMaisBaixa(){
        int min = this.notasTurma[0][0];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++)
                min = Math.min(min, this.notasTurma[i][j]);
        }
        return min;   
    }
    
    public int[] notasMaisAltasQue(int valor){
        int[] aux = new int[25];

        int k = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(this.notasTurma[i][j] > valor){
                    aux[k] = this.notasTurma[i][j];
                    k++;
                }
            }
        }
        int[] aux2 = new int[k-1];
        aux2 = Arrays.copyOfRange(aux, 0, k-1);
        return aux2;
    }
    
    public String toString(){
        String aux;
        String string = "";
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                aux = "Aluno: " + i + " - UC: " + j + " - Nota: " + this.notasTurma[i][j];
                string = string + aux;
            }
        }
        return string;
    }
    
    public int ucMediaMaior(){
        int indice = 0;
        int media = 0;
        int aux = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                aux += this.notasTurma[j][i];
            }
            if(aux > media){
                media = aux;
                indice = i;
            }
        }
        return indice;
    }
}
