
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {
    
    Connection c = null;
    Statement stmt = null;
    
    public void createUserTable(){
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "CREATE TABLE USERS " +
                   "(USERNAME   PRIMARY KEY TEXT     NOT NULL," +
                   " PASSWORD           TEXT    NOT NULL, " + 
                   " TYPE            TEXT     NOT NULL)";  
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
    }
   }
    
    
    public void createProductTable(){
     try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "CREATE TABLE PRODUCT " +
                   "(TYPE    TEXT     NOT NULL," +
                   " NAME           TEXT    NOT NULL, "+ 
                   " CODE            TEXT     NOT NULL ,"+
                   " PRICE            TEXT     NOT NULL ,"+
                   " QUANTITY            INT     NOT NULL)";
                      
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
        System.out.println(e.getMessage());
    }   
    }
    public void createOrderTable(){
     try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "CREATE TABLE ORDERS " +
                   "(NAME    TEXT     NOT NULL," +
                   " CODE           TEXT    NOT NULL, "+ 
                   " STATUS            TEXT     NOT NULL ,"+
                   " ITEMS            INT     NOT NULL ,"+
                   " PRICE            DOUBLE     NOT NULL)";
                      
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
        System.out.println(e.getMessage());
    }   
    }
    public void insertOrder(Order order){
         try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "INSERT INTO ORDERS (NAME,CODE,STATUS,ITEMS,PRICE) " +
                   "VALUES ("+"'"+order.getUsername()+"','"+order.getCode()+"','"+order.getStatus()
                    +"','"+order.getItems().size()+"','"+order.getTotalPrice()+"'"+");";  
      System.out.println(sql);
      stmt.executeUpdate(sql);

      
      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
    }
     
    }
        
    public void getOrders(UserPass pass){
        Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM ORDERS;" );
      while ( rs.next() ) {
         String name = rs.getString("NAME");
         String  code = rs.getString("CODE");
         String status  = rs.getString("STATUS");
         double price=rs.getDouble("PRICE");
         int items=rs.getInt("ITEMS");
         
         Order order=new Order(name);
         order.setCode(Integer.parseInt(code));
         order.setStatus(status);
         order.setPrice(price);
         order.setItems(items);
         pass.addOrder(order);
                
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     
    }
     
    }
    public void updateOrder(Order order){
        try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "UPDATE ORDERS set STATUS = 'DELIVERED' where CODE="+order.getCode()+";";
      stmt.executeUpdate(sql);
      c.commit();

      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    }
    public void insertUser(Entity user){
         try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "INSERT INTO USERS (USERNAME,PASSWORD,TYPE) " +
                   "VALUES ("+"'"+user.getUsername()+"','"+user.getPassword()+"','"+user.getType()+"'"+");"; 
      System.out.println(sql);
      stmt.executeUpdate(sql);

      
      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
    }
    System.out.println("Records created successfully");
    }
    public void insertProduct(Product product){
        try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "INSERT INTO PRODUCT (TYPE,NAME,CODE,PRICE,QUANTITY) " +
                   "VALUES ("+"'"+product.getType()+"','"+product.getName()+"','"+product.getCode()
                    +"','"+product.getPrice()+"','"+product.getQuantity()+"'"+");"; 
      System.out.println(sql);
      stmt.executeUpdate(sql);

      
      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
    }
    System.out.println("Records created successfully");
    }
    public void getAllProducts(UserPass pass){
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCT;" );
      while ( rs.next() ) {
         String type = rs.getString("TYPE");
         String  name = rs.getString("NAME");
         String code  = rs.getString("CODE");
         double price=rs.getDouble("PRICE");
         int quantity=rs.getInt("QUANTITY");
         
         
         Product x=new Product(name, code, price, quantity, type);
         pass.addProduct(x);
                
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     
    }   
   }
    public void deleteProduct(String code){
        try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "DELETE from PRODUCT where CODE='"+code+"';";
      stmt.executeUpdate(sql);
      c.commit();

      
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
        }
    }
    public void updateProduct(UserPass pass,Product x,String code){
        try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      
      stmt = c.createStatement();
      String sql = "UPDATE PRODUCT set NAME ='"+x.getName()+"',CODE='"+x.getCode()+"',PRICE='"+x.getPrice()+""
              + "',QUANTITY='"+x.getQuantity()+"' where CODE='"+code+"';";
      stmt.executeUpdate(sql);
      c.commit();

     
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    }
    
    public void getAllUsers(UserPass pass){
        Connection c = null;
        Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM USERS;" );
      while ( rs.next() ) {
         String username = rs.getString("USERNAME");
         String  password = rs.getString("PASSWORD");
         String type  = rs.getString("TYPE");
         Type typ=type.equals("CUSTOMER")?Type.CUSTOMER: Type.ADMINISTRATOR;
         pass.addUser(new Entity(username, password, typ));
                
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     
    }
    System.out.println("Operation done successfully");

    }
    
    
    
       public ArrayList<String> getAllUserstoShow(){
        Connection c = null;
        Statement stmt = null;
        ArrayList<String> users=new ArrayList<String>();
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:OnlineStore.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM USERS;" );
      while ( rs.next() ) {
         String username = rs.getString("USERNAME");
         String type  = rs.getString("TYPE");
         if(type.equals("ADMINISTRATOR"))
         {
             
         }
         else   
         {
         users.add(username);
         }
         
                
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     
    }
    System.out.println("Operation done successfully");
    return users;
    }
    
}
