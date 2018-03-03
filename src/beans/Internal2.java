package beans;

public class Internal2 {

	 private String Rollno;
	   private String Regno;
	   private String Name;
	   private String Dept;
	   private float s1;
	   private float s2;
	   private float s3;
	   private float s4;
	   private float s5;
	   private float s6;
	   private float GPA;
	   
	   public Internal2() {
	 
	   }
	 
	   public Internal2(String Rollno, String Regno, String Name, String Dept, float s1, float s2,  float s3, float s4, float s5, float s6, float GPA) {
	       this.Rollno = Rollno;
	       this.Regno = Regno;
	       this.Name = Name ;
	       this.Dept = Dept;
	       this.s1 = s1;
	       this.s2 = s2;
	       this.s3 = s3; 
	       this.s4 = s4;
	       this.s5 = s5;
	       this.s6 = s6;
	       this.GPA = GPA;
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
	 
	   public float gets1() {
	       return s1;
	   }
	 
	   public void sets1(float s1) {
	       this.s1 = s1;
	   }
	   
	   public float gets2() {
	       return s2;
	   }
	 
	   public void sets2(float s2) {
	       this.s2 = s2;
	   }
	 
	   public float gets3() {
	       return s3;
	   }
	 
	   public void sets3(float s3) {
	       this.s3 = s3;
	   }	
	   
	   public float gets4() {
	       return s4;
	   }
	 
	   public void sets4(float s4) {
	       this.s4 = s4;
	   }
	   
	   public float gets5() {
	       return s5;
	   }
	 
	   public void sets5(float s5) {
	       this.s5 = s5;
	   }
	   
	   public float gets6() {
	       return s6;
	   }
	 
	   public void sets6(float s6) {
	       this.s6 = s6;
	   }
	   
	   public float getGPA() {
	       return GPA;
	   }
	 
	   public void setGPA(float GPA) {
	       this.GPA = GPA;
	   }
	   
	   public String getDept() {
		   return Dept;
	   }
	public void setDept(String Dept) {
		this.Dept= Dept;
	}
	   
}
