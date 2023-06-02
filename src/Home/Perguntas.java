/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Home;

/**
 *
 * @author felip
 */
public final class Perguntas {
    private String pergunta;
    private String resposta;
    //private String resposta;
    
    public Perguntas(){
        clearObjects();
    }
    
    public Perguntas(String p, String r){
        setPergunta(p);
        setResposta(r);
    }
    
    public String getPergunta(){
        return pergunta;
    }
    
    public String getResposta(){
        return resposta;
    }
    
    public void setPergunta(String p){
        pergunta=p;
    }
    
    public void setResposta(String r){
        resposta=r;
    }
    
    public void clearObjects(){
        pergunta ="Não há perguntas cadastradas";
    }
    
}
