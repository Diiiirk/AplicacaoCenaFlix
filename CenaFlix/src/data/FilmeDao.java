/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author diego
 */
public class FilmeDao {
    
    // ATRIBUTOS DE CONEXÃO
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    Statement stmt;
    
    // METODO PARA ESTABELECER CONEXÃO
    public boolean conectar(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // CHAMA DRIVER
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CenaFlix","root","1234"); // FAZ CONEXÃO
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage()); // LANÇA ERRO
            return false;
        }
    }
            
    // METODO PARA INSERIR NOVO FILME NO BD
    public void inserir(Filme f){
         
         String query = "INSERT INTO Filme (nomeFilme,dataLancamento,categoriaFilme) VALUES " // COMANDO DE INSERT
                    + "('" + f.getNomeFilme() +"','"+ f.getDataLancamento() +"','"+ f.getCategoria() +"')";
      
        try {
            st = conn.prepareStatement(query);
            st.executeUpdate(); // EXECUÇÃO DO COMANDO
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir: " + ex.getMessage());
        }
     
    }
    
    //METODO PARA ATUALIZAR DADOS DO FILME NO BD
    public void atualizar(Filme f, int i){
        
        String query = "UPDATE Filme SET nomeFilme = '"+ f.getNomeFilme() +"', dataLancamento = '"+ f.getDataLancamento() +"', categoriaFilme = '"+ f.getCategoria() +"' WHERE idFilme = " + i;
      
        try {
            st = conn.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar: " + ex.getMessage());
        }
    }
    
    //METODO PARA EXCLUSAO NO BD
    public void deletaLinha(int i){
        
        String query = "DELETE from Filme where idFilme = " + i;
        
        try {
            
            st = conn.prepareStatement(query);
            st.executeUpdate();
    
    } catch ( SQLException sqle ) {
        System.out.println( "Erro deletar: "+ sqle.getMessage());
        }
    }
    
    // METODO COMENTADO PARA SER IMPLEMENTADO EM OUTRO JFRAME
//    public Filme puxarDadosEmEdicao(int i){
//        
//                Filme filme = new Filme();
//                String Query = "SELECT * FROM Filme WHERE idFilme =" + i ;
//        try {
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(Query);
//            
//            while (rs.next()) {
//            int id = rs.getInt("idFilme");
//            String nomeFilme = rs.getString("nomeFilme");
//            String dataFilme = rs.getString("dataLancamento");
//            String categoriaFilme = rs.getString("categoriaFilme");
//            
//            filme.setIdFilme(id);
//            filme.setNomeFilme(nomeFilme);
//            filme.setDataLancamento(dataFilme);
//            filme.setCategoria(categoriaFilme);
//            }   
//        } catch (SQLException ex) {
//            System.out.println("Erro ao puxar dados: " + ex.getMessage());
//        }
//        return filme;         
//    }
    
    // METODO QUE LISTA FILMES DO BD
    public ArrayList<Filme> listar(){
        
        ArrayList<Filme> listaFilmes = new ArrayList<>();
        
        String Query = "SELECT idFilme,nomeFilme,dataLancamento,categoriaFilme from Filme" ;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(Query);
            
            while (rs.next()) {
                Filme filme = new Filme();
                int id = rs.getInt("idFilme");
                String nomeFilme = rs.getString("nomeFilme");
                String dataFilme = rs.getString("dataLancamento");
                String categoriaFilme = rs.getString("categoriaFilme");
                
                filme.setIdFilme(id);
                filme.setNomeFilme(nomeFilme);
                filme.setDataLancamento(dataFilme);
                filme.setCategoria(categoriaFilme);
                
                listaFilmes.add(filme);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao listar: " + ex.getMessage());
        }
      
        return listaFilmes;
    }  
    
    //METODO PARA MOSTRAR TODOS OS FILMES CASO A BUSCA ESTEJA EM BRANCO
    public ArrayList<Filme> listaTudoFiltro(){
        
         ArrayList<Filme> listaFilme = new ArrayList<>();
         String Query = "SELECT * from Filme";
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(Query);
            
            while (rs.next()) {
                Filme filme = new Filme();
                int id = rs.getInt("idFilme");
                String nomeFilme = rs.getString("nomeFilme");
                String dataFilme = rs.getString("dataLancamento");
                String categoriaFilme = rs.getString("categoriaFilme");
                
                filme.setIdFilme(id);
                filme.setNomeFilme(nomeFilme);
                filme.setDataLancamento(dataFilme);
                filme.setCategoria(categoriaFilme);
                
                listaFilme.add(filme);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao listar: " + ex.getMessage());
        }
      
        return listaFilme;
    }
    
    //METODO PARA FILTRAR FILMES POR CATEGORIA
    public ArrayList<Filme> listaFiltro(String a){
        
         ArrayList<Filme> listaFilme = new ArrayList<>();
         String Query = "SELECT * FROM Filme WHERE categoriaFilme LIKE '%" + a + "%'";
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(Query);
            
            while (rs.next()) {
                Filme filme = new Filme();
                int id = rs.getInt("idFilme");
                String nomeFilme = rs.getString("nomeFilme");
                String dataFilme = rs.getString("dataLancamento");
                String categoriaFilme = rs.getString("categoriaFilme");
                
                filme.setIdFilme(id);
                filme.setNomeFilme(nomeFilme);
                filme.setDataLancamento(dataFilme);
                filme.setCategoria(categoriaFilme);
                
                listaFilme.add(filme);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao listar: " + ex.getMessage());
        }
      
        return listaFilme;
    }
    
    // METODO QUE DESCONECTA O BD
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            //pode-se deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
}
