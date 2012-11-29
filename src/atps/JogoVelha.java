package atps;

import java.io.Serializable;

public class JogoVelha implements Serializable {
	
    private static final long serialVersionUID = 1L;
    private int idJogadorUm, idJogadorDois; // Jogador 1 = X e Jogador 2 = O
    private String nomeJogadorUm, nomeJogadorDois;
    private char[][] tabuleiro;
    
    private int jogo; //jogo em andamento
    private int vezJogador;

    /**
     * armazena o status do jogo
     * -1 = empate 
     *  0 = jogo em andamento
     * >0 = idjogador vencendor
     */
    private int[] statusJogo;    
    
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
        this.tabuleiro 		= new char[3][3];
        this.statusJogo    	= new int[3];
        this.jogo 			= 0;
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
            this.statusJogo[i] = 0;
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
 
    /**
     * Recebe jogador atual
     * @return
     */
    public int getVezJogador() {
        return this.vezJogador;
    }
    
    /**
     * Verifica se o jogador é o vencedor
     * @param idJogador
     * @return
     */
    public boolean isVencedor(int idJogador){
    	int linha = 0;
    	
    	//define o marcador
    	char marcador = idJogador == this.idJogadorUm ? 'X' : 'O';
    	
    	//percorre as  horizontais
    	for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(this.tabuleiro[i][j] == marcador)
                	linha++;
            }
            
            if(linha==3)
            	return true;
            else
            	linha = 0;           
        }
    	
    	//percorre as verticais
    	for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(this.tabuleiro[j][i] == marcador)
                	linha++;
            }
            
            if(linha==3)
            	return true;
            else
            	linha = 0;           
        }
    	
    	//percorre a diagonal esquerda
    	for(int i=0;i<3;i++) {
    		if(this.tabuleiro[i][i] == marcador)
            	linha++;
    	}
    	
    	if(linha==3)
        	return true;
        else
        	linha = 0;
    	
    	//percorre a diagonal direita
    	for(int i=0;i<3;i++) {
    		if(this.tabuleiro[3-i][i] == marcador)
            	linha++;
    	}
    	
    	if(linha==3)
        	return true;
    	
    	return false;    	    	
    }       
    
    /**
     * Verifica se o jogo terminou
     * @return boolean
     */
    public boolean isFimJogo(){
    	for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(this.tabuleiro[i][j] == ' ')
                	return false;
            }                      
        }
    	
    	return true;
    }
    
    /**
     * Define o Status do Jogo atual
     * -1 = Empate 
     *  0 = Jogo em andamento
     * >0 = idjogador vencendor
     * @return
     */
    public void setStatusJogo(){
    	if(this.isVencedor(this.idJogadorUm))
    		this.statusJogo[this.jogo] =  this.idJogadorUm;
    	else if(this.isVencedor(this.idJogadorDois))
    		this.statusJogo[this.jogo] = this.idJogadorDois;
    	else if(isFimJogo())
    		this.statusJogo[this.jogo] = -1;
    	else
    		this.statusJogo[this.jogo] = 0;    	    	
    }
    
    /**
     * Retorna o status do jogo
     * @return
     */
    public int getStatusJogo(){
    	this.setStatusJogo();
    	return this.statusJogo[this.jogo];
    }
    
    /**
     * Valida e realiza jogada
     * @param jogador
     * @param linha
     * @param coluna
     * @param valor
     * @return bool
     */
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
        this.vezJogador = this.getVezJogador()==this.idJogadorUm
        				? this.idJogadorDois
        				: this.idJogadorUm;

        return true;
    }
}
