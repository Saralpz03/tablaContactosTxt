/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablacontactos;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Alexara
 */
public class main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox h=new HBox(10);
        Label lb=new Label();
        
        ArrayList<Contacto> lista_contactos=AccesoBD.leerContactos();
        TableView tvPrincipal=new TableView();
        TableColumn<Contacto, String> col1=new TableColumn<>("Nombre");
        TableColumn<Contacto, String> col2=new TableColumn<>("Apellido");
        TableColumn<Contacto, String> col3=new TableColumn<>("Color");
        
        //Lo enlazo con lo que quiero que aparezca
        col1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col2.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        col3.setCellValueFactory(new PropertyValueFactory<>("color"));
        tvPrincipal.getColumns().addAll(col1,col2,col3);

        for(Contacto x : lista_contactos){
            tvPrincipal.getItems().add(x);
        }
   
        
        Scene escena=new Scene(h,400,400);
        h.getChildren().addAll(tvPrincipal,lb);
        stage.setScene(escena);
        stage.show();
    }
}
