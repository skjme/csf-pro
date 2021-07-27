package cn.chaseshu.thinking.in.spring.environment.domain;

import org.springframework.beans.factory.BeanNameAware;

import java.util.Objects;

public class User implements BeanNameAware {

    private Long id;
    private String name;
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && getName().equals(user.getName()) && getCity().equals(user.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCity());
    }

    @Override
    public void setBeanName(String name) {

    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
