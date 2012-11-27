package atps;

import java.rmi.*;

// Interface RMI
public interface Api extends Remote {    
    /*public Data incrementCounter(Data value) throws RemoteException;*/
    public int criarIdJogador() throws RemoteException;
    public int criarSala(int idJog, String nome) throws RemoteException;
    public int entrarSala(int idJog, String nome) throws RemoteException;

    //public void salaCompleta() throws RemoteException;
    public JogoVelha getJogo(int idJogo) throws RemoteException;
    public boolean efetuarJogada(int idJogo, int idJogador, int idLin, int idCol, char valor) throws RemoteException;
}