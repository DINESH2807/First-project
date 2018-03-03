package utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import beans.UserAccount;
import beans.Student;
import beans.Cycle1;
import beans.Cycle2;
import beans.Details;
import beans.Internal1;
import beans.Internal2;
import beans.Model;
import beans.Remodel;
import beans.Revision;
import beans.Retest1;
import beans.Retest2;

 
public class DBUtils {
 
  public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
 
      String sql = "Select a.User_Name, a.Password, a.Gender, a.Id from User_Account a "
              + " where a.User_Name = ? and a.password= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
      pstm.setString(2, password);
      ResultSet rs = pstm.executeQuery();
 
      if (rs.next()) {
    	  String gender = rs.getString("Gender");
          String id = rs.getString("Id");
          UserAccount user = new UserAccount();
          user.setUserName(userName);
          user.setPassword(password);
          user.setGender(gender);
          user.setId(id);
          return user;
      }
      return null;
  }
 
  public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
      String sql = "Select a.User_Name, a.Password, a.Gender, a.Id from User_Account a " + " where a.User_Name = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
 
      ResultSet rs = pstm.executeQuery();
 
      if (rs.next()) {
          String password = rs.getString("Password");
          String gender = rs.getString("Gender");
          String id = rs.getString("Id");
          UserAccount user = new UserAccount();
          user.setUserName(userName);
          user.setPassword(password);
          user.setGender(gender);
          user.setId(id);
          
          return user;
      }
      return null;
  }
 
  public static List<Student> queryStudent(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.Counsellors from Studentinfo a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Student> list = new ArrayList<Student>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          String Counsellors = rs.getString("Counsellors");
          Student student = new Student();
          student.setRollno(Rollno);
          student.setRegno(Regno);
          student.setName(Name);
          student.setDept(Dept);
          student.setGPA( GPA );
          student.setCounsellors(Counsellors);
          list.add(student);
      }
      return list;
  }
 
  public static Student findStudent(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.Counsellors from Studentinfo a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
      
    
      ResultSet rs = pstm.executeQuery();
      
     while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          String Counsellors = rs.getString("Counsellors");
          Student student = new Student(Rollno, Regno, Name, Dept, GPA, Counsellors);
         return student;
     }
      return null;
  }
 
  public static void updateStudent(Connection conn, Student student) throws SQLException {
      String sql = "Update Studentinfo set Regno =?, Name =?, Dept=?, GPA=?, Counsellors=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, student.getRegno());
      pstm.setString(2, student.getName());
      pstm.setString(3, student.getDept());
      pstm.setFloat(4, student.getGPA());
      pstm.setString(5, student.getCounsellors());
      pstm.setString(6, student.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertStudent(Connection conn, Student student) throws SQLException {
      String sql = "Insert into Studentinfo(Rollno, Regno, Name, Dept, GPA, Counsellors) values (?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, student.getRollno());
      pstm.setString(2, student.getRegno());
      pstm.setString(3, student.getName());
      pstm.setString(4, student.getDept());
      pstm.setFloat(5, student.getGPA());
      pstm.setString(6, student.getCounsellors());
 
      pstm.executeUpdate();
  }
 
  public static void deleteStudent(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Studentinfo where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchStudent(Connection conn, Student student) throws SQLException {
      String sql = "Select ? from studentinfo ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, student.getRollno());
  }
  
  public static List<Cycle1> queryCycle1(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6, a.GPA from Cycle1 a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Cycle1> list = new ArrayList<Cycle1>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");
          
          Cycle1 cycle1 = new Cycle1();
          cycle1.setRollno(Rollno);
          cycle1.setRegno(Regno);
          cycle1.setName(Name);
          cycle1.setDept(Dept);
          cycle1.setGPA( GPA );
          cycle1.sets1(s1);
          cycle1.sets2(s2);
          cycle1.sets3(s3);
          cycle1.sets4(s4);
          cycle1.sets5(s5);
          cycle1.sets6(s6);
          list.add(cycle1);
      }
      return list;
  }
 
  public static Cycle1 findCycle1(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6  from Cycle1 a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");

          Cycle1 cycle1 = new Cycle1(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6);
          return cycle1;
      }
      return null;
  }
  
  public static Cycle1 findDept1(Connection conn, String Dept) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6  from Cycle1 a where a.Dept=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Dept);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
    	  String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");

          Cycle1 cycle1 = new Cycle1(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6);
          return cycle1;
      }
      return null;
  }
 
  public static void updateCycle1(Connection conn, Cycle1 cycle1) throws SQLException {
      String sql = "Update Cycle1 set Regno =?, Name =?, Dept=?, GPA=?, s1=?, s2=?, s3=?, s4=?, s5=?, s6=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, cycle1.getRegno());
      pstm.setString(2, cycle1.getName());
      pstm.setString(3, cycle1.getDept());
      pstm.setFloat(4, cycle1.getGPA());
      pstm.setFloat(5, cycle1.gets1());
      pstm.setFloat(6, cycle1.gets2());
      pstm.setFloat(7, cycle1.gets3());
      pstm.setFloat(8, cycle1.gets4());
      pstm.setFloat(9, cycle1.gets5());
      pstm.setFloat(10, cycle1.gets6());
     
      pstm.setString(11, cycle1.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertCycle1(Connection conn, Cycle1 cycle1) throws SQLException {
      String sql = "Insert into Studentinfo(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6) values (?,?,?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, cycle1.getRollno());
      pstm.setString(2, cycle1.getRegno());
      pstm.setString(3, cycle1.getName());
      pstm.setString(4, cycle1.getDept());
      pstm.setFloat(5, cycle1.getGPA());
      pstm.setFloat(6, cycle1.gets1());
      pstm.setFloat(7, cycle1.gets2());
      pstm.setFloat(8, cycle1.gets3());
      pstm.setFloat(9, cycle1.gets4());
      pstm.setFloat(10, cycle1.gets5());
      pstm.setFloat(11, cycle1.gets6());

 
      pstm.executeUpdate();
  }
 
  public static void deleteCycle1(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Cycle1 where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchCycle1(Connection conn, Cycle1 cycle1) throws SQLException {
      String sql = "Select ? from Cycle1 ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, cycle1.getRollno());
  }
 
  public static List<Cycle2> queryCycle2(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6, a.GPA from Cycle2 a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Cycle2> list = new ArrayList<Cycle2>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");
          
          Cycle2 cycle2 = new Cycle2();
          cycle2.setRollno(Rollno);
          cycle2.setRegno(Regno);
          cycle2.setName(Name);
          cycle2.setDept(Dept);
          cycle2.setGPA( GPA );
          cycle2.sets1(s1);
          cycle2.sets2(s2);
          cycle2.sets3(s3);
          cycle2.sets4(s4);
          cycle2.sets5(s5);
          cycle2.sets6(s6);
          list.add(cycle2);
      }
      return list;
  }
 
  public static Cycle2 findCycle2(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6  from Cycle2 a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");

          Cycle2 cycle2 = new Cycle2(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6);
          return cycle2;
      }
      return null;
  }
 
  public static Cycle2 findDept2(Connection conn, String Dept) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6  from Cycle2 a where a.Dept=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Dept);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
    	  String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");

          Cycle2 cycle2 = new Cycle2(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6);
          return cycle2;
      }
      return null;
  }
  
  public static void updateCycle2(Connection conn, Cycle2 cycle2) throws SQLException {
      String sql = "Update Cycle2 set Regno =?, Name =?, Dept=?, GPA=?, s1=?, s2=?, s3=?, s4=?, s5=?, s6=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, cycle2.getRegno());
      pstm.setString(2, cycle2.getName());
      pstm.setString(3, cycle2.getDept());
      pstm.setFloat(4, cycle2.getGPA());
      pstm.setFloat(5, cycle2.gets1());
      pstm.setFloat(6, cycle2.gets2());
      pstm.setFloat(7, cycle2.gets3());
      pstm.setFloat(8, cycle2.gets4());
      pstm.setFloat(9, cycle2.gets5());
      pstm.setFloat(10, cycle2.gets6());
     
      pstm.setString(11, cycle2.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertCycle2(Connection conn, Cycle2 cycle2) throws SQLException {
      String sql = "Insert into Cycle2(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6) values (?,?,?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, cycle2.getRollno());
      pstm.setString(2, cycle2.getRegno());
      pstm.setString(3, cycle2.getName());
      pstm.setString(4, cycle2.getDept());
      pstm.setFloat(5, cycle2.getGPA());
      pstm.setFloat(6, cycle2.gets1());
      pstm.setFloat(7, cycle2.gets2());
      pstm.setFloat(8, cycle2.gets3());
      pstm.setFloat(9, cycle2.gets4());
      pstm.setFloat(10, cycle2.gets5());
      pstm.setFloat(11, cycle2.gets6());

 
      pstm.executeUpdate();
  }
 
  public static void deleteCycle2(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Cycle2 where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchCycle2(Connection conn, Cycle2 cycle2) throws SQLException {
      String sql = "Select ? from Cycle2 ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, cycle2.getRollno());
  }
  
  public static List<Internal1> queryInternal1(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6, a.GPA from Internal1 a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Internal1> list = new ArrayList<Internal1>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");
          
          Internal1 internal1 = new Internal1();
          internal1.setRollno(Rollno);
          internal1.setRegno(Regno);
          internal1.setName(Name);
          internal1.setDept(Dept);
          internal1.setGPA( GPA );
          internal1.sets1(s1);
          internal1.sets2(s2);
          internal1.sets3(s3);
          internal1.sets4(s4);
          internal1.sets5(s5);
          internal1.sets6(s6);
          list.add(internal1);
      }
      return list;
  }
 
  public static Internal1 findInternal1(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6  from Internal1 a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");

          Internal1 internal1 = new Internal1(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6);
          return internal1;
      }
      return null;
  }
 
  public static void updateInternal1(Connection conn, Internal1 internal1) throws SQLException {
      String sql = "Update Internal1 set Regno =?, Name =?, Dept=?, GPA=?, s1=?, s2=?, s3=?, s4=?, s5=?, s6=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, internal1.getRegno());
      pstm.setString(2, internal1.getName());
      pstm.setString(3, internal1.getDept());
      pstm.setFloat(4, internal1.getGPA());
      pstm.setFloat(5, internal1.gets1());
      pstm.setFloat(6, internal1.gets2());
      pstm.setFloat(7, internal1.gets3());
      pstm.setFloat(8, internal1.gets4());
      pstm.setFloat(9, internal1.gets5());
      pstm.setFloat(10, internal1.gets6());
     
      pstm.setString(11, internal1.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertInternal1(Connection conn, Internal1 internal1) throws SQLException {
      String sql = "Insert into Internal1(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6) values (?,?,?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, internal1.getRollno());
      pstm.setString(2, internal1.getRegno());
      pstm.setString(3, internal1.getName());
      pstm.setString(4, internal1.getDept());
      pstm.setFloat(5, internal1.getGPA());
      pstm.setFloat(6, internal1.gets1());
      pstm.setFloat(7, internal1.gets2());
      pstm.setFloat(8, internal1.gets3());
      pstm.setFloat(9, internal1.gets4());
      pstm.setFloat(10, internal1.gets5());
      pstm.setFloat(11, internal1.gets6());

 
      pstm.executeUpdate();
  }
 
  public static void deleteInternal1(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Internal1 where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchInternal1(Connection conn, Internal1 internal1) throws SQLException {
      String sql = "Select ? from Internal1 ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, internal1.getRollno());
  }
 
  public static List<Internal2> queryInternal2(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6, a.GPA from Internal2 a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Internal2> list = new ArrayList<Internal2>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");
          
          Internal2 internal2 = new Internal2();
          internal2.setRollno(Rollno);
          internal2.setRegno(Regno);
          internal2.setName(Name);
          internal2.setDept(Dept);
          internal2.setGPA( GPA );
          internal2.sets1(s1);
          internal2.sets2(s2);
          internal2.sets3(s3);
          internal2.sets4(s4);
          internal2.sets5(s5);
          internal2.sets6(s6);
          list.add(internal2);
      }
      return list;
  }
 
  public static Internal2 findInternal2(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6  from Internal2 a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");

          Internal2 internal2 = new Internal2(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6);
          return internal2;
      }
      return null;
  }
 
  public static void updateInternal2(Connection conn, Internal2 internal2) throws SQLException {
      String sql = "Update Internal2 set Regno =?, Name =?, Dept=?, GPA=?, s1=?, s2=?, s3=?, s4=?, s5=?, s6=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, internal2.getRegno());
      pstm.setString(2, internal2.getName());
      pstm.setString(3, internal2.getDept());
      pstm.setFloat(4, internal2.getGPA());
      pstm.setFloat(5, internal2.gets1());
      pstm.setFloat(6, internal2.gets2());
      pstm.setFloat(7, internal2.gets3());
      pstm.setFloat(8, internal2.gets4());
      pstm.setFloat(9, internal2.gets5());
      pstm.setFloat(10, internal2.gets6());
     
      pstm.setString(11, internal2.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertInternal2(Connection conn, Internal2 internal2) throws SQLException {
      String sql = "Insert into Internal2(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6) values (?,?,?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, internal2.getRollno());
      pstm.setString(2, internal2.getRegno());
      pstm.setString(3, internal2.getName());
      pstm.setString(4, internal2.getDept());
      pstm.setFloat(5, internal2.getGPA());
      pstm.setFloat(6, internal2.gets1());
      pstm.setFloat(7, internal2.gets2());
      pstm.setFloat(8, internal2.gets3());
      pstm.setFloat(9, internal2.gets4());
      pstm.setFloat(10, internal2.gets5());
      pstm.setFloat(11, internal2.gets6());

 
      pstm.executeUpdate();
  }
 
  public static void deleteInternal2(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Internal2 where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchInternal2(Connection conn, Internal2 internal2) throws SQLException {
      String sql = "Select ? from Internal2 ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, internal2.getRollno());
  }
 
  public static List<Model> queryModel(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6, a.GPA from Model a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Model> list = new ArrayList<Model>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");
          
          Model model = new Model();
          model.setRollno(Rollno);
          model.setRegno(Regno);
          model.setName(Name);
          model.setDept(Dept);
          model.setGPA( GPA );
          model.sets1(s1);
          model.sets2(s2);
          model.sets3(s3);
          model.sets4(s4);
          model.sets5(s5);
          model.sets6(s6);
          list.add(model);
      }
      return list;
  }
 
  public static Model findModel(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6  from Model a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");

          Model model = new Model(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6);
          return model;
      }
      return null;
  }
 
  public static void updateModel(Connection conn, Model model) throws SQLException {
      String sql = "Update Model set Regno =?, Name =?, Dept=?, GPA=?, s1=?, s2=?, s3=?, s4=?, s5=?, s6=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, model.getRegno());
      pstm.setString(2, model.getName());
      pstm.setString(3, model.getDept());
      pstm.setFloat(4, model.getGPA());
      pstm.setFloat(5, model.gets1());
      pstm.setFloat(6, model.gets2());
      pstm.setFloat(7, model.gets3());
      pstm.setFloat(8, model.gets4());
      pstm.setFloat(9, model.gets5());
      pstm.setFloat(10, model.gets6());
     
      pstm.setString(11, model.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertModel(Connection conn, Model model) throws SQLException {
      String sql = "Insert into Model(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6) values (?,?,?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, model.getRollno());
      pstm.setString(2, model.getRegno());
      pstm.setString(3, model.getName());
      pstm.setString(4, model.getDept());
      pstm.setFloat(5, model.getGPA());
      pstm.setFloat(6, model.gets1());
      pstm.setFloat(7, model.gets2());
      pstm.setFloat(8, model.gets3());
      pstm.setFloat(9, model.gets4());
      pstm.setFloat(10, model.gets5());
      pstm.setFloat(11, model.gets6());

 
      pstm.executeUpdate();
  }
 
  public static void deleteModel(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Model where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchModel(Connection conn, Model model) throws SQLException {
      String sql = "Select ? from Model ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, model.getRollno());
  }
  
  public static List<Remodel> queryRemodel(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6, a.GPA from Remodel a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Remodel> list = new ArrayList<Remodel>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");
          
          Remodel remodel = new Remodel();
          remodel.setRollno(Rollno);
          remodel.setRegno(Regno);
          remodel.setName(Name);
          remodel.setDept(Dept);
          remodel.setGPA( GPA );
          remodel.sets1(s1);
          remodel.sets2(s2);
          remodel.sets3(s3);
          remodel.sets4(s4);
          remodel.sets5(s5);
          remodel.sets6(s6);
          list.add(remodel);
      }
      return list;
  }
 
  public static Remodel findRemodel(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6  from Remodel a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");

         Remodel remodel = new Remodel(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6);
          return remodel;
      }
      return null;
  }
 
  public static void updateRemodel(Connection conn, Remodel remodel) throws SQLException {
      String sql = "Update Remodel set Regno =?, Name =?, Dept=?, GPA=?, s1=?, s2=?, s3=?, s4=?, s5=?, s6=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, remodel.getRegno());
      pstm.setString(2, remodel.getName());
      pstm.setString(3, remodel.getDept());
      pstm.setFloat(4, remodel.getGPA());
      pstm.setFloat(5, remodel.gets1());
      pstm.setFloat(6, remodel.gets2());
      pstm.setFloat(7, remodel.gets3());
      pstm.setFloat(8, remodel.gets4());
      pstm.setFloat(9, remodel.gets5());
      pstm.setFloat(10, remodel.gets6());
     
      pstm.setString(11, remodel.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertRemodel(Connection conn, Remodel remodel) throws SQLException {
      String sql = "Insert into Remodel(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6) values (?,?,?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, remodel.getRollno());
      pstm.setString(2, remodel.getRegno());
      pstm.setString(3, remodel.getName());
      pstm.setString(4, remodel.getDept());
      pstm.setFloat(5, remodel.getGPA());
      pstm.setFloat(6, remodel.gets1());
      pstm.setFloat(7, remodel.gets2());
      pstm.setFloat(8, remodel.gets3());
      pstm.setFloat(9, remodel.gets4());
      pstm.setFloat(10, remodel.gets5());
      pstm.setFloat(11, remodel.gets6());

 
      pstm.executeUpdate();
  }
 
  public static void deleteRemodel(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Remodel where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchReModel(Connection conn, Remodel remodel) throws SQLException {
      String sql = "Select ? from Remodel ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, remodel.getRollno());
  }
  
  public static List<Revision> queryRevision(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6, a.GPA from Revision a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Revision> list = new ArrayList<Revision>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");
          
          Revision revision = new Revision();
          revision.setRollno(Rollno);
          revision.setRegno(Regno);
          revision.setName(Name);
          revision.setDept(Dept);
          revision.setGPA( GPA );
          revision.sets1(s1);
          revision.sets2(s2);
          revision.sets3(s3);
          revision.sets4(s4);
          revision.sets5(s5);
          revision.sets6(s6);
          list.add(revision);
      }
      return list;
  }
 
  public static Revision findRevision(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6  from Revision a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");

         Revision revision = new Revision(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6);
          return revision;
      }
      return null;
  }
 
  public static void updateRevision(Connection conn, Revision revision) throws SQLException {
      String sql = "Update Revision set Regno =?, Name =?, Dept=?, GPA=?, s1=?, s2=?, s3=?, s4=?, s5=?, s6=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, revision.getRegno());
      pstm.setString(2, revision.getName());
      pstm.setString(3, revision.getDept());
      pstm.setFloat(4, revision.getGPA());
      pstm.setFloat(5, revision.gets1());
      pstm.setFloat(6, revision.gets2());
      pstm.setFloat(7, revision.gets3());
      pstm.setFloat(8, revision.gets4());
      pstm.setFloat(9, revision.gets5());
      pstm.setFloat(10, revision.gets6());
     
      pstm.setString(11, revision.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertRevision(Connection conn, Revision revision) throws SQLException {
      String sql = "Insert into Revision(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6) values (?,?,?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, revision.getRollno());
      pstm.setString(2, revision.getRegno());
      pstm.setString(3, revision.getName());
      pstm.setString(4, revision.getDept());
      pstm.setFloat(5, revision.getGPA());
      pstm.setFloat(6, revision.gets1());
      pstm.setFloat(7, revision.gets2());
      pstm.setFloat(8, revision.gets3());
      pstm.setFloat(9, revision.gets4());
      pstm.setFloat(10, revision.gets5());
      pstm.setFloat(11, revision.gets6());

 
      pstm.executeUpdate();
  }
 
  public static void deleteRevision(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Revision where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchRevision(Connection conn, Revision revision) throws SQLException {
      String sql = "Select ? from Revision ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, revision.getRollno());
  }
 
  public static List<Retest1> queryRetest1(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6, a.GPA from Retest1 a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Retest1> list = new ArrayList<Retest1>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");
          
          Retest1 retest1 = new Retest1();
          retest1.setRollno(Rollno);
          retest1.setRegno(Regno);
          retest1.setName(Name);
          retest1.setDept(Dept);
          retest1.setGPA( GPA );
          retest1.sets1(s1);
          retest1.sets2(s2);
          retest1.sets3(s3);
          retest1.sets4(s4);
          retest1.sets5(s5);
          retest1.sets6(s6);
          list.add(retest1);
      }
      return list;
  }
 
  public static Retest1 findRetest1(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6  from Retest1 a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");

          Retest1 retest1 = new Retest1(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6);
          return retest1;
      }
      return null;
  }
 
  public static void updateRetest1(Connection conn, Retest1 retest1) throws SQLException {
      String sql = "Update Retest1 set Regno =?, Name =?, Dept=?, GPA=?, s1=?, s2=?, s3=?, s4=?, s5=?, s6=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, retest1.getRegno());
      pstm.setString(2, retest1.getName());
      pstm.setString(3, retest1.getDept());
      pstm.setFloat(4, retest1.getGPA());
      pstm.setFloat(5, retest1.gets1());
      pstm.setFloat(6, retest1.gets2());
      pstm.setFloat(7, retest1.gets3());
      pstm.setFloat(8, retest1.gets4());
      pstm.setFloat(9, retest1.gets5());
      pstm.setFloat(10, retest1.gets6());
     
      pstm.setString(11, retest1.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertRetest1(Connection conn, Retest1 retest1) throws SQLException {
      String sql = "Insert into Retest1(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6) values (?,?,?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, retest1.getRollno());
      pstm.setString(2, retest1.getRegno());
      pstm.setString(3, retest1.getName());
      pstm.setString(4, retest1.getDept());
      pstm.setFloat(5, retest1.getGPA());
      pstm.setFloat(6, retest1.gets1());
      pstm.setFloat(7, retest1.gets2());
      pstm.setFloat(8, retest1.gets3());
      pstm.setFloat(9, retest1.gets4());
      pstm.setFloat(10, retest1.gets5());
      pstm.setFloat(11, retest1.gets6());

 
      pstm.executeUpdate();
  }
 
  public static void deleteRetest1(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Retest1 where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchRetest1(Connection conn, Retest1 retest1) throws SQLException {
      String sql = "Select ? from Retest1 ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, retest1.getRollno());
  }
  
  public static List<Retest2> queryRetest2(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6, a.GPA from Retest2 a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Retest2> list = new ArrayList<Retest2>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");
          
          Retest2 retest2 = new Retest2();
          retest2.setRollno(Rollno);
          retest2.setRegno(Regno);
          retest2.setName(Name);
          retest2.setDept(Dept);
          retest2.setGPA( GPA );
          retest2.sets1(s1);
          retest2.sets2(s2);
          retest2.sets3(s3);
          retest2.sets4(s4);
          retest2.sets5(s5);
          retest2.sets6(s6);
          list.add(retest2);
      }
      return list;
  }
 
  public static Retest2 findRetest2(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.GPA, a.s1, a.s2, a.s3, a.s4, a.s5, a.s6  from Retest2 a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          float s1 = rs.getFloat("s1");
          float s2 = rs.getFloat("s2");
          float s3 = rs.getFloat("s3");
          float s4 = rs.getFloat("s4");
          float s5 = rs.getFloat("s5");
          float s6 = rs.getFloat("s6");

          Retest2 retest2 = new Retest2(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6);
          return retest2;
      }
      return null;
  }
 
  public static void updateRetest2(Connection conn, Retest1 retest2) throws SQLException {
      String sql = "Update Retest2 set Regno =?, Name =?, Dept=?, GPA=?, s1=?, s2=?, s3=?, s4=?, s5=?, s6=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, retest2.getRegno());
      pstm.setString(2, retest2.getName());
      pstm.setString(3, retest2.getDept());
      pstm.setFloat(4, retest2.getGPA());
      pstm.setFloat(5, retest2.gets1());
      pstm.setFloat(6, retest2.gets2());
      pstm.setFloat(7, retest2.gets3());
      pstm.setFloat(8, retest2.gets4());
      pstm.setFloat(9, retest2.gets5());
      pstm.setFloat(10, retest2.gets6());
     
      pstm.setString(11, retest2.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertRetest2(Connection conn, Retest2 retest2) throws SQLException {
      String sql = "Insert into Retest2(Rollno, Regno, Name, Dept, GPA, s1, s2, s3, s4, s5, s6) values (?,?,?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, retest2.getRollno());
      pstm.setString(2, retest2.getRegno());
      pstm.setString(3, retest2.getName());
      pstm.setString(4, retest2.getDept());
      pstm.setFloat(5, retest2.getGPA());
      pstm.setFloat(6, retest2.gets1());
      pstm.setFloat(7, retest2.gets2());
      pstm.setFloat(8, retest2.gets3());
      pstm.setFloat(9, retest2.gets4());
      pstm.setFloat(10, retest2.gets5());
      pstm.setFloat(11, retest2.gets6());

 
      pstm.executeUpdate();
  }
 
  public static void deleteRetest2(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Retest2 where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchRetest2(Connection conn, Retest2 retest2) throws SQLException {
      String sql = "Select ? from Retest2 ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, retest2.getRollno());
  }
  
  public static List<Details> queryDetails(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.DOC, a.Actions, a.Topic, a.GPA, a.Counsellors from Details a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Details> list = new ArrayList<Details>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          Date DOC = rs.getDate("DOC");
          String Topic = rs.getString("Topic");
          String Actions = rs.getString("Actions");
          String Counsellors = rs.getString("Counsellors");
          Details details = new Details();
          details.setRollno(Rollno);
          details.setRegno(Regno);
          details.setName(Name);
          details.setDept(Dept);
          details.setGPA( GPA );
          details.setCounsellors(Counsellors);
          details.setActions(Actions);
          details.setDOC(DOC);
          details.setTopic(Topic);
          list.add(details);
      }
      return list;
  }
 
  public static Details findDetails(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.DOC, a.Actions, a.Topic, a.GPA, a.Counsellors from Details a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          Date DOC = rs.getDate("DOC");
          String Topic = rs.getString("Topic");
          String Actions = rs.getString("Actions");
          String Counsellors = rs.getString("Counsellors");
          Details details = new Details(Rollno, Regno, Name, Dept, DOC, Topic, Actions, GPA, Counsellors);
          return details;
      }
      return null;
  }
 
  public static void updateDetails(Connection conn, Details details) throws SQLException {
      String sql = "Update Details set Regno =?, Name =?, Dept=?, GPA=?, DOC=?, Topic=?, Actions=?, Counsellors=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, details.getRegno());
      pstm.setString(2, details.getName());
      pstm.setString(3, details.getDept());
      pstm.setFloat(4, details.getGPA());
      pstm.setString(8, details.getCounsellors());
      pstm.setDate(5, details.getDOC());
      pstm.setString(6, details.getTopic());
      pstm.setString(7, details.getActions());
      pstm.setString(9, details.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertDetails(Connection conn, Details details) throws SQLException {
      String sql = "Insert into Details(Rollno, Regno, Name, Dept, GPA, Counsellors, TOC, Topic, Actions) values (?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, details.getRollno());
      pstm.setString(2, details.getRegno());
      pstm.setString(3, details.getName());
      pstm.setString(4, details.getDept());
      pstm.setFloat(5, details.getGPA());
      pstm.setString(6, details.getCounsellors());
      pstm.setDate(7, details.getDOC());
      pstm.setString(8, details.getTopic());
      pstm.setString(9, details.getActions());
 
      pstm.executeUpdate();
  }
 
  public static void deleteDetails(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Details where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchDetails(Connection conn, Details details) throws SQLException {
      String sql = "Select ? from Details ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, details.getRollno());
  }
 
  public static List<Details> queryDetails1(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.DOC, a.Actions, a.Topic, a.GPA, a.Counsellors from Details1 a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Details> list = new ArrayList<Details>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          Date DOC = rs.getDate("DOC");
          String Topic = rs.getString("Topic");
          String Actions = rs.getString("Actions");
          String Counsellors = rs.getString("Counsellors");
          Details details = new Details();
          details.setRollno(Rollno);
          details.setRegno(Regno);
          details.setName(Name);
          details.setDept(Dept);
          details.setGPA( GPA );
          details.setCounsellors(Counsellors);
          details.setActions(Actions);
          details.setDOC(DOC);
          details.setTopic(Topic);
          list.add(details);
      }
      return list;
  }
 
  public static Details findDetails1(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.DOC, a.Actions, a.Topic, a.GPA, a.Counsellors from Details1 a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          Date DOC = rs.getDate("DOC");
          String Topic = rs.getString("Topic");
          String Actions = rs.getString("Actions");
          String Counsellors = rs.getString("Counsellors");
          Details details = new Details(Rollno, Regno, Name, Dept, DOC, Topic, Actions, GPA, Counsellors);
          return details;
      }
      return null;
  }
 
  public static void updateDetails1(Connection conn, Details details) throws SQLException {
      String sql = "Update Details1 set Regno =?, Name =?, Dept=?, GPA=?, DOC=?, Topic=?, Actions=?, Counsellors=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, details.getRegno());
      pstm.setString(2, details.getName());
      pstm.setString(3, details.getDept());
      pstm.setFloat(4, details.getGPA());
      pstm.setString(8, details.getCounsellors());
      pstm.setDate(5, details.getDOC());
      pstm.setString(6, details.getTopic());
      pstm.setString(7, details.getActions());
      pstm.setString(9, details.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertDetails1(Connection conn, Details details) throws SQLException {
      String sql = "Insert into Details1(Rollno, Regno, Name, Dept, GPA, Counsellors, TOC, Topic, Actions) values (?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, details.getRollno());
      pstm.setString(2, details.getRegno());
      pstm.setString(3, details.getName());
      pstm.setString(4, details.getDept());
      pstm.setFloat(5, details.getGPA());
      pstm.setString(6, details.getCounsellors());
      pstm.setDate(7, details.getDOC());
      pstm.setString(8, details.getTopic());
      pstm.setString(9, details.getActions());
 
      pstm.executeUpdate();
  }
 
  public static void deleteDetails1(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Details1 where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchDetails1(Connection conn, Details details) throws SQLException {
      String sql = "Select ? from Details1 ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, details.getRollno());
  }
 
  public static List<Details> queryDetails2(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.DOC, a.Actions, a.Topic, a.GPA, a.Counsellors from Details2 a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Details> list = new ArrayList<Details>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          Date DOC = rs.getDate("DOC");
          String Topic = rs.getString("Topic");
          String Actions = rs.getString("Actions");
          String Counsellors = rs.getString("Counsellors");
          Details details = new Details();
          details.setRollno(Rollno);
          details.setRegno(Regno);
          details.setName(Name);
          details.setDept(Dept);
          details.setGPA( GPA );
          details.setCounsellors(Counsellors);
          details.setActions(Actions);
          details.setDOC(DOC);
          details.setTopic(Topic);
          list.add(details);
      }
      return list;
  }
 
  public static Details findDetails2(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.DOC, a.Actions, a.Topic, a.GPA, a.Counsellors from Details2 a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          Date DOC = rs.getDate("DOC");
          String Topic = rs.getString("Topic");
          String Actions = rs.getString("Actions");
          String Counsellors = rs.getString("Counsellors");
          Details details = new Details(Rollno, Regno, Name, Dept, DOC, Topic, Actions, GPA, Counsellors);
          return details;
      }
      return null;
  }
 
  public static void updateDetails2(Connection conn, Details details) throws SQLException {
      String sql = "Update Details2 set Regno =?, Name =?, Dept=?, GPA=?, DOC=?, Topic=?, Actions=?, Counsellors=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, details.getRegno());
      pstm.setString(2, details.getName());
      pstm.setString(3, details.getDept());
      pstm.setFloat(4, details.getGPA());
      pstm.setString(8, details.getCounsellors());
      pstm.setDate(5, details.getDOC());
      pstm.setString(6, details.getTopic());
      pstm.setString(7, details.getActions());
      pstm.setString(9, details.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertDetails2(Connection conn, Details details) throws SQLException {
      String sql = "Insert into Details2(Rollno, Regno, Name, Dept, GPA, Counsellors, TOC, Topic, Actions) values (?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, details.getRollno());
      pstm.setString(2, details.getRegno());
      pstm.setString(3, details.getName());
      pstm.setString(4, details.getDept());
      pstm.setFloat(5, details.getGPA());
      pstm.setString(6, details.getCounsellors());
      pstm.setDate(7, details.getDOC());
      pstm.setString(8, details.getTopic());
      pstm.setString(9, details.getActions());
 
      pstm.executeUpdate();
  }
 
  public static void deleteDetails2(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Details2 where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchDetails2(Connection conn, Details details) throws SQLException {
      String sql = "Select ? from Details2 ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, details.getRollno());
  }
 
  public static List<Details> queryDetails3(Connection conn) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.DOC, a.Actions, a.Topic, a.GPA, a.Counsellors from Details3 a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Details> list = new ArrayList<Details>();
      while (rs.next()) {
          String Rollno = rs.getString("Rollno");
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          Date DOC = rs.getDate("DOC");
          String Topic = rs.getString("Topic");
          String Actions = rs.getString("Actions");
          String Counsellors = rs.getString("Counsellors");
          Details details = new Details();
          details.setRollno(Rollno);
          details.setRegno(Regno);
          details.setName(Name);
          details.setDept(Dept);
          details.setGPA( GPA );
          details.setCounsellors(Counsellors);
          details.setActions(Actions);
          details.setDOC(DOC);
          details.setTopic(Topic);
          list.add(details);
      }
      return list;
  }
 
  public static Details findDetails3(Connection conn, String Rollno) throws SQLException {
      String sql = "Select a.Rollno, a.Regno, a.Name, a.Dept, a.DOC, a.Actions, a.Topic, a.GPA, a.Counsellors from Details3 a where a.Rollno=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, Rollno);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  
          String Regno = rs.getString("Regno");
          String Name = rs.getString("Name");
          String Dept = rs.getString("Dept");
          float GPA = rs.getFloat("GPA");
          Date DOC = rs.getDate("DOC");
          String Topic = rs.getString("Topic");
          String Actions = rs.getString("Actions");
          String Counsellors = rs.getString("Counsellors");
          Details details = new Details(Rollno, Regno, Name, Dept, DOC, Topic, Actions, GPA, Counsellors);
          return details;
      }
      return null;
  }
 
  public static void updateDetails3(Connection conn, Details details) throws SQLException {
      String sql = "Update Details3 set Regno =?, Name =?, Dept=?, GPA=?, DOC=?, Topic=?, Actions=?, Counsellors=? where Rollno=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, details.getRegno());
      pstm.setString(2, details.getName());
      pstm.setString(3, details.getDept());
      pstm.setFloat(4, details.getGPA());
      pstm.setString(8, details.getCounsellors());
      pstm.setDate(5, details.getDOC());
      pstm.setString(6, details.getTopic());
      pstm.setString(7, details.getActions());
      pstm.setString(9, details.getRollno());
      pstm.executeUpdate();
  }
 
  public static void insertDetails3(Connection conn, Details details) throws SQLException {
      String sql = "Insert into Details3(Rollno, Regno, Name, Dept, GPA, Counsellors, TOC, Topic, Actions) values (?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, details.getRollno());
      pstm.setString(2, details.getRegno());
      pstm.setString(3, details.getName());
      pstm.setString(4, details.getDept());
      pstm.setFloat(5, details.getGPA());
      pstm.setString(6, details.getCounsellors());
      pstm.setDate(7, details.getDOC());
      pstm.setString(8, details.getTopic());
      pstm.setString(9, details.getActions());
 
      pstm.executeUpdate();
  }
 
  public static void deleteDetails3(Connection conn, String Rollno) throws SQLException {
      String sql = "Delete from Details3 where Rollno = (?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, Rollno);
 
      pstm.executeUpdate();
  }
  public static void searchDetails3(Connection conn, Details details) throws SQLException {
      String sql = "Select ? from Details3 ";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, details.getRollno());
  }
   
}