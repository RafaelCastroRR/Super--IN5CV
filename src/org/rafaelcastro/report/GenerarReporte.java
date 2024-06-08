/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rafaelcastro.report;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.rafaelcastro.dao.Conexion;
import win.zqxu.jrviewer.JRViewerFX;

/**
 *
 * @author Usuario
 */
public class GenerarReporte {
    
    private static GenerarReporte instace;
    private static Connection conexion = null ;

    private GenerarReporte() {      
        
        }
    
    public static GenerarReporte getInstace() {
        if (instace == null ){
            instace  = new GenerarReporte();
         }
        return instace;
        }
    
    public void generarFactura(int factId){
        try{
            // 1 abrir conexion a DB
            conexion = Conexion.getInstance().obtenerConexion();
            // 2 Defino los parametros del reporte
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("factId", factId);
            // 3 crear el reporte
            InputStream jasperPath = GenerarReporte.class.getResourceAsStream("/org/rafaelcastro/report/Factura.jasper");
            JasperPrint reporte = JasperFillManager.fillReport(jasperPath, parametros, conexion);
            // 4 Crear la ventana javafx para mostrar Reporte
            Stage reportStage = new Stage();
            // 5 Llenar el stage con el reporte
            JRViewerFX reportViewer = new JRViewerFX(reporte);
            Pane root = new Pane();
            root.getChildren().add(reportViewer);
            reportViewer.setPrefSize(1000, 800);
            Scene scene = new Scene(root);
            reportStage.setScene(scene);
            reportStage.setTitle("Factura");
            reportStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    
    
    public void generarClientes(){
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            
            Map<String, Object> parametros = new HashMap<>();
            Stage reportStage = new Stage();
            JasperPrint reporte = JasperFillManager.fillReport(GenerarReporte.class.getResourceAsStream("/org/rafaelcastro/report/Clientes.jasper"),parametros, conexion );
            JRViewerFX reportView = new JRViewerFX(reporte);
            Pane root = new Pane();
            root.getChildren().add(reportView);
            reportView.setPrefSize(1000,800);
            Scene scene = new Scene(root);
            reportStage.setScene(scene);
            reportStage.setTitle("Cliente");
            reportStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    } 


 
    

    
     

