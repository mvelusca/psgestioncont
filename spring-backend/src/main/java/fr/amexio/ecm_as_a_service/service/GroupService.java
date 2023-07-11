package fr.amexio.ecm_as_a_service.service;

import fr.amexio.ecm_as_a_service.model.Container;
import fr.amexio.ecm_as_a_service.model.Group;
import fr.amexio.ecm_as_a_service.model.Group;
import fr.amexio.ecm_as_a_service.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    private static List<Group> groups = new ArrayList<>();

    static {
        groups.add(new Group(1,"Nantes"));
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public List<Group> findAll(){
        return groups;
    }

    public Group findById(int id){
        for (Group group : groups){
            if(group.getId() == id){
                return group;
            }
        }
        return null;
    }
    public Group deleteById(int id){
        Group group = findById(id);

        if(group == null){
            return null;
        }
        if(groups.remove(group)){
            return group;
        }
        return null;
    }

    public void addMembership(int groupId, User user){
        findById(groupId).addMembership(user);
    }

    public Group removeMembership(int groupId, User user){
        Group group = findById(groupId);
        if(group == null){
            return null;
        }
        User deletedUser = group.getMember(user.getId());
        if(deletedUser == null){
            return null;
        }
        if(group.getMemberList().remove(deletedUser)){
            return group;
        }
        return null;
    }

    public void giveAllMemberContainer(int groupId, Container container){
        Group group = findById(groupId);
        for(User user : group.getMemberList()){
            user.addUserContainer(container);
        }
    }

}
