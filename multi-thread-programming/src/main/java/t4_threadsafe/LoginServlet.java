package t4_threadsafe;

public class LoginServlet {

    private static String usernameRef;
    private static String passwordRef;

    synchronized public static void doPost(String ussername, String password) {
       try{
           usernameRef = ussername;
           if("a".equals(ussername)){
               Thread.sleep(5000);
           }
           passwordRef = password;
           System.out.println("username=" + usernameRef + " password=" + passwordRef);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
