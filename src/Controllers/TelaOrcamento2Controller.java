package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TelaOrcamento2Controller {

    @FXML
    private TextField cliente;

    @FXML
    private Button concluir;

    @FXML
    private TextField email;

    @FXML
    private TextField telefone;

    @FXML
    private TextField total;

    private static final String URL = "jdbc:sqlite:C:/Users/julio/Documents/NetBeansProjects/ProjetoJava-main (1)/ProjetoJava-main/db_retifica.db";
    
    @FXML
    public void initialize() {
        criarTabelaOrcamentos();
    }

    @FXML
    void Concluir(ActionEvent event) {
        String cliente = this.cliente.getText();
        String email = this.email.getText();
        String telefone = this.telefone.getText();
        String total = this.total.getText();
        
        if (inserirOrcamento(cliente, email, telefone, total)) {
            System.out.println("Orçamento inserido com sucesso.");
            voltarParaTela2(event);
        } else {
            System.out.println("Erro ao inserir orçamento.");
        }
    }

    private void criarTabelaOrcamentos() {
        String sql = "CREATE TABLE IF NOT EXISTS orcamento ("
                   + "idorcamento INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "nomecliente VARCHAR(50) NOT NULL,"
                   + "emailcliente VARCHAR(50) NOT NULL,"
                   + "telefonewhats VARCHAR(14) NOT NULL,"
                   + "total NUMERIC(10,2) CHECK(total > 0) NOT NULL"
                   + ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'orcamento' verificada/criada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao verificar/criar a tabela 'orcamento'.");
        }
    }

    private boolean inserirOrcamento(String cliente, String email, String telefone, String total) {
        String sql = "INSERT INTO orcamento (nomecliente, emailcliente, telefonewhats, total) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente);
            pstmt.setString(2, email);
            pstmt.setString(3, telefone);
            pstmt.setString(4, total);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void voltarParaTela2(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/Tela2.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
