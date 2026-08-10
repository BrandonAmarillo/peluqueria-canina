package com.mycompany.peluqueriacanina;

import javax.swing.SwingUtilities;

import com.mycompany.peluqueriacanina.gui.Interfaz;
import com.mycompany.peluqueriacanina.logica.Controladora;

public class PeluqueriaCanina {
    public static void main(String[] args) {
        Controladora control = new Controladora();
        SwingUtilities.invokeLater(() -> {
            Interfaz gui = new Interfaz(control);
            gui.setVisible(true);
        });

    }
}