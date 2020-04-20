package cn.chaseshu.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    /**
     * TODO 忽略该字段的映射
     */
    @Transient
    private String  email;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
