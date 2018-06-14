package cl.vicentepc.miappprueba2.data;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.vicentepc.miappprueba2.models.User;

public class Queries {

    public List<User> users () {

        List<User> users = new ArrayList<>();
        List<User> userList = User.listAll(User.class);
        Log.e("LIST", userList.toString());

        return userList;

    }

    public User byId(long idUser){
        User user;
        user = User.findById(User.class, idUser);
        return user;
    }


}
