/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author diego
 */
public class Filme {
    
    // ATRIBUTOS DA CLASSE FILME
    
    private int idFilme;
    private String nomeFilme;
    private String dataLancamento;
    private String categoria;
    
    // CONSTRUTOR
    public Filme(){
        
    }
    /**
     * @return the categoria
     */
    
    // GET E SET 
    
    public String getCategoria() {
        return categoria;
    }

    /**
     * @return the dataLancamento
     */
    public String getDataLancamento() {
        return dataLancamento;
    }

    /**
     * @return the nomeFilme
     */
    public String getNomeFilme() {
        return nomeFilme;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @param dataLancamento the dataLancamento to set
     */
    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    /**
     * @param nomeFilme the nomeFilme to set
     */
    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    /**
     * @return the idFilme
     */
    public int getIdFilme() {
        return idFilme;
    }

    /**
     * @param idFilme the idFilme to set
     */
    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }
    
}
