package edu.escuelaing.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Remote interface that defines the chat service methods
 */
public interface ChatService extends Remote {

    void sendMessage(String user, String message) throws RemoteException;

    List<String> getMessages() throws RemoteException;
}