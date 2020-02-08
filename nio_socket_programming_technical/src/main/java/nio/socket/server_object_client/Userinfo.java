package nio.socket.server_object_client;

import java.io.Serializable;

public class Userinfo implements Serializable {

    private long id;
    private String username;
    private String password;

    public Userinfo() {
    }

    public Userinfo(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
