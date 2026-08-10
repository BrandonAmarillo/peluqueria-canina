package com.mycompany.peluqueriacanina.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.excepciones.NonExistentEntityException;

public class ControladoraPersistencia {

    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    // ------ Mascota ------
    public void crearMascota(Mascota mascota) {
        mascotaJpa.create(mascota);
    }

    public void eliminarMascota(int id) {
        try {
            mascotaJpa.destroy(id);
        } catch (NonExistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarMascota(Mascota mascota) {
        try {
            mascotaJpa.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int id) {

        return mascotaJpa.findMascota(id);
    }

    public ArrayList<Mascota> traerListaMascotas() {

        List<Mascota> lista = mascotaJpa.findMascotaEntities();

        ArrayList<Mascota> listaMascotas = new ArrayList<Mascota>(lista);
        return listaMascotas;
    }

    // ------ Dueño ------
    public void crearDuenio(Duenio duenio) {
        duenioJpa.create(duenio);
    }

    public void eliminarDuenio(int id) {
        try {
            duenioJpa.destroy(id);
        } catch (NonExistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id) {
        return duenioJpa.findDuenio(id);
    }

    public ArrayList<Duenio> traerListaDuenios() {
        List<Duenio> lista = duenioJpa.findDuenioEntities();
        ArrayList<Duenio> listaDuenios = new ArrayList<Duenio>(lista);

        return listaDuenios;
    }
}
