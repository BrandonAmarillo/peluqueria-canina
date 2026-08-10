package com.mycompany.peluqueriacanina.logica;

import java.util.ArrayList;
import java.util.List;

public class VerificacionCanina {
    
    public List<String> verificarMascota(int numCliente, String nombrePerro, String raza, String color, String observaciones, 
        String nombreDuenio, String telefono, String direccion, Controladora control) {

        List<String> errores = new ArrayList<String>();
        
        if (numCliente <= 0) {
            errores.add("Número Cliente: No puede ser un número menor o igual que cero.");
        }

        if(!control.traerListaMascotas().isEmpty() || control.traerListaMascotas() != null){
            for(Mascota mascota: control.traerListaMascotas()){
                if (mascota.getNumeroCliente() == numCliente) {
                    errores.add("Número Cliente: Número de cliente repetido.");
                }
             }
        }
        
        if (nombrePerro == null || nombrePerro.isEmpty()) {
            errores.add("Nombre del perro: El nombre del perro no puede estar vacío.");
        }

        if (raza == null || raza.isEmpty()) {
           errores.add("Raza: No se especifica la raza, en caso de que no conocerlo, dejarlo como Desconocido.");
        }

        if (color == null || color.isEmpty()) {
            errores.add("Color: No se especifica el color, en caso de no conocerlo, dejarlo como Desconocido.");
        }

        if(observaciones == null || observaciones.isEmpty()){
            errores.add("Observaciones: El campo de observaciones está vacío.");
        }

        if(nombreDuenio == null || nombreDuenio.isEmpty()){
            errores.add("Nombre Dueño: El nombre del dueño no puede estar vacío.");
        }

        if(telefono == null || telefono.isEmpty()){
            errores.add("Teléfono: El teléfono del dueño no puede estar vacío.");
        }

        if(direccion == null || direccion.isEmpty()){
            errores.add("Dirección: La dirección del dueño no puede estar vacío.");
        }

        return errores;
    }
}
