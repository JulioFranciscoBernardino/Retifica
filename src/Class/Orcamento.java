package Class;

import java.math.BigDecimal;

public class Orcamento {
    private int idOrcamento;
    private String nomeCliente;
    private String emailCliente;
    private String telefoneWhats;
    private BigDecimal total;
    private String data;

    // Construtor
    public Orcamento(int idOrcamento, String nomeCliente, String emailCliente, String telefoneWhats, BigDecimal total, String data) {
        this.idOrcamento = idOrcamento;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneWhats = telefoneWhats;
        this.total = total;
        this.data = data;
    }

    // Getters e Setters
    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneWhats() {
        return telefoneWhats;
    }

    public void setTelefoneWhats(String telefoneWhats) {
        this.telefoneWhats = telefoneWhats;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    public String getData() { 
        return data; 
    }
    
    public void setData(String data) {
        this.data = data;
    }
}
