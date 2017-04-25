package ejerciciopruebafxbd;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/* @author Álvaro García Fernández*/
public class FXMLDocumentController implements Initializable {
    private Connection conn;
    private Label label;
    @FXML
    private Label LabelUsuario;
    @FXML
    private TextField TextFieldUsuario;
    @FXML
    private Label LabelPassword;
    @FXML
    private TextField TextFieldPassword;
    @FXML
    private Label LabelBD;
    @FXML
    private TextField TextFieldBD;
    @FXML
    private TextArea TextAreaDisplay;
    @FXML
    private Button ButtonConectar;
    @FXML
    private Button ButtonDesconectar;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void ActionTextAreaDisplay(MouseEvent event) {
    }

    @FXML
    private void ActionButtonConectar(ActionEvent event) {
        String usuario=this.TextFieldUsuario.getText();
        String pass=this.TextFieldPassword.getText();
        String bd=this.TextFieldBD.getText();
        String url = "jdbc:mysql://localhost:3306/" + bd;
        
        try {
            conn = DriverManager.getConnection(url, usuario, pass) ;
        if (conn != null) {
                this.TextAreaDisplay.appendText("Conexion a base de datos " + url + " ... OK"+"\n");

            }
          } catch (SQLException ex) {
           this.TextAreaDisplay.appendText("Hubo un problema al intentar conectarse con la base de datos " + url+"\n");
           this.TextAreaDisplay.appendText("Error: " + ex.getMessage()+"\n");
        } 
         catch (Exception e) {
            this.TextAreaDisplay.appendText(e.getMessage()+"\n");
        }
    }

    @FXML
    private void ActionButtonDesconectar(ActionEvent event) {
        try{
            this.conn.close();
             this.TextAreaDisplay.appendText("Desconexión realizada con éxito \n");
        }catch (SQLException ex){
             this.TextAreaDisplay.appendText("Fallo al desconectar \n");
        }
 
    }
    
}
