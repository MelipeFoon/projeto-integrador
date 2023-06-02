/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Home;
import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  java.sql.SQLException;

/**
 *
 * @author felip
 */
public class ConnFactory{
    private static final String servidor ="@localhost";
    private static final String porta ="3306";
    private static final String database ="dbtuhak";
    private static final String usuario ="root";
    private static final String senha ="123";
            
    public static Connection conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"+servidor+":"+porta+"/"+database+"?user="+usuario+"&password="+senha);
        }
        catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("Erro na conexão com o Banco de Dados: "+e);
        }
    }
    
    public static void desconectar(Connection con){
        try{
           if(con !=null){
               con.close();
           } 
        }
        catch(SQLException e){
            throw new RuntimeException("Erro na conexão com o Banco de Dados: "+e);
        }
    }
    
    public static void desconectar(Connection con, PreparedStatement stmt){
        desconectar(con);
        try{
            if(stmt !=null){
                stmt.close();
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro na conexão com o Banco de Dados: "+e);
        }
    }
    
    public static void desconectar(Connection con, PreparedStatement stmt, ResultSet rs){
        desconectar(con, stmt);
        try{
            if(rs !=null){
                rs.close();
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro na conexão com o Banco de Dados: "+e);
        }
    }
}
