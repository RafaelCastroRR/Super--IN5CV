/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rafaelcastro.system;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import java.io.InputStream;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.rafaelcastro.controller.FormularioCargoController;
import org.rafaelcastro.controller.FormularioCategoriaProductoController;
import org.rafaelcastro.controller.FormularioClienteController;
import org.rafaelcastro.controller.FormularioCompraController;
import org.rafaelcastro.controller.FormularioDistribuidorController;
import org.rafaelcastro.controller.FormularioEmpleadoController;
import org.rafaelcastro.controller.MenuCargoController;
import org.rafaelcastro.controller.MenuCategoriaProductoController;
import org.rafaelcastro.controller.MenuClienteController;
import org.rafaelcastro.controller.MenuCompraController;
import org.rafaelcastro.controller.MenuDistribuidorController;
import org.rafaelcastro.controller.MenuEmpleadoController;
import org.rafaelcastro.controller.MenuFacturaController;
import org.rafaelcastro.controller.MenuPrincipalController;
import org.rafaelcastro.controller.MenuTicketSoporteController;
/**
 *
 * @author Usuario
 */
public class Main extends Application {
    private Stage stage;
    private Scene scene;
    private final String URLVIEW = "/org/rafaelcastro/view/";
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Super Kinal App");
        menuPrincipalView();
        stage.show();
    }
    
    public Initializable switchScene(String fxmlName, int width, int height)throws Exception{
        Initializable resultado;
        FXMLLoader loader = new FXMLLoader();
        
        InputStream file = Main.class.getResourceAsStream(URLVIEW + fxmlName);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(URLVIEW + fxmlName));
        
        scene = new Scene((AnchorPane)loader.load(file), width, height);
        stage.setScene(scene);
        stage.sizeToScene();
        
        resultado = (Initializable)loader.getController();
        return resultado;
    }
    
    public void menuPrincipalView(){
        try{
            MenuPrincipalController menuPrincipalView = (MenuPrincipalController)switchScene("MenuPrincipalView.fxml",950,730);
            menuPrincipalView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formClienteView(int op){
        try{
            FormularioClienteController formClienteView = (FormularioClienteController)switchScene("FormularioClienteView.fxml",350,520);
            formClienteView.setOp(op);
            formClienteView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
        
    public void menuClientesView(){
        try{
           MenuClienteController menuClientesView = (MenuClienteController)switchScene("MenuClienteView.fxml",1000,680); 
           menuClientesView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
     public void menuTickettSoporteView(){
        try{
            MenuTicketSoporteController menuTicketSoporteView = (MenuTicketSoporteController)switchScene("MenuTicketSoporteView.fxml",1000,680);
            menuTicketSoporteView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
     
    public void formDistribuidoresView(int op){
        try{
            FormularioDistribuidorController formDistribuidoresView = (FormularioDistribuidorController)switchScene("FormularioDistribuidorView.fxml", 350, 520);
            formDistribuidoresView.setOp(op);
            formDistribuidoresView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuDistribuidorView(){
        try{
            MenuDistribuidorController menuDistribuidorView = (MenuDistribuidorController)switchScene("MenuDistribuidorView.fxml",1000,680);
            menuDistribuidorView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formCargosView(int op){
        try{
            FormularioCargoController formCargosView = (FormularioCargoController)switchScene("FormularioCargoView.fxml", 350, 520);
            formCargosView.setOp(op);
            formCargosView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuCargoView(){
        try{
            MenuCargoController menuCargoView = (MenuCargoController)switchScene("MenuCargoView.fxml",1000,680);
            menuCargoView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formEmpleadosView(int op){
        try{
            FormularioEmpleadoController formEmpleadosView = (FormularioEmpleadoController)switchScene("FormularioEmpleadoView.fxml", 580, 680);
            formEmpleadosView.setOp(op);
            formEmpleadosView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuEmpleadoView(){
        try{
            MenuEmpleadoController menuEmpleadoView = (MenuEmpleadoController)switchScene("MenuEmpleadoView.fxml",1000,680);
            menuEmpleadoView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
   
    
    public void formCategoriaProductos(int op){
        try{
            FormularioCategoriaProductoController formCategoriaProductos = (FormularioCategoriaProductoController)switchScene("FormularioCategoriaProductoView.fxml", 350, 520);
            formCategoriaProductos.setOp(op);
            formCategoriaProductos.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuCategoriaProductoView(){
        try{
            MenuCategoriaProductoController menuCategoriaProductoView = (MenuCategoriaProductoController)switchScene("MenuCategoriaProductoView.fxml",1000,680);
            menuCategoriaProductoView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formComprasView(int op){
        try{
            FormularioCompraController formComprasView = (FormularioCompraController)switchScene("FormularioCompraView.fxml", 350, 520);
            formComprasView.setOp(op);
            formComprasView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuCompraView(){
        try{
            MenuCompraController menuCompraView = (MenuCompraController)switchScene("MenuCompraView.fxml",1000,680);
            menuCompraView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
      public void menuFacturaView(){
        try{
            MenuFacturaController menuFacturaView = (MenuFacturaController)switchScene("MenuFacturaView.fxml",1000,680);
            menuFacturaView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
    

    
}
