package com.mycompany.peluqueriacanina.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/*
    Interfaz gráfica de la peluquería canina con swing 
*/
public class Interfaz extends JFrame {
    // Campos del Perro
    private JLabel jlNumCliente;
    private JLabel jlNombrePerro;
    private JLabel jlRaza;
    private JLabel jlColor;
    private JLabel jlAlergico;
    private JLabel jlAtencionEspecial;

    private JTextField jtNumCliente;
    private JTextField jtNombrePerro;
    private JTextField jtRaza;
    private JTextField jtColor;
    private JComboBox<String> jcAlergico;
    private JComboBox<String> jcAtencionEspecial;

    // Campos del Dueño
    private JLabel jlObservaciones;
    private JLabel jlNombreDuenio;
    private JLabel jlTelefono;

    private JTextArea jtObservaciones;
    private JTextField jtNombreDuenio;
    private JTextField jtTelefono;

    // Botones
    private JButton btnLimpiar;
    private JButton btnGuardar;

    private JLabel jlLogo;

    // Constructor
    public Interfaz() {
        setTitle("Peluquería Canina");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Margen entre componentes
        gbc.anchor = GridBagConstraints.WEST;

        // Fila 0: NumCliente
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 0; // Fila 0
        jlNumCliente = new JLabel("Cliente Nº:");
        add(jlNumCliente, gbc);

        gbc.gridx = 1; // Columna 1
        gbc.gridy = 0; // Fila 0
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jtNumCliente = new JTextField(20);
        add(jtNumCliente, gbc);

        // Fila 1: NombrePerro
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 1; // Fila 1
        gbc.fill = GridBagConstraints.NONE;
        jlNombrePerro = new JLabel("Nombre:");
        add(jlNombrePerro, gbc);

        gbc.gridx = 1; // Columna 1
        gbc.gridy = 1; // Fila 1
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jtNombrePerro = new JTextField(20);
        add(jtNombrePerro, gbc);

        // Fila 2: Raza 
        gbc.gridx = 0; //Columna 0
        gbc.gridy = 2; // Fila 2
        gbc.fill = GridBagConstraints.NONE;
        jlRaza = new JLabel("Raza:");
        add(jlRaza, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jtRaza = new JTextField(20);
        add(jtRaza, gbc);

        // Fila 3: Color 
        gbc.gridx = 0; //Columna 0
        gbc.gridy = 3; // Fila 3
        gbc.fill = GridBagConstraints.NONE;
        jlColor = new JLabel("Color:");
        add(jlColor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jtColor = new JTextField(20);
        add(jtColor, gbc);

        // Fila 4: Alérgico 
        gbc.gridx = 0; //Columna 0
        gbc.gridy = 4; // Fila 4
        gbc.fill = GridBagConstraints.NONE;
        jlAlergico = new JLabel("Alérgico:");
        add(jlAlergico, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jcAlergico = new JComboBox<>();
        jcAlergico.setEditable(false);
        add(jcAlergico, gbc);

        // Fila 5: Atención Especial 
        gbc.gridx = 0; //Columna 0
        gbc.gridy = 5; // Fila 5
        gbc.fill = GridBagConstraints.NONE;
        jlAtencionEspecial = new JLabel("Atención Especial:");
        add(jlAtencionEspecial, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jcAtencionEspecial = new JComboBox<>();
        jcAtencionEspecial.setEditable(false);
        add(jcAtencionEspecial, gbc);

        // Fila 6: Nombre Dueño 
        gbc.gridx = 0; //Columna 0
        gbc.gridy = 6; // Fila 6
        gbc.fill = GridBagConstraints.NONE;
        jlNombreDuenio = new JLabel("Nombre Dueño:");
        add(jlNombreDuenio, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jtNombreDuenio = new JTextField(20);
        add(jtNombreDuenio, gbc);

        // Fila 7: Cel. Dueño 
        gbc.gridx = 0; //Columna 0
        gbc.gridy = 7; // Fila 7
        gbc.fill = GridBagConstraints.NONE;
        jlTelefono = new JLabel("Cel. Dueño:");
        add(jlTelefono, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jtTelefono = new JTextField(20);
        add(jtTelefono, gbc);

        // Fila 8: Observaciones 
        gbc.gridx = 0; //Columna 0
        gbc.gridy = 8; // Fila 8
        gbc.fill = GridBagConstraints.NONE;
        jlObservaciones = new JLabel("Observaciones:");
        add(jlObservaciones, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jtObservaciones = new JTextArea(5, 10);
        jtObservaciones.setLineWrap(true);
        add(jtObservaciones, gbc);


        // Carga y manejo de Imagenes
        try {
            ImageIcon logo = new ImageIcon(getClass().getResource("../../../imagenes/logo.png"));
            jlLogo = new JLabel(logo);
        } catch (Exception e) {
            jlLogo = new JLabel("[Imagen no disponible]", SwingConstants.CENTER);
        }
        gbc.gridx = 2; // Columna 2 (a la derecha de los campos)
        gbc.gridy = 0; // Empieza en la fila 0
        gbc.gridheight = 9; // Ocupa 9 filas (Todos los campos)
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 20, 5, 5); // Más margen izquierdo para separar
        add(jlLogo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.WEST;
        btnLimpiar = new JButton("Limpiar");
        add(btnLimpiar, gbc);

        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.EAST;
        btnGuardar = new JButton("Guardar");
        add(btnGuardar, gbc);
    }
}
