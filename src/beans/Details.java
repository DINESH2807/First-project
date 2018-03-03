package beans;

import java.sql.Date;

public class Details {
	   private String Rollno;
	   private String Regno;
	   private String Name;
	   private Date   DOC;
	   private String Dept;
	   private String Topic;
	   private String Actions;
	   private float GPA;
	   private String Counsellors; 
	   
	   public Details(){
		   
	   }
	   
public Details(String Rollno, String Regno, String Name, String Dept, Date DOC, String Topic, String Actions, float GPA, String Counsellors) {
	
	
		this.Rollno = Rollno;
		this.Regno = Regno;
		this.Name = Name ;
		this.Dept = Dept ;
		this.DOC = DOC;
		this.Topic= Topic;
		this.Actions = Actions;
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


	public Date getDOC() {
	    return DOC;
	}
	
	public void setDOC(Date DOC) {
	    this.DOC = DOC;
	}
	public String getTopic() {
	    return Topic;
	}
	
	public void setTopic(String Topic) {
	    this.Topic = Topic;
	}
	
	public String getActions() {
	    return Actions;
	}
	
	public void setActions(String Actions) {
	    this.Actions = Actions;
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
