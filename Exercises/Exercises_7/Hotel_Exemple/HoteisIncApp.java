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

/**
 * Exemplo de aplicação com menu em modo texto.

 * 
 * @author José Creissac Campos
 * @version 1.0
 */

import java.io.*;
import java.util.Scanner;

public class HoteisIncApp {

    // A classe HoteisInc tem a 'lógica de negócio'.
    private HoteisInc logNegocio;
    
    // Menus da aplicação
    private Menu menuPrincipal, menuHoteis;
    
    /**
     * O método main cria a aplicação e invoca o método run()
     */
    public static void main(String[] args) {
        new HoteisIncApp().run();
    }
    
    /**
     * Construtor.
     * 
     * Cria os menus e a camada de negócio.
     */
    
    private HoteisIncApp() {
        // Criar o menu 
        String[] opcoes = {"Adicionar Hotel",
                           "Consultar Hotel"};
        String[] opcoesHoteis = {"Criar Hotel Standard",
                                 "Criar Hotel Discount",
                                 "Criar Hotel Premium"};
        this.menuPrincipal = new Menu(opcoes);        
        this.menuHoteis = new Menu(opcoesHoteis);
        // Criar a lógica de negócio
        try {
            this.logNegocio = HoteisInc.carregaEstado("estado.obj");
        }
        catch (FileNotFoundException e) {
            System.out.println("Parece que é a primeira utilização...");  
            this.logNegocio = new HoteisInc();
        }
        catch (IOException e) {
            System.out.println("Ops! Erro de leitura!");     
            this.logNegocio = new HoteisInc();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Ops! Formato de ficheiro de dados errado!");
            this.logNegocio = new HoteisInc();
        }
    }

    /**
     * Executa o menu principal e invoca o método correspondente à opção seleccionada.
     */
    private void run() {
        System.out.println(this.logNegocio.toString());
        do {
            menuPrincipal.executa();
            switch (menuPrincipal.getOpcao()) {
                case 1: System.out.println("Escolheu adicionar");
                        break;
                case 2: //trataConsultarHotel();
            }
        } while (menuPrincipal.getOpcao()!=0); // A opção 0 é usada para sair do menu.
        try {
            this.logNegocio.guardaEstado("estado.obj");
        }
        catch (IOException e) {
            System.out.println("Ops! Não consegui gravar os dados!");
        }
        System.out.println("Até breve!...");     
    }
    
    // Métodos auxiliares
    public void trataConsultarHotel() {
        Scanner scin = new Scanner(System.in);
        
        System.out.println("Código a consultar: ");
        String cod = scin.nextLine();
        try {
            System.out.println(this.logNegocio.getHotel(cod).toString());
        }
        catch (HotelInexistenteException e) {
            System.out.println(e.getMessage());
        }
    }
}


