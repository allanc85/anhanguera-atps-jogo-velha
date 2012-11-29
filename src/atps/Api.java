package atps;

import java.rmi.*;

// Interface RMI
public interface Api extends Remote {    
    // Cria ID para o jogador conectado
    public int criarIdJogador() throws RemoteException;
    // Cria ID para a Sala (Novo Jogo)
    public int criarSala(int idJog, String nome) throws RemoteException;
    // Verifica se a última sala criada está disponível
    public int entrarSala(int idJog, String nome) throws RemoteException;
    // Retorna dados do Jogo da Velha
    public JogoVelha getJogo(int idJogo) throws RemoteException;
    // Valida jogada solicitada e a efetua, caso seja possível
    public boolean efetuarJogada(int idJogo, int idJogador, int idLin, int idCol, char valor) throws RemoteException;
    //seta e retorna o status atual do jogo
    public int getStatusJogo(int idJogo) throws RemoteException;;
    
}