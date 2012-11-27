package atps;

import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    // Dados para criar conexão RMI - Servidor
    private static final int PORT = 1099;
    private static Registry registry;

    // Inicia registro do Servidor
    public static void startRegistry() throws RemoteException {
        registry = java.rmi.registry.LocateRegistry.createRegistry(PORT);
    }

    // Registra objeto do Servidor
    public static void registerObject(String name, Remote remoteObj)
        throws RemoteException, AlreadyBoundException {
        registry.bind(name, remoteObj);
        //System.out.println("Registered: " + name + " -> " + remoteObj.getClass().getName() + "[" + remoteObj + "]");
    }

    public static void main(String[] args) throws Exception {
        //System.setProperty("java.security.policy", "security.policy");
        startRegistry();
        registerObject(Api.class.getSimpleName(), new ApiImpl());
        System.out.println("Servidor iniciado com sucesos. Aguardando conexão.");
    }
}