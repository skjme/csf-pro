package ch02.inner_class;

public class Run {

    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("u");
        publicClass.setPassword("p");
        System.out.println(publicClass.getUsername() + " " + publicClass.getPassword());

        PublicClass.PrivateClass privateClass = publicClass.new PrivateClass();
        privateClass.setAge("age");
        privateClass.setAddress("address");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
    }
}
