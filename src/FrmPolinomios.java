import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.fasterxml.jackson.core.type.TypeReference;

import entidades.Nodo;
import entidades.Operacion;
import entidades.Polinomio;
import servicios.Archivo;
import servicios.ServicioPolinomio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FrmPolinomios extends JFrame {

    private JComboBox cmbOperacion;
    private JComboBox cmbPolinomio;
    private JLabel lblCoeficiente;
    private JLabel lblX;
    private JLabel lblExponente;
    private JLabel lblPolinomio1;
    private JLabel lblPolinomio2;
    private JLabel lblPolinomioR;
    private JLabel lblPolinomioRD;
    private JTextField txtCoeficiente;
    private JTextField txtExponente;

    private String nombreArchivo = "";
    private List<Operacion> operaciones = new ArrayList<>();
    private String[] tiposOperaciones = new String[] { "Suma", "Resta", "Multiplicacion", "Division", "Derivada" };

    Polinomio p1 = new Polinomio();
    Polinomio p2 = new Polinomio();

    public FrmPolinomios() {
        lblCoeficiente = new JLabel();
        txtCoeficiente = new JTextField();
        lblX = new JLabel();
        lblExponente = new JLabel();
        txtExponente = new JTextField();
        cmbPolinomio = new JComboBox();
        JButton btnAgregar = new JButton();
        JButton btnLimpiar = new JButton();
        lblPolinomio1 = new JLabel();
        lblPolinomio2 = new JLabel();
        cmbOperacion = new JComboBox();
        lblPolinomioR = new JLabel();
        lblPolinomioRD = new JLabel();
        JButton btnCalcular = new JButton();
        JButton btnGuardar = new JButton();
        JButton btnCargar = new JButton();

        setSize(600, 450);
        setTitle("Polinomios");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblCoeficiente.setText("Coeficiente:");
        lblCoeficiente.setBounds(10, 60, 80, 25);
        getContentPane().add(lblCoeficiente);

        txtCoeficiente.setBounds(80, 60, 100, 25);
        getContentPane().add(txtCoeficiente);

        lblX.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        lblX.setText("x");
        lblX.setBounds(180, 40, 50, 40);
        getContentPane().add(lblX);

        lblExponente.setText("Exponente");
        lblExponente.setBounds(130, 20, 80, 25);
        getContentPane().add(lblExponente);

        txtExponente.setBounds(210, 20, 100, 25);
        getContentPane().add(txtExponente);

        cmbPolinomio.setModel(
                new DefaultComboBoxModel(new String[] { "Polinomio 1", "Polinomio 2" }));
        cmbPolinomio.setBounds(300, 50, 100, 25);
        getContentPane().add(cmbPolinomio);

        btnAgregar.setText("Agregar");
        btnAgregar.setBounds(410, 50, 80, 25);
        getContentPane().add(btnAgregar);

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAgregarClick(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBounds(500, 50, 80, 25);
        getContentPane().add(btnLimpiar);

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLimpiarClick(evt);
            }
        });

        lblPolinomio1.setBackground(new java.awt.Color(0, 153, 204));
        lblPolinomio1.setOpaque(true);
        lblPolinomio1.setBounds(0, 90, 600, 50);
        getContentPane().add(lblPolinomio1);

        lblPolinomio2.setBackground(new java.awt.Color(0, 153, 204));
        lblPolinomio2.setOpaque(true);
        lblPolinomio2.setBounds(0, 150, 600, 50);
        getContentPane().add(lblPolinomio2);

        btnCalcular.setText("Calcular");
        btnCalcular.setBounds(10, 210, 100, 25);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCalcularClick(evt);
            }
        });

        cmbOperacion.setModel(
                new DefaultComboBoxModel(tiposOperaciones));
        cmbOperacion.setBounds(120, 210, 100, 25);
        getContentPane().add(cmbOperacion);

        btnGuardar.setText("Guardar");
        btnGuardar.setBounds(230, 210, 100, 25);
        getContentPane().add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnGuardarClick();
            }
        });

        btnCargar.setText("Cargar");
        btnCargar.setBounds(340, 210, 100, 25);
        getContentPane().add(btnCargar);

        btnCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCargarClick();
            }
        });

        lblPolinomioR.setBackground(new java.awt.Color(255, 204, 153));
        lblPolinomioR.setOpaque(true);
        lblPolinomioR.setBounds(0, 250, 600, 50);
        getContentPane().add(lblPolinomioR);

        lblPolinomioR.setBackground(new java.awt.Color(255, 204, 153));
        lblPolinomioR.setOpaque(true);
        lblPolinomioR.setBounds(0, 250, 600, 50);
        getContentPane().add(lblPolinomioR);

        lblPolinomioRD.setBackground(new java.awt.Color(255, 153, 153));
        lblPolinomioRD.setOpaque(true);
        lblPolinomioRD.setBounds(0, 310, 600, 50);
        getContentPane().add(lblPolinomioRD);

    }

    private void btnAgregarClick(ActionEvent evt) {
        int exponente = Integer.parseInt(txtExponente.getText());
        int coeficiente = Integer.parseInt(txtCoeficiente.getText());
        Nodo nodo = new Nodo(exponente, coeficiente);
        switch (cmbPolinomio.getSelectedIndex()) {
            case 0:
                p1.agregar(nodo);
                p1.mostrar(lblPolinomio1);
                break;
            case 1:
                p2.agregar(nodo);
                p2.mostrar(lblPolinomio2);
                break;
        }
    }

    private void btnLimpiarClick(ActionEvent evt) {
        switch (cmbPolinomio.getSelectedIndex()) {
            case 0:
                p1.limpiar();
                p1.mostrar(lblPolinomio1);
                break;
            case 1:
                p2.limpiar();
                p2.mostrar(lblPolinomio2);
                break;
        }
    }

    private Polinomio calcular() {
        switch (cmbOperacion.getSelectedIndex()) {
            case 0: // suma
                return ServicioPolinomio.sumar(p1, p2);
            case 1: // resta
                return ServicioPolinomio.restar(p1, p2);
            case 2: // multiplicación
                return ServicioPolinomio.multiplicar(p1, p2);
            case 3: // Dividir
                return ServicioPolinomio.dividir(p1, p2);
            case 4://derivar
                return cmbPolinomio.getSelectedIndex() == 0 ? p1.getDerivada() : p2.getDerivada();
        }
        return new Polinomio();
    }

    private void btnCalcularClick(ActionEvent evt) {
        var pR = calcular();
        pR.mostrar(lblPolinomioR);
    }

    private void btnGuardarClick() {
        if (nombreArchivo.equals("")) {
            nombreArchivo = Archivo.elegirArchivo();
        }
        if (!nombreArchivo.equals("")) {
            var pR = calcular();
            var operacion = new Operacion(tiposOperaciones[cmbOperacion.getSelectedIndex()],
                    p1.toDTO(), p2.toDTO(), pR.toDTO());
            operaciones.add(operacion);

            Archivo.guardarJson(nombreArchivo, operaciones);
            JOptionPane.showMessageDialog(null, "Archivo guardado con exito");
        }
    }

    private void btnCargarClick() {
        nombreArchivo = Archivo.elegirArchivo();
        if (!nombreArchivo.equals("")) {
            operaciones = Archivo.leerJson(nombreArchivo, new TypeReference<List<Operacion>>() {
            });

            p1.fromDTO(operaciones.get(0).getPolinomio1());
            p2.fromDTO(operaciones.get(0).getPolinomio2());
            p1.mostrar(lblPolinomio1);
            p2.mostrar(lblPolinomio2);
        }
    }

}
