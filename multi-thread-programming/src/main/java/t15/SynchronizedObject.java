package t15;

public class SynchronizedObject {
    private String username = "a";
    private String password = "aa";

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

    synchronized public void printString(String username, String password){
        try {
            this.username = username;
            Thread.sleep(10000);
            this.password = password;
            System.out.println(username + " " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
