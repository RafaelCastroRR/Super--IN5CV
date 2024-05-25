
package org.rafaelcastro.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import org.rafaelcastro.dao.Conexion;
import org.rafaelcastro.model.CategoriaProducto;
import org.rafaelcastro.model.Distribuidor;
import org.rafaelcastro.system.Main;

/**
 * FXML Controller class
 *
 * @author robin
 */
public class FormProductosController implements Initializable {
    
    private Main stage;
    private int op;
    private MenuProductosController actualizar;
    private List<File> files = null;
    private static Connection conexion = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    @FXML
    Button btnAgregar, btnCancelar;
    @FXML
    TextField tfProductoId,tfStock,tfNombre,tfPrecioVentaUnitario,tfPrecioVentaMayor,tfPrecioCompra;
    @FXML
    TextArea taDescripcion;
    @FXML
    ComboBox cmbDistribuidor,cmbCategoria;
    @FXML
    ImageView imgSubir,imgMostrar;
    @FXML
    Label lblNombreProducto;
    
    @Override
    public void initialize(URL location, ResourceBundle Dresources) {
        cmbDistribuidor.setItems(listarDistribuidores());
        cmbCategoria.setItems(listarCaregoria());
    }
    
    @FXML
    public void handleButtonAction(ActionEvent event){
        if(event.getSource() == btnCancelar){
            stage.menuProductoView();
        }if(event.getSource() == btnAgregar){
            if(tfProductoId.getText().equals("")){
                agregarProducto();
                
                if(actualizar!= null){
                    actualizar.cargarDatos();
                }
                
                stage.menuProductoView();              
            }
        }
    }

    
    @FXML
    public void handleOnDrag(DragEvent event){
        // Habilita el Image View para que reciba archivos
        
        if(event.getDragboard().hasFiles()){ // Verifca que haya un archivo pasando sobre el para recibirlo
           event.acceptTransferModes(TransferMode.ANY);   
        }    
    }
    
    @FXML
    public void handleOnDrop(DragEvent event){
        try{
            files = event.getDragboard().getFiles();  //Almacena el archivo en la lista
            FileInputStream file = new FileInputStream(files.get(0));
            Image image = new Image(file);
            imgSubir.setImage(image);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    // Agregar
    public void agregarProducto(){
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            String sql = "call sp_AgregarProducto(?,?,?,?,?,?,?,?,?)";
            statement = conexion.prepareStatement(sql);
            
            statement.setString(1,tfNombre.getText());
            statement.setString(2,taDescripcion.getText());
            statement.setString(3, tfStock.getText());
            statement.setDouble(4,Double.parseDouble(tfPrecioVentaUnitario.getText()));     
            statement.setDouble(5,Double.parseDouble(tfPrecioVentaMayor.getText()));
            statement.setDouble(6,Double.parseDouble(tfPrecioCompra.getText()));
            InputStream img = new FileInputStream(files.get(0)); // Convierte la foto a binario
            statement.setBinaryStream(7, img);  // Ya guarda la foto en sql
            statement.setInt(8,((Distribuidor)cmbDistribuidor.getSelectionModel().getSelectedItem()).getDistribuidorId());
            statement.setInt(9, ((CategoriaProducto)cmbCategoria.getSelectionModel().getSelectedItem()).getCategoriaProductoId());
            statement.execute();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
   public void editarProducto() throws FileNotFoundException{
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            String sql = "call sp_EditarProducto(?,?,?,?,?,?,?,?,?,?)";
            statement = conexion.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(tfProductoId.getText()));
            statement.setString(2,tfNombre.getText());
            statement.setString(3,taDescripcion.getText());
            statement.setString(4, tfStock.getText());
            statement.setDouble(5,Double.parseDouble(tfPrecioVentaUnitario.getText()));     
            statement.setDouble(6,Double.parseDouble(tfPrecioVentaMayor.getText()));
            statement.setDouble(7,Double.parseDouble(tfPrecioCompra.getText()));
            InputStream img = new FileInputStream(files.get(0)); 
            statement.setBinaryStream(8, img);  
            statement.setInt(9,((Distribuidor)cmbDistribuidor.getSelectionModel().getSelectedItem()).getDistribuidorId());
            statement.setInt(10, ((CategoriaProducto)cmbCategoria.getSelectionModel().getSelectedItem()).getCategoriaProductoId());
            statement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(statement != null){
                    statement.close();
                }
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
       } 
   
   public ObservableList<Distribuidor> listarDistribuidores() {
    // Lista para almacenar los distribuidores
    ArrayList<Distribuidor> distribuidores = new ArrayList<>();
    
    Connection conexion = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        // Obtener conexión a la base de datos
        conexion = Conexion.getInstance().obtenerConexion();
        
        // Verifica que la conexión no sea nula
        if (conexion == null) {
            throw new SQLException("No se pudo obtener la conexión a la base de datos.");
        }

        // Consulta SQL para listar distribuidores
        String sql = "call sp_listarDistribuidores()";
        statement = conexion.prepareStatement(sql);
        resultSet = statement.executeQuery();

        // Recorrer los resultados de la consulta
        while (resultSet.next()) {
            int distribuidorId = resultSet.getInt("distribuidorId");
            String nombreDistribuidor = resultSet.getString("nombreDistribuidor");
            String direccionDistribuidor = resultSet.getString("direccionDistribuidor");
            String nitDistribuidor = resultSet.getString("nitDistribuidor");
            String telefonoDistribuidor = resultSet.getString("telefonoDistribuidor");
            String web = resultSet.getString("web");

            // Crear un objeto Distribuidor y agregarlo a la lista
            Distribuidor distribuidor = new Distribuidor(distribuidorId, nombreDistribuidor, direccionDistribuidor, nitDistribuidor, telefonoDistribuidor, web);
            distribuidores.add(distribuidor);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error en la consulta SQL: " + e.getMessage());
    } finally {
        // Cerrar los recursos en el bloque finally para asegurar que siempre se cierren
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }

    // Devolver la lista observable de distribuidores
    return FXCollections.observableList(distribuidores);
}
    //Listar para ComboBox Categoria
    public ObservableList<CategoriaProducto> listarCaregoria(){
        ArrayList<CategoriaProducto> categoriaProducto = new ArrayList<>();
        
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            String sql = "call sp_listarCategoriaProductos()";
            statement = conexion.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                int categoriaId = resultSet.getInt("categoriaProductosId");
                String nombreCategoria = resultSet.getString("nombreCategoria");
                String descripcionCategoria = resultSet.getString("descripcionCategoria");
                
                categoriaProducto.add(new CategoriaProducto(categoriaId,nombreCategoria,descripcionCategoria));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            
        }
        
        
        return FXCollections.observableList(categoriaProducto);
    }

    
    

    public Main getStage() {
        return stage;
    }

    public void setStage(Main stage) {
        this.stage = stage;
    }

    public void setOp(int op) {
        this.op = op;
    }
    
    
}