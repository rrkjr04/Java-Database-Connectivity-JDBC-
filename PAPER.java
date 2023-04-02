import java.util.*;
import java.sql.*;
import java.lang.Exception;

class SmartPhone1{
    public String model;
    public String cname;

    SmartPhone1(String model,String cname)          //Construtctor to initialize values to attributes
    {
        this.model = model;
        this.cname = cname;
    }

    ArrayList<SmartPhone1> arrli = new ArrayList<SmartPhone1>();         //An ArrayList to store values coming from database

    public ArrayList<SmartPhone1> allData()
    {
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");     //Old term com.mysql.jdbc.Driver is no longer available
            Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM smartphone");
            while(rs.next())
            {
                SmartPhone1 obj = new SmartPhone1(rs.getString(1),rs.getString(2));
                arrli.add(obj);

            }
            con.close();
        }

        catch (Exception e)
        {
            System.out.println(e);
        }
        return arrli;
    }
}
public class PAPER extends SmartPhone1 {
    PAPER(String un,String vn)              //Constructor is made because if you are inheriting a class you have to make a constructor with same arguements in child class as it is present in base class
    {
        super(un,vn);
    }


    public static void main(String[] args) {
        SmartPhone1 obj = new SmartPhone1("test","test");
        ArrayList<SmartPhone1> arli1 = obj.allData();
        for(int i=0;i<arli1.size();i++)
        {
            System.out.println(arli1.get(i).model+" \t "+arli1.get(i).cname);
        }
        System.out.println("Successfully ! Access Data From smartphone SQL Database");
    }
}
