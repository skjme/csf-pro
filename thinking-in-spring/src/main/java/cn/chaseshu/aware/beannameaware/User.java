package cn.chaseshu.aware.beannameaware;

import org.springframework.beans.factory.BeanNameAware;

public class User implements BeanNameAware {

    private String id;
    private String name;
    private String address;

    @Override
    public void setBeanName(String beanName) {
        //ID保存BeanName的值
        id = beanName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
