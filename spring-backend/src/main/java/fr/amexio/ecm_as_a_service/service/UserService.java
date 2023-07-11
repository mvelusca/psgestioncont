package fr.amexio.ecm_as_a_service.service;

import fr.amexio.ecm_as_a_service.model.Container;
import fr.amexio.ecm_as_a_service.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Audiger","Paul", "paudiger@amexio.fr"));
        users.add(new User(2,"Hamon","Léna","lhamon@amexio.fr"));
    }

    public List<User> findAll(){
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findById(int id){
        for (User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
    public User deleteById(int id){
        User user = findById(id);

        if(user == null){
            return null;
        }
        if(users.remove(user)){
            return user;
        }
        return null;
    }

    public User deleteUserContainerById(int userId, int containerId){
        User user = findById(userId);
        if(user == null){
            return null;
        }
        Container container = user.getContainer(containerId);
        if(container == null){
            return null;
        }
        if(user.getContainerList().remove(container)){
            return user;
        }
        return null;
    }

    public List<Container> userContainers(int userId){
        return findById(userId).getContainerList();
    }
    public Container findUserContainer(int containerId, int userId){
        return findById(userId).getContainer(containerId);
    }

    public void addUserContainer(int userId, int id, String name, String type, boolean valide){
        Container container = new Container(id, name, type, valide);
        findById(userId).addUserContainer(container);
    }
}
