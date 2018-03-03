package beans;

public class Student {

	 private String Rollno;
	   private String Regno;
	   private String Name;
	   private String Dept;
	   private float GPA;
	   private String Counsellors; 
	   
	   public Student() {
	 
	   }
	 
	   public Student(String Rollno, String Regno, String Name, String Dept, float GPA, String Counsellors) {
	       this.Rollno = Rollno;
	       this.Regno = Regno;
	       this.Name = Name ;
	       this.Dept = Dept ;
	       this.GPA = GPA ;
	       this.Counsellors = Counsellors ;
	       
	       
	   }
	 
	   public String getRollno() {
	       return Rollno;
	   }
	 
	   public void setRollno(String Rollno) {
	       this.Rollno = Rollno;
	   }
	 
	   public String getRegno() {
	       return Regno;
	   }
	 
	   public void setRegno(String Regno) {
	       this.Regno = Regno;
	   }
	   
	   public String getName() {
	       return Name;
	   }
	 
	   public void setName(String Name) {
	       this.Name = Name;
	   }
	 
	   public String getDept() {
	       return Dept;
	   }
	 
	   public void setDept(String Dept) {
	       this.Dept = Dept;
	   }
	   
	   public float getGPA() {
	       return GPA;
	   }
	 
	   public void setGPA(float GPA) {
	       this.GPA = GPA;
	   }
	 
	   public String getCounsellors() {
	       return Counsellors;
	   }
	 
	   public void setCounsellors(String Counsellors) {
	       this.Counsellors = Counsellors;
	   }
	   
	
}
