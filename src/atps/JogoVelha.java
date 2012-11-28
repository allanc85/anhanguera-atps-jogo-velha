package atps;

import java.io.Serializable;

public class JogoVelha implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idJogadorUm, idJogadorDois; // Jogador 1 = X e Jogador 2 = O
    private String nomeJogadorUm, nomeJogadorDois;
    private char[][] tabuleiro;
    private int[] jogo;
    private int vezJogador;
    
    // Construtor
    public JogoVelha() {
        this.InicializaVariaveis();
    }
    
    // Construtor atribuindo os jogadores
    public JogoVelha(int jogador1, int jogador2) {
        this.InicializaVariaveis();
        this.setIdJogadorUm(jogador1);
        this.setIdJogadorDois(jogador2);
        this.setVezJogador(jogador1);
    }

    // Inicializa variáveis responsáveis pelo controle do jogo
    public void InicializaVariaveis() {
        tabuleiro = new char[3][3];
        jogo      = new int[3];    //idJogadorVencedor
        this.limpaIdJogador();
        this.limpaTabuleiro();
        this.limpaJogo();
    }

    // Inicialida ID dos jogadores
    private void limpaIdJogador() {
        this.setIdJogadorUm(0);
        this.setIdJogadorDois(0);
    }

    // Inicializa Tabuleiro
    private void limpaTabuleiro() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                this.tabuleiro[i][j] = ' ';
            }
        }
    }

    // Inicializa Jogo
    private void limpaJogo() {
        for(int i=0;i<3;i++) {
            this.jogo[i] = 0;
        }
    }

    // Seta ID do jogador 1
    public void setIdJogadorUm(int jogador) {
        this.idJogadorUm = jogador;
    }

    // Seta Nome do jogador 1
    public void setNomeJogadorUm(String nome) {
        this.nomeJogadorUm = nome;
    }
    
    // Seta ID do jogador 2
    public void setIdJogadorDois(int jogador) {
        this.idJogadorDois = jogador;
    }

    // Seta Nome do jogador 2
    public void setNomeJogadorDois(String nome) {
        this.nomeJogadorDois = nome;
    }

    // Seta jogador atual
    public void setVezJogador(int jogador) {
        this.vezJogador = jogador;
    }

    // Recebe ID do jogador 1
    public int getIdJogadorUm() {
        return this.idJogadorUm;
    }

    // Recebe ID do jogador 2
    public int getIdJogadorDois() {
        return this.idJogadorDois;
    }

    // Recebe nome do jogador 1
    public String getNomeJogadorUm() {
        return this.nomeJogadorUm;
    }

    // Recebe nome do jogador 2
    public String getNomeJogadorDois() {
        return this.nomeJogadorDois;
    }

    // Recebe valor de uma célula
    public char getCelula(int linha, int coluna) {
        return this.tabuleiro[linha-1][coluna-1];
    }

    // Recebe dados do tabuleiro
    public char[][] getTabuleiro() {
        return this.tabuleiro;
    }

    // Recebe jogador atual
    public int getVezJogador() {
        return this.vezJogador;
    }

    // Valida e realiza jogada
    public boolean setCelula(int jogador, int linha, int coluna, char valor) {
        // Valida vez do jogador
        if(this.vezJogador!=jogador) {
            return false;
        }
        // Valida se célula está vazia
        if(this.tabuleiro[linha-1][coluna-1]!=' ') {
            return false;
        }

        // Atribui jogada na célula
        this.tabuleiro[linha-1][coluna-1] = valor;        
        // Próximo jogador
        this.vezJogador = this.getVezJogador()==this.idJogadorUm?this.idJogadorDois:this.idJogadorUm;

        return true;
    }
}
