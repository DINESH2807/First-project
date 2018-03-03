package beans;
 
public class UserAccount {
    
   private String userName;
   private String password;
   private String gender;
   private String id;
 
   public UserAccount() {
        
   }
    
   public String getUserName() {
       return userName;
   }
 
   public void setUserName(String userName) {
       this.userName = userName;
   }

   public String getGender() {
       return gender;
   }
 
   public void setGender(String gender) {
       this.gender = gender;
   }
 
   
   public String getPassword() {
       return password;
   }
 
   public void setPassword(String password) {
       this.password = password;
   }
 
   public String getId() {
       return id;
   }
 
   public void setId(String id) {
       this.id = id;
   }
}