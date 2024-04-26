package org.rafaelcastro.dto;

import org.rafaelcastro.model.Cliente;

public class ClienteDTO {
   private static ClienteDTO instance;
   private Cliente cliente;
   
   private ClienteDTO(){
       
   }
   
   public static ClienteDTO getClienteDTO(){
       if(instance == null){
           instance = new ClienteDTO();
       }
       return instance;
   }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
