package fr.amexio.ecm_as_a_service.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int id;
    private String name;
    private List<User> memberList;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        this.memberList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<User> memberList) {
        this.memberList = memberList;
    }

    public User getMember(int id){
        for(User member : memberList){
            if(member.getId() == id ){
                return member;
            }
        }
        return null;
    }
    public void addMembership(User user){
        this.memberList.add(user);
    }

}
