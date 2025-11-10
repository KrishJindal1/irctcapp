import javax.xml.transform.Source;
import java.util.HashMap;
import java.util.Map;
public class UserServices {

    private static Map<String,User> userMap = new HashMap<>();
    private User CurrentUser = null;
    public Boolean registerUser(String Username, String Password , String FullName , String contact){
        if(userMap.containsKey(Username)){
            System.out.println("Username already exists, plS Choose another");
            return false;
        }
        User user = new User(Username,Password,FullName,contact);
        userMap.put(Username,user);
        System.out.println("Registertion Successfull!");
        CurrentUser=user;
        System.out.println("Welcome : " + CurrentUser.getFullName() + "!");
        return true;
    }

    public boolean LoginUser(String Username,String Password) {
        if (!userMap.containsKey(Username)) {
            System.out.println("User Doesnt exists!");
            return false;
        }
        User user = userMap.get(Username);
        if (!user.getPassword().equals(Password)) {
            System.out.println("Incorrect Password");
            return false;
        }
        CurrentUser = user;
        System.out.println("Welcome : " + CurrentUser.getFullName() + "!");
        return true;
    }

    public void Logout() {
        if (CurrentUser != null) {
            System.out.println("Logged out" + CurrentUser.getFullName());
        }
        CurrentUser = null;

    }

    public User getCurrentUser(){
        return CurrentUser;
    }

    public boolean isloggedIn(){
        return CurrentUser!=null;
    }

    public boolean registeredUser() {
            return CurrentUser!=null;
    }
}
