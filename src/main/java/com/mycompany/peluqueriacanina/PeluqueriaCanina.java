package com.mycompany.peluqueriacanina;

import javax.swing.SwingUtilities;

import com.mycompany.peluqueriacanina.gui.Interfaz;

public class PeluqueriaCanina {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            Interfaz gui = new Interfaz();
            gui.setVisible(true);
        });
    }
}