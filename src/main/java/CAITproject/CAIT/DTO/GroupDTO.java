package CAITproject.CAIT.DTO;

import CAITproject.CAIT.model.Group;

public class GroupDTO {

    private int id;
    private String name;
    private String user_username;

    public GroupDTO() {
    }

    public GroupDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public GroupDTO(Group group) {
        this.id = group.getId();
        this.name = group.getName();
    }

    public GroupDTO(String name, String user_username) {
        this.name = name;
        this.user_username = user_username;
    }

    public GroupDTO(int id, String user_username, String name) {
        this.id = id;
        this.user_username = user_username;
        this.name = name;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
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

    @Override
    public String toString() {
        return "GroupDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
