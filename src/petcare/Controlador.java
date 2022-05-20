/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petcare;

import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel Moreno
 */
public class Controlador {

    private Conector cn;
    private Vista view;
    private OperacionesModelo model;
    private jPnVariables panelVariables;
    private jPnRegistro panelRegistro;
    private jPnContabilidad panelContabilidad;
    private jPnMascotas panelMascotas;
    private jPnPropietario panelPropietario;

    public Controlador(Conector cn, OperacionesModelo model, Vista view, jPnVariables pnVariables, jPnRegistro pnRegistro, jPnContabilidad pnContabilidad, jPnMascotas pnMascotas, jPnPropietario pnPropietario) {
        this.cn = cn;
        this.view = view;
        this.model = model;
        this.panelVariables = pnVariables;
        this.panelRegistro = pnRegistro;
        this.panelMascotas = pnMascotas;
        this.panelPropietario = pnPropietario;
        this.panelContabilidad = pnContabilidad;

        //Botones de navegacion
        this.view.btnCon.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnContabilidadActionPerformed(e);
            }
        });
        this.view.btnMas.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMascotasActionPerformed(e);
            }
        });
        this.view.btnProp.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPropietarioActionPerformed(e);
            }
        });
        this.view.btnVar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVariablesActionPerformed(e);
                panelVariables.listVariables.setVisible(false);
                panelVariables.btnAdd.setVisible(false);
                panelVariables.btnConsulta.setVisible(false);
                panelVariables.btnLimpiar.setVisible(false);
                panelVariables.btnMod.setVisible(false);
                panelVariables.txtServicio.setVisible(false);
                panelVariables.txtCosto.setVisible(false);
                panelVariables.lbCosto.setVisible(false);
                panelVariables.lbServicio.setVisible(false);
                panelVariables.txtNombre.setVisible(false);
                panelVariables.lbNombre.setVisible(false);
                panelVariables.txtRaza.setVisible(false);
                panelVariables.lbRaza.setVisible(false);
                panelVariables.cbAnimal.setVisible(false);
                panelVariables.lbAnimales.setVisible(false);
                panelVariables.btnDelete.setVisible(false);
            }
        });
        this.view.btnRes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRegistroActionPerformed(e);
            }
        });

        //Panel de Contabilidad
        // <editor-fold defaultstate="collapsed" desc="Funciones PanelPropietario">  
        this.panelPropietario.btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPanPropRegActionPerformed(e);
            }
        });
        this.panelPropietario.btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarDatosPropietario();
            }
        });
        this.panelPropietario.listPropietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosSeleccionadosPropietario();
            }
        });
        this.panelPropietario.btnModificar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatosPropietario();
            }
        });
        this.panelPropietario.btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarDatosPropietario();
            }
        });

        this.panelRegistro.listRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosSeleccionadosRegistro();
            }
        });
// </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Funciones PanelMascotas">  
        this.panelMascotas.cbAnimal.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                mostrarComboRaza(evt);
            }
        });
        this.panelMascotas.btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPanMasRegActionPerformed(e);
            }
        });
        this.panelMascotas.btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarDatosMascotas();
            }
        });
        this.panelMascotas.listMascotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosSeleccionadosMascotas();
            }
        });
        this.panelMascotas.btnModificar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatosMascotas();
            }
        });
        this.panelMascotas.btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarDatosMascotas();
            }
        });
// </editor-fold>    

        // <editor-fold defaultstate="collapsed" desc="Funciones PanelVariables"> 
        //Funciones Panel Variables
        this.panelVariables.cbTabla.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                cbItemChangedVariables(evt);

            }
        });
        //Funcion Animales
        this.panelVariables.btnMod.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatosVariables();
            }
        });
        this.panelVariables.btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarDatosVariables();
            }
        });
        this.panelVariables.btnAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPanVariablesRegActionPerformed(e);
            }
        });
        this.panelVariables.btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarDatosVar();
            }
        });
        this.panelVariables.listVariables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosSeleccionadosVariables();
            }
        });
        this.panelVariables.btnDelete.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                deleteRaza();
            }
        });
