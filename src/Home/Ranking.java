/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Home;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
/**
 *
 * @author felip
 */
public class Ranking {
    private ArrayList<Usuario> aLista;
    CrudBD cBD =new CrudBD();
    Usuario uDraft = new Usuario();
    Connection conn;
    
    /*public Ranking(){
        meusUsuarios =new ArrayList<Usuario>();
    }
    
    public void adicionarTabela(CrudBD cBD){
        meusUsuarios.add(cBD.mostrarRank());
        
    }*/
    
    public void mostrarTabela(){
        JFrame frame =new JFrame("Ranking");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        String colunas[] ={"RA", "Nome", "Pontos"};
        
        DefaultTableModel modelo =new DefaultTableModel(colunas,0);
        
        aLista =cBD.mostrarRank(conn);
        for(int i =0; i <aLista.size(); i++){
            uDraft =aLista.get(i);
            Object dados[] ={uDraft.getRa(), uDraft.getNome(), uDraft.getPontos()};
            modelo.addRow(dados);
        }
        
        JTable tabela =new JTable(modelo);
        
        JScrollPane scrollPane =new JScrollPane(tabela);
        
        frame.add(scrollPane);
        
        frame.setSize(500,200);
        frame.setVisible(true);
        
        
        frame.setLocationRelativeTo(null);
        
        /*JOptionPane.showMessageDialog(null, "Acione OK para ver no console os usuários e senhas cadastrados!");
            aLista = cBD.mostrarRank(conn);
            for (int i = 0; i < aLista.size(); i++)
                {   uDraft = aLista.get(i);
                    System.out.println(uDraft.getRa() + "-" + uDraft.getNome() + "-" + uDraft.getPontos());
                }
                System.out.println("------------------------------");*/
    }
    
    
}
