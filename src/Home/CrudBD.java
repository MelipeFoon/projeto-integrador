/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Home;
import  java.sql.Connection;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  java.sql.SQLException;
import  java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class CrudBD {
    //private ArrayList<Usuario> meusUsuarios;
    
    public void incluirUser(Usuario ud){
        String sqlInsert ="Insert into usuario(RA, nome, email, senha) values(?,?,?,?)";
        Connection conn =ConnFactory.conectar();
        PreparedStatement stmt =null;
    
        try{
            conn.setAutoCommit(false);
            
            stmt =conn.prepareStatement(sqlInsert);
            stmt.setString(1,ud.getRa());
            stmt.setString(2,ud.getNome());
            stmt.setString(3,ud.getEmail());
            stmt.setString(4, ud.getSenha());
            stmt.executeUpdate();
            
            conn.commit();
        }
        catch(SQLException e){
            try{
                conn.rollback();
                JOptionPane.showMessageDialog(null,"Erro ao incluir os dados: "+e.toString());
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao realizar rollback: "+ex.toString());
            }
        }
        finally{
            ConnFactory.desconectar(conn, stmt);
        }
        
    }
    
    public void consultarUser(Usuario ud){
        String sqlInsert ="select * from usuario where RA=?";
        Connection conn =ConnFactory.conectar();
        PreparedStatement stmt =null;
        ResultSet rs;
        
        try{
            stmt =conn.prepareStatement(sqlInsert);
            stmt.setString(1, ud.getRa());
            rs =stmt.executeQuery();
            if(rs.next()){
                ud.setRa(rs.getString(1));
                ud.setNome(rs.getString(2));
                ud.setEmail(rs.getString(3));
                ud.setSenha(rs.getString(4));
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao consultar dados"+ex.toString());
        }
        finally{
            ConnFactory.desconectar(conn, stmt);
        }
    }
    
    public void checarUser(Usuario ud){
        String sqlSelect ="Select * from usuario where RA=?";
        Connection conn =ConnFactory.conectar();
        PreparedStatement stmt =null;
        ResultSet rs =null;
        try{
            stmt =conn.prepareStatement(sqlSelect);
            stmt.setString(1, ud.getRa());
            rs =stmt.executeQuery();
           
            if(rs.next()){
                if(ud.getRa().equals(rs.getString(1)) && String.valueOf(ud.getSenha()).equals(rs.getString(4))){
                    
                    //Acessar o quiz
                    JOptionPane.showMessageDialog(null, "Acesso permitido");
                }else if(ud.getRa().equals(rs.getString(1)) || String.valueOf(ud.getSenha()).equals(rs.getString(4))){
                    JOptionPane.showMessageDialog(null,"RA ou senha foram digitados incorretamente");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Usuário não está cadastrado");
                }    
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao consultar os dados"+ex.toString());
        }
        finally{
            if(rs!=null){
                try{
                    rs.close();
                }
                catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Erro ao fechar ResultSet: "+ex.toString());
                }
            }
            ConnFactory.desconectar(conn, stmt);
        }
    }
    
    public void incluirRank(Usuario ud){
        String sqlInsert ="Insert into ranking(RA, nome, pontos) values(?,?,?)";
        Connection conn =ConnFactory.conectar();
        PreparedStatement stmt =null;
        
        try{
            conn.setAutoCommit(false);
            
            stmt =conn.prepareStatement(sqlInsert);
            stmt.setString(1,ud.getRa());
            stmt.setString(2,ud.getNome());
            stmt.setInt(3,ud.getPontos());
            stmt.executeUpdate();
            
            conn.commit();
        }
        catch(SQLException e ){
            try{
                conn.rollback();
                JOptionPane.showMessageDialog(null,"Erro ao incluir os dados: "+e.toString());
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao realizar rollback: "+ex.toString());
            }
        }
        finally{
            ConnFactory.desconectar(conn, stmt);
        }
    }
    
    public ArrayList<Usuario> mostrarRank(Connection conn){
        String sqlInsert ="select * from ranking order by pontos desc";
        ArrayList<Usuario> lista = new ArrayList<>();
        conn =ConnFactory.conectar();
        
        try(PreparedStatement stm =conn.prepareStatement(sqlInsert);ResultSet rs =stm.executeQuery();){
            while(rs.next()){
                Usuario us =new Usuario();
                us.setRa(rs.getString("RA"));
                us.setNome(rs.getString("nome"));
                us.setPontos(rs.getInt("pontos"));
                lista.add(us);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList<String> mostrarPerguntas(Connection conn){
        String sqlInsert ="select pergunta from perguntas order by idPergunta asc";
        ArrayList<String> lista =new ArrayList<>();
        conn =ConnFactory.conectar();
        
        try(PreparedStatement stm =conn.prepareStatement(sqlInsert);ResultSet rs =stm.executeQuery();){
            while(rs.next()){
                Perguntas perg =new Perguntas();
                perg.setPergunta(rs.getString("pergunta"));
                lista.add(perg.getPergunta());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    public ArrayList<String> mostrarResposta(Connection conn){
        String sqlInsert ="select resposta from perguntas order by idPergunta asc";
        ArrayList<String> lista =new ArrayList<>();
        conn =ConnFactory.conectar();
        
        try(PreparedStatement stm =conn.prepareStatement(sqlInsert);ResultSet rs =stm.executeQuery();){
            while(rs.next()){
                Perguntas perg =new Perguntas();
                perg.setResposta(rs.getString("resposta"));
                lista.add(perg.getResposta());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public void consult(Usuario ud){
        String sqlSelect ="Select nome from usuario where RA=?";
        Connection conn =ConnFactory.conectar();
        PreparedStatement stmt =null;
        ResultSet rs =null;
        try{
            stmt =conn.prepareStatement(sqlSelect);
            stmt.setString(1, ud.getRa());
            rs =stmt.executeQuery();
            
            if(rs.next()){
                ud.setNome(rs.getString("nome"));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao consultar os dados"+ex.toString());
        }
        finally{
            if(rs!=null){
                try{
                    rs.close();
                }
                catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Erro ao fechar ResultSet: "+ex.toString());
                }
            }
            ConnFactory.desconectar(conn, stmt);
        }
    }
}


