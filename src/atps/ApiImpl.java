package atps;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// Implementação da Interface RMI
public class ApiImpl extends UnicastRemoteObject implements Api {
    private static final long serialVersionUID = 1L;
    private static int idSala=0, idJogador=0;
    ArrayList<Dados> dadosJogoList = new ArrayList();
            
    // Construtor
    public ApiImpl() throws RemoteException {
        super();
    }
    
    // Cria ID para o jogador conectado
    @Override
    public int criarIdJogador() throws RemoteException{
        // Retorna próximo ID
        return ++idJogador;
    }
     
    // Cria ID para a Sala (Novo Jogo)
    @Override
    public int criarSala(int idJog, String nome) throws RemoteException{
        int l_idSala = ApiImpl.idSala++;
        Dados l_dadosJogo = new Dados(l_idSala);
        
        // Cria objetos vazios responsáveis por gerenciar o novo jogo
        l_dadosJogo = new Dados(l_idSala);
        l_dadosJogo.jogo = new JogoVelha();
        
        // Seta dados do primeiro jogador (quem criou a Sala - ID e nome)
        l_dadosJogo.jogo.setIdJogadorUm(idJog);
        l_dadosJogo.jogo.setNomeJogadorUm(nome);
        l_dadosJogo.jogo.setVezJogador(idJog);
        // Atribui objeto ao Array
        dadosJogoList.add(l_dadosJogo);
        
        // Retorna ID da sala
        return l_idSala;
    }
    
    // Verifica se a última sala criada está disponível
    @Override
    public int entrarSala(int idJog, String nome) throws RemoteException{
        int l_idSala;
        Dados l_dadosJogo;
        
        // Nenhuma sala existente
        if(ApiImpl.idSala==0) {
            return -1;
        }
        
        // Recebe dados da última sala criada
        l_dadosJogo = dadosJogoList.get(ApiImpl.idSala-1);
        // Sala completa
        if(l_dadosJogo.getCompleto()) {
            return -1;
        }
        
        // Marca sala como completa
        l_dadosJogo.completo = true;
        l_idSala = ApiImpl.idSala-1;
        // Seta dados do segundo jogador (quem entrou na Sala - ID e nome)
        l_dadosJogo.jogo.setIdJogadorDois(idJog);
        l_dadosJogo.jogo.setNomeJogadorDois(nome);
        
        // Retorna ID da sala
        return l_idSala;
    }
    
    // Retorna dados do Jogo da Velha
    @Override
    public JogoVelha getJogo(int idJogo) throws RemoteException{
        Dados l_dadosJogo;
        
        // Recebe dados da Sala
        l_dadosJogo = dadosJogoList.get(idJogo);
        
        // Retorna dados do Jogo
        return l_dadosJogo.getJogo();
    }
    
    // Valida jogada solicitada e a efetua, caso seja possível
    @Override
    public boolean efetuarJogada(int idJogo, int idJogador, int idLin, int idCol, char valor) throws RemoteException{
        // Valida se jogada é possível, executando-a em caso positivo
        if(!dadosJogoList.get(idJogo).jogo.setCelula(idJogador, idLin, idCol, valor)) {
            return false;
        }
        return true;
    }
}