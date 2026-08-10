package com.mycompany.peluqueriacanina.logica;

import java.util.ArrayList;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    // ------ Mascotas ------

    public void crearMascota(Mascota mascota) {
        controlPersis.crearMascota(mascota);
    }

    public void eliminarMascota(int id) {
        controlPersis.eliminarMascota(id);
    }

    public void editarMascota(Mascota mascota) {
        controlPersis.editarMascota(mascota);
    }

    public Mascota traerMascota(int id) {
        return controlPersis.traerMascota(id);
    }

    public ArrayList<Mascota> traerListaMascotas() {
        return controlPersis.traerListaMascotas();
    }

    // ------ Dueños ------
    public void crearDuenio(Duenio duenio) {
        controlPersis.crearDuenio(duenio);
    }

    public void eliminarDuenio(int id) {
        controlPersis.eliminarDuenio(id);
    }

    public void editarDuenio(Duenio duenio) {
        controlPersis.editarDuenio(duenio);
    }

    public Duenio traerDuenio(int id) {
        return controlPersis.traerDuenio(id);
    }

    public ArrayList<Duenio> traerListaDuenios() {
        return controlPersis.traerListaDuenios();
    }
}
