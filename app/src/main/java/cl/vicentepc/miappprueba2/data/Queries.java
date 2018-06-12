package cl.vicentepc.miappprueba2.data;

import java.util.ArrayList;
import java.util.List;

import cl.vicentepc.miappprueba2.models.Client;

public class Queries {

    public List<Client> clients () {

        List<Client> clients = new ArrayList<>();
        List<Client> clientList = Client.listAll(Client.class);
        /*if (clientList != null && clientList.size() > 0){
            clients.addAll(clientList);
        }*/

        return clientList;

    }

}