// </editor-fold>    

        this.panelRegistro.btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPanRegActionPerformed(e);
            }
        });
        this.panelRegistro.btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarDatosRegistro();
            }
        });
        this.panelRegistro.btnModificar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatosRegistro();
                buscarDatosRegistro();
            }
        });
        this.panelRegistro.btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFinalizar();
                buscarDatosRegistro();
            }
        });
        this.panelRegistro.cbPropietario.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                mostrarComboMascotaRegistro(evt);
            }
        });
        this.panelContabilidad.btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelContabilidad.tbContabilidad.setModel(mostrarContabilidad());
            }
        });
    }

    public void start() {
        view.setTitle("PetCare");
        view.setLocationRelativeTo(null);
        view.jPn.add(panelPropietario);
        panelPropietario.setVisible(true);
        cn = new Conector();
        cn.getConexion();
        cn.close();

    }

    // <editor-fold defaultstate="collapsed" desc="jFrameNavActions">   
    public void btnContabilidadActionPerformed(ActionEvent e) {
        cambioPanel("panelContabilidad");
    }

    public void btnVariablesActionPerformed(ActionEvent e) {

        panelVariables.cbAnimal.removeAllItems();
        cambioPanel("panelVariables");
        ArrayList<Map> datos = model.selectAnimales();

        for (Map a : datos) {
            panelVariables.cbAnimal.addItem(a.get("nombre").toString());
        }
        cambioPanel("panelVariables");
    }

    public void btnPropietarioActionPerformed(ActionEvent e) {
        cambioPanel("panelPropietario");
    }

    public void btnMascotasActionPerformed(ActionEvent e) {
        panelMascotas.cbPropietario.removeAllItems();
        panelMascotas.cbRaza.removeAllItems();;
        panelMascotas.cbAnimal.removeAllItems();;

        ArrayList<Map> datosProp = model.selectPropietarios();
        for (Map a : datosProp) {
            panelMascotas.cbPropietario.addItem(a.get("nombre").toString());
        }
        ArrayList<Map> datosAnimal = model.selectAnimales();
        for (Map a : datosAnimal) {
            panelMascotas.cbAnimal.addItem(a.get("nombre").toString());
        }

        cambioPanel("panelMascotas");
    }

    public void btnRegistroActionPerformed(ActionEvent e) {
        inicioRegistro();
        cambioPanel("panelRegistro");
    }

    private void cambioPanel(String p) {
        switch (p) {
            case "panelPropietario":
                view.jPn.add(panelPropietario);
                panelPropietario.setVisible(true);
                panelMascotas.setVisible(false);
                panelRegistro.setVisible(false);
                panelContabilidad.setVisible(false);
                panelVariables.setVisible(false);
                view.jPn.validate();
                break;
            case "panelMascotas":
                view.jPn.add(panelMascotas);
                panelPropietario.setVisible(false);
                panelMascotas.setVisible(true);
                panelRegistro.setVisible(false);
                panelContabilidad.setVisible(false);
                panelVariables.setVisible(false);
                view.jPn.validate();
                break;
            case "panelRegistro":
                view.jPn.add(panelRegistro);
                panelPropietario.setVisible(false);
                panelMascotas.setVisible(false);
                panelRegistro.setVisible(true);
                panelContabilidad.setVisible(false);
                panelVariables.setVisible(false);
                view.jPn.validate();
                break;
            case "panelContabilidad":
                view.jPn.add(panelContabilidad);
                panelPropietario.setVisible(false);
                panelMascotas.setVisible(false);
                panelRegistro.setVisible(false);
                panelContabilidad.setVisible(true);
                panelVariables.setVisible(false);
                view.jPn.validate();
                break;
            case "panelVariables":
                view.jPn.add(panelVariables);
                panelPropietario.setVisible(false);
                panelMascotas.setVisible(false);
                panelRegistro.setVisible(false);
                panelContabilidad.setVisible(false);
                panelVariables.setVisible(true);
                view.jPn.validate();
                break;

        }
    }
