import java.sql.*;

public class conn
{
    Connection c;
    Statement s;
    public conn()
    {
        try
        {




            String url="jdbc:mysql://localhost:3306/electricity_billinng_system";
            String username="root";
            String pwd="Electricity@4!";

            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection(url,username,pwd);
            s=c.createStatement();
                
            


        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public boolean getUser(String userid,String password)  {
    	boolean status=false;
    	try {
    				
    				String sql  = "select * from electricity_billinng_system.user_login where user_id = '"+userid+"' and password = '"+password+"'";
    				Statement st=c.createStatement();
    				ResultSet rs = st.executeQuery(sql);
    				System.out.println("method select called");
					
    				while(rs.next()) {
    					System.out.println("Userid="+rs.getString(1));
    					System.out.println("Password="+rs.getString(2));
						status=true;
    				}
    			} catch (Exception e) {
    				// TODO: handle exception
    				e.printStackTrace();
    			}
				return status;
    			}
}


