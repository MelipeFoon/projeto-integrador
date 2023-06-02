/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Home;

/**
 *
 * @author felip
 */
public final class Usuario {
    //Atributos
    private String Ra;
    private String nome;
    private String email;
    private String senha;
    private int pontos;
    
    public Usuario(){
        clearObjects();
    }
    
    
    //Método construtor
    public Usuario(String r, String n, String em, String s, int p){
        setRa(r);
        setNome(n);
        setEmail(em);
        setSenha(s);
        setPontos(p);
    }
    
    //Métodos de acesso
    public String getRa(){
        return Ra;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public int getPontos(){
        return pontos;
    }
    
    //Métodos modificadores
    public void setRa(String r){
        Ra=r;
    }
    
    public void setNome(String n){
        nome=n;
    }
    
    public void setEmail(String em){
        email=em;
    }
    
    public void setSenha(String s){
        senha=s;
    }
    
    public void setPontos(int p){
        pontos=p;
    }
    
    public void clearObjects(){
        Ra ="Não há RA cadastrado";
        nome ="Não há nome cadastrado";
        email ="Não há email cadastrado";
        senha ="Não há senha cadastrada";
    }
}