// </editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Create Read Update Propietario"> 
    public void btnPanPropRegActionPerformed(ActionEvent e) {
        String nombre = panelPropietario.txtPropietario.getText();
        String telefono = panelPropietario.txtTelefono.getText();
        model.insertPropietarios(nombre, telefono);
        buscarDatosPropietario();
    }

    public void buscarDatosPropietario() {
        ArrayList<Map> datos = model.selectPropietarios();
        DefaultListModel listModelo = new DefaultListModel();
        for (Map a : datos) {
            listModelo.add(0, a.get("nombre"));
        }
        panelPropietario.listPropietarios.setModel(listModelo);
    }

    public void datosSeleccionadosPropietario() {
        String txtNombre = panelPropietario.listPropietarios.getSelectedValue();
        ArrayList<Map> datos = model.selectPropietarios();
        for (Map a : datos) {
            if (txtNombre.contains(a.get("nombre").toString())) {
                Map selectDato = a;
                panelPropietario.txtPropietario.setText(selectDato.get("nombre").toString());
                panelPropietario.txtTelefono.setText(selectDato.get("telefono").toString());
            }
        }
    }

    public void actualizarDatosPropietario() {
        String txtNombre = panelPropietario.txtPropietario.getText();
        String txtTelefono = panelPropietario.txtTelefono.getText();
        int id = panelPropietario.listPropietarios.getSelectedIndex() + 1;
        model.updatePropietarios(txtNombre, txtTelefono, id);
        buscarDatosPropietario();
    }

    private void limpiarDatosPropietario() {
        buscarDatosPropietario();
        panelPropietario.txtPropietario.setText("");
        panelPropietario.txtTelefono.setText("");
        panelPropietario.txtPropietario.requestFocus();

    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Create Read Update Variables"> 
    //Panel Variables Create Read Update Animales
    private void cbItemChangedVariables(ItemEvent env) {

        String selectedItem = panelVariables.cbTabla.getSelectedItem().toString();
        panelVariables.listVariables.setVisible(true);
        panelVariables.btnAdd.setVisible(true);
        panelVariables.btnConsulta.setVisible(true);
        panelVariables.btnLimpiar.setVisible(true);
        panelVariables.btnMod.setVisible(true);
        panelVariables.btnDelete.setVisible(false);
        switch (selectedItem) {
            case "Servicios":

                panelVariables.txtServicio.setVisible(true);
                panelVariables.txtCosto.setVisible(true);
                panelVariables.lbCosto.setVisible(true);
                panelVariables.lbServicio.setVisible(true);
                panelVariables.txtNombre.setVisible(false);
                panelVariables.lbNombre.setVisible(false);
                panelVariables.txtRaza.setVisible(false);
                panelVariables.lbRaza.setVisible(false);
                panelVariables.cbAnimal.setVisible(false);
                panelVariables.lbAnimales.setVisible(false);
                break;
            case "Animales":
                panelVariables.txtServicio.setVisible(false);
                panelVariables.txtCosto.setVisible(false);
                panelVariables.lbCosto.setVisible(false);
                panelVariables.lbServicio.setVisible(false);
                panelVariables.txtNombre.setVisible(true);
                panelVariables.lbNombre.setVisible(true);
                panelVariables.txtRaza.setVisible(false);
                panelVariables.lbRaza.setVisible(false);
                panelVariables.cbAnimal.setVisible(false);
                panelVariables.lbAnimales.setVisible(false);
                break;
            case "Razas":
                panelVariables.txtServicio.setVisible(false);
                panelVariables.txtCosto.setVisible(false);
                panelVariables.lbCosto.setVisible(false);
                panelVariables.lbServicio.setVisible(false);
                panelVariables.txtNombre.setVisible(false);
                panelVariables.lbNombre.setVisible(false);
                panelVariables.txtRaza.setVisible(true);
                panelVariables.lbRaza.setVisible(true);
                panelVariables.cbAnimal.setVisible(true);
                panelVariables.lbAnimales.setVisible(true);
                panelVariables.btnDelete.setVisible(true);
                break;
        }

    }

    public void btnPanVariablesRegActionPerformed(ActionEvent e) {
        String selectedItem = panelVariables.cbTabla.getSelectedItem().toString();
        if (selectedItem.equals("Servicios")) {
            btnPanVarSerRegActionPerformed();
        } else if (selectedItem.equals("Animales")) {
            String nombre = panelVariables.txtNombre.getText();
            model.insertAnimales(nombre);
            buscarDatosVariables();
        } else {
            btnPanVarRazRegActionPerformed();
            buscarDatosVariables();
        }

    }

    public void buscarDatosVariables() {
        String selectedItem = panelVariables.cbTabla.getSelectedItem().toString();
        if (selectedItem.equals("Servicios")) {
            ArrayList<Map> datos = model.selectServicios();
            DefaultListModel listModelo = new DefaultListModel();
            for (Map a : datos) {
                listModelo.add(0, a.get("servicio"));
            }
            panelVariables.listVariables.setModel(listModelo);
        } else if (selectedItem.equals("Animales")) {
            ArrayList<Map> datos = model.selectAnimalesDesc();
            DefaultListModel listModelo = new DefaultListModel();
            for (Map a : datos) {
                listModelo.add(0, a.get("nombre"));
            }
            panelVariables.listVariables.setModel(listModelo);
        } else {
            int animalSelected = panelVariables.cbAnimal.getSelectedIndex() + 1;
            ArrayList<Map> datos = model.selectRazas(animalSelected);
            DefaultListModel listModelo = new DefaultListModel();
            for (Map a : datos) {
                listModelo.add(0, a.get("raza"));
            }
            panelVariables.listVariables.setModel(listModelo);
        }

    }

    public void datosSeleccionadosVariables() {
        String selectedItem = panelVariables.cbTabla.getSelectedItem().toString();
        if (selectedItem.equals("Servicios")) {
            String txtNombre = panelVariables.listVariables.getSelectedValue();
            ArrayList<Map> datos = model.selectServicios();
            for (Map a : datos) {
                if (txtNombre.contains(a.get("servicio").toString())) {
                    Map selectDato = a;
                    panelVariables.txtServicio.setText(selectDato.get("servicio").toString());
                    panelVariables.txtCosto.setText(selectDato.get("costo").toString());
                }
            }
        } else if (selectedItem.equals("Animales")) {
            String txtNombre = panelVariables.listVariables.getSelectedValue();
            ArrayList<Map> datos = model.selectAnimales();
            for (Map a : datos) {
                if (txtNombre.contains(a.get("nombre").toString())) {
                    Map selectDato = a;
                    panelVariables.txtNombre.setText(selectDato.get("nombre").toString());
                }
            }
        } else {
            String txtRaza = panelVariables.listVariables.getSelectedValue();
            int animalSelected = panelVariables.cbAnimal.getSelectedIndex() + 1;
            ArrayList<Map> datos = model.selectRazas(animalSelected);
            for (Map a : datos) {
                if (txtRaza.contains(a.get("raza").toString())) {
                    Map selectDato = a;
                    panelVariables.txtRaza.setText(selectDato.get("raza").toString());
                }
            }
        }

    }

    public void actualizarDatosVariables() {
        String selectedItem = panelVariables.cbTabla.getSelectedItem().toString();
        if (selectedItem.equals("Servicios")) {
            String txtNombre = panelVariables.txtServicio.getText();
            int txtCosto = Integer.parseInt(panelVariables.txtCosto.getText());
            int id = panelVariables.listVariables.getSelectedIndex() + 1;
            model.updateServicios(txtNombre, txtCosto, id);

        } else if (selectedItem.equals("Animales")) {
            String txtNombre = panelVariables.txtNombre.getText();
            int id = panelVariables.listVariables.getSelectedIndex() + 1;
            model.updateAnimales(txtNombre, id);

        } else {
            String txtRaza = panelVariables.txtRaza.getText();
            String selectedRaza = panelVariables.listVariables.getSelectedValue();
            int id_Animal = panelVariables.cbAnimal.getSelectedIndex() + 1;
            model.updateRazas(txtRaza, id_Animal, searchIdByName(selectedRaza));

        }
        limpiarDatosVar();
        buscarDatosVariables();
    }

    private void limpiarDatosVar() {
        buscarDatosPropietario();
        DefaultListModel listModel = (DefaultListModel) panelVariables.listVariables.getModel();
        listModel.removeAllElements();
        panelVariables.txtNombre.setText("");
        panelVariables.txtCosto.setText("");
        panelVariables.txtRaza.setText("");
        panelVariables.txtServicio.setText("");
    }

    //Panel Variables Create Read Update Razas
    public void btnPanVarRazRegActionPerformed() {
        int animal = panelVariables.cbAnimal.getSelectedIndex() + 1;
        String raza = panelVariables.txtRaza.getText();

        model.insertRazas(animal, raza);
        buscarDatosVariables();
    }

    public void buscarDatosVarRazas() {
        int animalSelected = panelVariables.cbAnimal.getSelectedIndex() + 1;
        ArrayList<Map> datos = model.selectRazas(animalSelected);
        DefaultListModel listModelo = new DefaultListModel();
        for (Map a : datos) {
            listModelo.add(0, a.get("raza"));
        }
        panelVariables.listVariables.setModel(listModelo);
    }

    private int searchIdByName(String raza) {

        int animalSelected = panelVariables.cbAnimal.getSelectedIndex() + 1;
        int res = -1;
        ArrayList<Map> datos = model.selectRazas(animalSelected);
        for (Map a : datos) {
            if (a.get("raza").toString().equals(raza)) {
                Map selectDato = a;
                res = Integer.parseInt(a.get("id").toString());
            }
        }
        return res;
    }

    private void deleteRaza() {

        String selectedName = panelVariables.listVariables.getSelectedValue().toString();
        int idDele = -1;
        ArrayList<Map> datos = model.selectRazasGen();
        for (Map a : datos) {
            if (a.get("raza").toString().equals(selectedName)) {
                idDele = Integer.parseInt(a.get("id").toString());
            }
        }
        System.out.println("Del" + idDele);
        model.deleteRazas(idDele);
        buscarDatosVariables();
    }

    //Panel Variables Create Read Update Servicio
    private void btnPanVarSerRegActionPerformed() {
        String servicio = panelVariables.txtServicio.getText();
        int costo = Integer.parseInt(panelVariables.txtCosto.getText());
        model.insertServicios(servicio, costo);
        buscarDatosVariables();
    }

    // </editor-fold>    
    // <editor-fold defaultstate="collapsed" desc="Create Read Update Mascotas">   
    public void btnPanMasRegActionPerformed(ActionEvent e) {
        String nomPropietario = panelMascotas.cbPropietario.getSelectedItem().toString();
        int idAnimal = panelMascotas.cbAnimal.getSelectedIndex() + 1;
        String raza = panelMascotas.cbRaza.getSelectedItem().toString();
        ArrayList<Map> datos = model.selectRazasEsp(idAnimal, raza);
        String nombreMas = panelMascotas.txtNombre.getText();
        int idRaza = -1;
        for (Map a : datos) {

            idRaza = Integer.parseInt(a.get("id").toString());
        }

        model.insertMascotas(nomPropToId(nomPropietario), idRaza, nombreMas);

        buscarDatosMascotas();
    }

    private int nomPropToId(String nom) {
        ArrayList<Map> datos = model.selectPropietarios();
        Map selectedData = null;
        for (Map a : datos) {
            if (nom.equals((a.get("nombre").toString()))) {
                selectedData = a;
            }
        }
        return Integer.parseInt(selectedData.get("id").toString());
    }

    public String idToPropietario(int id) {
        ArrayList<Map> datos = model.selectPropietarios();
        Map selectedData = null;
        for (Map a : datos) {
            if (id == Integer.parseInt(a.get("id").toString())) {
                selectedData = a;
            }
        }
        return selectedData.get("nombre").toString();
    }

    public String idToRaza(int id) {
        ArrayList<Map> datos = model.selectRazasGen(); //Select de razas
        Map selectedData = null;
        for (Map a : datos) {
            if (id == Integer.parseInt(a.get("id").toString())) {
                selectedData = a;
            }
        }
        String temp = selectedData.get("raza").toString();

        return temp;
    }

    private String RazaToAnimal(int id) {
        ArrayList<Map> datos = model.selectRazasGen(); //Select de razas
        Map selectedData = null;
        for (Map a : datos) {
            if (id == Integer.parseInt(a.get("id").toString())) {
                selectedData = a;
            }
        }
        String temp = selectedData.get("id_animales").toString();

        return temp;
    }

    private String idAnimalToAnimal(int id) {
        ArrayList<Map> datos = model.selectAnimales(); //Select de razas
        Map selectedData = null;
        for (Map a : datos) {
            if (id == Integer.parseInt(a.get("id").toString())) {
                selectedData = a;
            }
        }
        String temp = selectedData.get("nombre").toString();

        return temp;
    }

    public void buscarDatosMascotas() {

        ArrayList<Map> datos = model.selectMascotas();
        DefaultListModel listModelo = new DefaultListModel();
        for (Map a : datos) {
            String tempV = idAnimalToAnimal(Integer.parseInt(RazaToAnimal(Integer.parseInt(a.get("id_raza").toString()))));
            String tempX = idToRaza(Integer.parseInt(a.get("id_raza").toString()));
            String tempZ = idToPropietario(Integer.parseInt(a.get("id_propietario").toString()));
            String temp = a.get("id") + "-" + a.get("nombre") + "-" + tempZ + "-" + tempX + "-" + tempV;
            listModelo.add(0, temp);
        }
        panelMascotas.listMascotas.setModel(listModelo);
    }

    public void datosSeleccionadosMascotas() {
        String[] tempString = panelMascotas.listMascotas.getSelectedValue().toString().split("-");
        //ID-nombre-propietario-raza-ANIMAL
        int indexRaza = -1;
        int indexAnimal = -1;
        int indexProp = -1;
        for (int i = 0; i < panelMascotas.cbAnimal.getModel().getSize(); i++) {
            if (panelMascotas.cbAnimal.getModel().getElementAt(i).equals(tempString[4])) {
                indexAnimal = i;
            }

        }
        for (int i = 0; i < panelMascotas.cbRaza.getModel().getSize(); i++) {
            if (panelMascotas.cbAnimal.getModel().getElementAt(i).equals(tempString[3])) {
                indexRaza = i;
            }
        }
        for (int i = 0; i < panelMascotas.cbPropietario.getModel().getSize(); i++) {
            if (panelMascotas.cbPropietario.getModel().getElementAt(i).equals(tempString[2])) {
                indexProp = i;
            }
        }
        panelMascotas.txtNombre.setText(tempString[1]);
        panelMascotas.cbPropietario.setSelectedIndex(indexProp);
        panelMascotas.cbRaza.setSelectedIndex(indexRaza);
        panelMascotas.cbAnimal.setSelectedIndex(indexAnimal);
    }

    public void actualizarDatosMascotas() {
        String[] tempSplit = panelMascotas.listMascotas.getSelectedValue().split("-");
        String nom_propietario = panelMascotas.cbPropietario.getSelectedItem().toString();
        int idProp = -1;
        for (Map a : model.selectPropietarios()) {
            if (a.get("nombre").toString().equals(nom_propietario)) {
                idProp = Integer.parseInt(a.get("id").toString());
            }
        }
        String raza = panelMascotas.cbRaza.getSelectedItem().toString();
        int idRaza = -1;
        for (Map a : model.selectRazasGen()) {
            if (a.get("raza").toString().equals(raza)) {
                idRaza = Integer.parseInt(a.get("id").toString());
            }
        }
        String nombre = panelMascotas.txtNombre.getText();
        model.updateMascotas(idProp, idRaza, nombre, Integer.parseInt(tempSplit[0]));
        buscarDatosMascotas();

    }

    private void limpiarDatosMascotas() {
        buscarDatosMascotas();
        panelMascotas.txtNombre.setText("");
        buscarDatosMascotas();
    }

    private void mostrarComboRaza(ItemEvent e) {
        panelMascotas.cbRaza.removeAllItems();
        int itemSelected = panelMascotas.cbAnimal.getSelectedIndex() + 1;
        ArrayList<Map> datosRaza = model.selectRazas(itemSelected);
        for (Map a : datosRaza) {
            panelMascotas.cbRaza.addItem(a.get("raza").toString());
        }
    }
    // </editor-fold>  

    private void inicioRegistro() {
        panelRegistro.cbPropietario.removeAllItems();
        panelRegistro.cbServicio.removeAllItems();

        ArrayList<Map> datosProp = model.selectPropietarios();
        for (Map a : datosProp) {
            panelRegistro.cbPropietario.addItem(a.get("nombre").toString());
        }
        ArrayList<Map> datosSer = model.selectServicios();

        for (Map a : datosSer) {
            panelRegistro.cbServicio.addItem(a.get("servicio").toString());
        }

    }

    private String idToServicio(int id) {
        ArrayList<Map> datos = model.selectServicios();
        String strService = null;
        for (Map a : datos) {
            if (id == Integer.parseInt(a.get("id").toString())) {
                strService = a.get("servicio").toString();
                System.out.println("AV" + strService);
            }
        }
        return strService;
    }

    public void buscarDatosRegistro() {

        ArrayList<Map> datos = model.selectRegistrosNFinalizado();
        DefaultListModel listModelo = new DefaultListModel();
        for (Map a : datos) {
            System.out.println("a" + a);
            String propietario = idToPropietario(Integer.parseInt(a.get("id_propietario").toString()));
            String servicio = idToServicio(Integer.parseInt(a.get("id_servicio").toString()));
            String temp = a.get("id") + "-" + propietario + "-" + servicio + "-" + a.get("fech_ini") + "-" + a.get("id_mascota");
            listModelo.add(0, temp);
        }
        panelRegistro.listRegistro.setModel(listModelo);

    }

    public void datosSeleccionadosRegistro() {
        String[] tmpArray = panelRegistro.listRegistro.getSelectedValue().split("-");

        int indexProp = -1;
        int indexService = -1;
        int indexMascota = -1;
        for (int i = 0; i < panelRegistro.cbPropietario.getModel().getSize(); i++) {
            if (panelRegistro.cbPropietario.getModel().getElementAt(i).equals(tmpArray[1])) {
                indexProp = i;
            }

        }
        for (int i = 0; i < panelRegistro.cbServicio.getModel().getSize(); i++) {
            if (panelRegistro.cbServicio.getModel().getElementAt(i).equals(tmpArray[2])) {
                indexService = i;
            }
        }

        for (int i = 0; i < panelRegistro.cbMascota.getModel().getSize(); i++) {
            String[] tempArray = panelRegistro.cbMascota.getModel().getElementAt(i).split("-");
            if (tempArray[0].equals(tmpArray[4])) {
                indexMascota = i;
            }
        }

        panelRegistro.cbPropietario.setSelectedIndex(indexProp);
        panelRegistro.cbMascota.setSelectedIndex(indexMascota);
        panelRegistro.cbServicio.setSelectedIndex(indexService);

    }

    public void actualizarDatosRegistro() {
        String[] tmp = panelRegistro.listRegistro.getSelectedValue().split("-");
        String propietario = panelRegistro.cbPropietario.getSelectedItem().toString();
        int idProp = -1;
        for (Map a : model.selectPropietarios()) {
            if (a.get("nombre").toString().equals(propietario)) {
                idProp = Integer.parseInt(a.get("id").toString());
            }
        }
        int idSer = -1;
        String servicio = panelRegistro.cbServicio.getSelectedItem().toString();
        for (Map a : model.selectServicios()) {
            if (a.get("servicio").toString().equals(servicio)) {
                idSer = Integer.parseInt(a.get("id").toString());
            }
        }
        String[] nom = panelRegistro.cbMascota.getSelectedItem().toString().split("-");
        model.updateRegistro(idProp, idSer, Integer.parseInt(nom[0]), Integer.parseInt(tmp[0]));
        buscarDatosRegistro();
    }

    private void limpiarDatosRegistro() {
        buscarDatosPropietario();
        DefaultListModel listModel = (DefaultListModel) panelVariables.listVariables.getModel();
        listModel.removeAllElements();
        panelVariables.txtNombre.setText("");
        panelVariables.txtCosto.setText("");
        panelVariables.txtRaza.setText("");
        panelVariables.txtServicio.setText("");
    }

    public void btnPanRegActionPerformed(ActionEvent e) {
        ArrayList<Map> datos = model.selectPropietarios();
        String nomPersona = panelRegistro.cbPropietario.getSelectedItem().toString();
        Map selectedData = null;
        int idProp = -1;
        for (Map a : datos) {
            if (nomPersona.equals((a.get("nombre").toString()))) {
                selectedData = a;
                idProp = Integer.parseInt(selectedData.get("id").toString());
            }
        }
        ArrayList<Map> datosSer = model.selectServicios();
        String nomServicio = panelRegistro.cbServicio.getSelectedItem().toString();
        int idServicio = -1;
        Map selectedDataSer = null;
        for (Map a : datosSer) {
            if (nomServicio.equals((a.get("servicio").toString()))) {
                selectedDataSer = a;
                idServicio = Integer.parseInt(selectedDataSer.get("id").toString());
            }
        }

        String[] nom = panelRegistro.cbMascota.getSelectedItem().toString().split("-");
        model.insertRegistro(idProp, idServicio, Integer.parseInt(nom[0]));
        buscarDatosRegistro();
    }

    private void btnFinalizar() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fecha = sdf.format(new Date());
        System.out.println(fecha); // 27/01/2016
        String[] temp = panelRegistro.listRegistro.getSelectedValue().split("-");
        model.updateRegistroFechFin(fecha, Integer.parseInt(temp[0]));
        String selectItemServ = panelRegistro.cbServicio.getSelectedItem().toString();
        ArrayList<Map> datos = model.selectServicios();
        int idService = -1;
        for (Map a : datos) {
            if (a.get("servicio").equals(selectItemServ)) {
                idService = Integer.parseInt(a.get("id").toString());
            }
        }
        int price = calcular(temp[3], fecha, temp[2], Integer.parseInt(temp[4]));
        model.insertContabilidad(idService, price);
        buscarDatosRegistro();
    }

    private int calcular(String dateIni, String dateFin, String servicio, int id_raza) {
        char size = '-';
        int costoEstetica = 0;
        int costoGuarderia = 0;
        ArrayList<Map> datos = model.selectServicios();
        for (Map a : datos) {
            if (a.get("servicio").equals("Estetica")) {
                costoEstetica = Integer.parseInt(a.get("costo").toString());
            }
            if (a.get("servicio").equals("Guarderia")) {
                costoGuarderia = Integer.parseInt(a.get("costo").toString());
            }
        }

        double COSTOANIMALESPEQUEÑOS = 0.25;
        double COSTOANIMALESMEDIANOS = 0.5;
        int COSTOANIMALESGRANDES = 1;
        double totalPrice = 0;
        if (id_raza == 1 || id_raza == 2) {
            size = 'M';
        } else if (id_raza == 3 || id_raza == 4) {
            size = 'P';

        } else if (id_raza == 5) {
            size = 'G';
        }

        switch (servicio) {
            case "Guarderia":
                String[] tmpDateI1 = dateIni.split(" ");

                String[] tmpDateI2AMD = tmpDateI1[0].split("/");
                String[] tmpDateI3HMS = tmpDateI1[1].split(":");
                String[] tmpDateF1 = dateFin.split(" ");
                String[] tmpDateF2AMD = tmpDateF1[0].split("-");
                String[] tmpDateF3HMS = tmpDateF1[1].split(":");

                int diffPeriodo = (Integer.parseInt(tmpDateF2AMD[0]) - Integer.parseInt(String.valueOf(tmpDateI2AMD[0].toString()))) * 525600;
                int diffMes = (Integer.parseInt(tmpDateF2AMD[1]) - Integer.parseInt(String.valueOf(tmpDateI2AMD[1].toString()))) * 43800;
                int diffDia = (Integer.parseInt(tmpDateF2AMD[2]) - Integer.parseInt(String.valueOf(tmpDateI2AMD[2].toString()))) * 1440;
                int diffHora = (Integer.parseInt(tmpDateF3HMS[0]) - Integer.parseInt(String.valueOf(tmpDateI3HMS[0].toString()))) * 60;
                int diffMin = Integer.parseInt(tmpDateF3HMS[1]) - Integer.parseInt(String.valueOf(tmpDateI3HMS[1].toString()));
                double diffSg = (Integer.parseInt(tmpDateF3HMS[2]) - Integer.parseInt(String.valueOf(tmpDateI3HMS[2].toString()))) * 0.01666667;
                System.out.println("a" + diffSg);
                double diffMinTot = diffPeriodo + diffMes + diffDia + diffHora + diffMin + diffSg;
                switch (size) {
                    case 'M':
                        totalPrice = costoGuarderia + diffMinTot * COSTOANIMALESMEDIANOS;
                        break;
                    case 'P':
                        totalPrice = costoGuarderia + diffMinTot * COSTOANIMALESPEQUEÑOS;
                        break;
                    case 'G':
                        totalPrice =costoGuarderia + diffMinTot * COSTOANIMALESGRANDES;
                        break;
                }
                break;
            case "Estetica":
                switch (size) {
                    case 'M':
                        totalPrice = costoEstetica + costoEstetica * COSTOANIMALESMEDIANOS;
                        break;
                    case 'P':
                        totalPrice = costoEstetica + costoEstetica * COSTOANIMALESPEQUEÑOS;
                        break;
                    case 'G':
                        totalPrice = costoEstetica + costoEstetica * COSTOANIMALESGRANDES;
                        break;
                }
                break;

        }
        return (int) totalPrice;

    }

    private void mostrarComboMascotaRegistro(ItemEvent e) {
        panelRegistro.cbMascota.removeAllItems();
        String itemSelected = panelRegistro.cbPropietario.getSelectedItem().toString();

        ArrayList<Map> datosRaza = model.selectMascotasByUser(nomPropToId(itemSelected));
        for (Map a : datosRaza) {
            String tmpStr = a.get("id") + "-" + idToRaza(Integer.parseInt(a.get("id_raza").toString())) + "-" + a.get("nombre");
            panelRegistro.cbMascota.addItem(tmpStr);
        }
    }

    public DefaultTableModel mostrarContabilidad() {
        String[] nombresColumnas = {"id", "Servicio", "costo"};
        String[] registros = new String[3];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT * FROM contabilidad";

        Connection con = null;

        PreparedStatement pst = null;

        ResultSet rs = null;

        try {
            con = cn.getConexion();

            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                ArrayList<Map> datosSer = model.selectServicios();
                String tempNameService = null;
                for (Map a : datosSer) {
                    if (a.get("id").equals(String.valueOf(rs.getInt("id_servicio")))) {

                        tempNameService = a.get("servicio").toString();

                    }
                }
                registros[0] = String.valueOf(rs.getInt("id"));

                registros[1] = tempNameService;

                registros[2] = String.valueOf(rs.getInt("costo"));

                modelo.addRow(registros);

            }

        } catch (SQLException e) {

            System.out.println("Error al conectar");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pst != null) {
                    pst.close();
                }

                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return modelo;
    }
}
