/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atps;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author allancristian
 */
public class JogoVelha implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idJogadorUm, idJogadorDois; // Jogador 1 = X e Jogador 2 = O
    private String nomeJogadorUm, nomeJogadorDois;
    private char[][] tabuleiro;
    private int[] jogo;
    private int vezJogador;
    
    public JogoVelha() {
        this.InicializaVariaveis();
    }
    
    public JogoVelha(int jogador1, int jogador2) {
        this.InicializaVariaveis();
        this.setIdJogadorUm(jogador1);
        this.setIdJogadorDois(jogador2);
        this.setVezJogador(jogador1);
    }
    
    public void InicializaVariaveis() {
        tabuleiro = new char[3][3];
        jogo      = new int[3];    //idJogadorVencedor
        this.limpaIdJogador();
        this.limpaTabuleiro();
        this.limpaJogo();
    }
    
    private void limpaIdJogador() {
        this.setIdJogadorUm(0);
        this.setIdJogadorDois(0);
    }
    
    private void limpaTabuleiro() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                this.tabuleiro[i][j] = ' ';
            }
        }
    }
    
    private void limpaJogo() {
        for(int i=0;i<3;i++) {
            this.jogo[i] = 0;
        }
    }
    
    public void setIdJogadorUm(int jogador) {
        this.idJogadorUm = jogador;
    }
    
    public int getIdJogadorUm() {
        return this.idJogadorUm;
    }
    
    public void setIdJogadorDois(int jogador) {
        this.idJogadorDois = jogador;
    }
    
    public int getIdJogadorDois() {
        return this.idJogadorDois;
    }
    
    public void setNomeJogadorUm(String nome) {
        this.nomeJogadorUm = nome;
    }
    
    public String getNomeJogadorUm() {
        return this.nomeJogadorUm;
    }
    
    public void setNomeJogadorDois(String nome) {
        this.nomeJogadorDois = nome;
    }
    
    public String getNomeJogadorDois() {
        return this.nomeJogadorDois;
    }
    
    public boolean setCelula(int jogador, int linha, int coluna, char valor) {
        if(this.vezJogador!=jogador) {
            return false;
        }
        if(this.tabuleiro[linha-1][coluna-1]!=' ') {
            return false;
        }
        this.tabuleiro[linha-1][coluna-1] = valor;
        
        this.vezJogador = this.getVezJogador()==this.idJogadorUm?this.idJogadorDois:this.idJogadorUm;
        return true;
    }

    public char getCelula(int linha, int coluna) {
        return this.tabuleiro[linha-1][coluna-1];
    }

    
    public char[][] getTabuleiro() {
        return this.tabuleiro;
    }
    
    public void setVezJogador(int jogador) {
        this.vezJogador = jogador;
    }
    
    public int getVezJogador() {
        return this.vezJogador;
    }
}
