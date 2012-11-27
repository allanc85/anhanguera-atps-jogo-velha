package atps;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// Implementação da Interface RMI
public class ApiImpl extends UnicastRemoteObject implements Api {
    private static final long serialVersionUID = 1L;
    private static int idSala=0, idJogador=0;
    ArrayList<Data> dadosJogoList = new ArrayList();
            
    public ApiImpl() throws RemoteException {
        super();
    }
    
    @Override
    public int criarIdJogador() throws RemoteException{
        return ++idJogador;
    }
     
    @Override
    public int criarSala(int idJog, String nome) throws RemoteException{
        int l_idSala = ApiImpl.idSala++;
        Data l_dadosJogo = new Data(l_idSala);
        
        l_dadosJogo = new Data(l_idSala);
        l_dadosJogo.jogo = new JogoVelha();
        l_dadosJogo.jogo.setIdJogadorUm(idJog);
        l_dadosJogo.jogo.setNomeJogadorUm(nome);
        l_dadosJogo.jogo.setVezJogador(idJog);
        
        dadosJogoList.add(l_dadosJogo);

        return l_idSala;
    }
    
    @Override
    public int entrarSala(int idJog, String nome) throws RemoteException{
        int l_idSala;
        Data l_dadosJogo;
        
        if(ApiImpl.idSala==0) {
            return -1;
        }
        
        l_dadosJogo = dadosJogoList.get(ApiImpl.idSala-1);
        
        if(l_dadosJogo.completo) {
            return -1;
        }
        l_dadosJogo.completo = true;
        l_idSala = ApiImpl.idSala-1;

        l_dadosJogo.jogo.setIdJogadorDois(idJog);
        l_dadosJogo.jogo.setNomeJogadorDois(nome);
        
        return l_idSala;
    }
        
    //@Override
    //public void salaCompleta() throws RemoteException{
    //}
    
    @Override
    public JogoVelha getJogo(int idJogo) throws RemoteException{
        Data l_dadosJogo;
        l_dadosJogo = dadosJogoList.get(idJogo);
        
        return l_dadosJogo.getJogo();
    }
    
    @Override
    public boolean efetuarJogada(int idJogo, int idJogador, int idLin, int idCol, char valor) throws RemoteException{
        if(!dadosJogoList.get(idJogo).jogo.setCelula(idJogador, idLin, idCol, valor)) {
            return false;
        }
        return true;
    }
    
}