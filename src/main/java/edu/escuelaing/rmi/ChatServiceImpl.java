package edu.escuelaing.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the ChatService remote interface.
 * Stores messages and makes them available to all clients.
 */
public class ChatServiceImpl extends UnicastRemoteObject implements ChatService {

    private List<String> messages;

    public ChatServiceImpl() throws RemoteException {
        super();
        messages = new ArrayList<>();
    }

    @Override
    public void sendMessage(String user, String message) throws RemoteException {
        String formatted = "[" + user + "]: " + message;
        messages.add(formatted);
        System.out.println(formatted);
    }

    @Override
    public List<String> getMessages() throws RemoteException {
        return new ArrayList<>(messages);
    }
}