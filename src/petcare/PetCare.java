/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package petcare;

/**
 *
 * @author Julian Lara
 */
public class PetCare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        Conector cn = new Conector();
        Vista view = new Vista();
        OperacionesModelo model = new OperacionesModelo();
        jPnVariables panelVariables = new jPnVariables();
        jPnRegistro panelRegistro = new jPnRegistro();
        jPnContabilidad panelContabilidad = new jPnContabilidad();
        jPnMascotas panelMascotas = new jPnMascotas();
        jPnPropietario panelPropietario = new jPnPropietario();
        
        Controlador ctrl = new Controlador(cn,model,view,panelVariables,panelRegistro,panelContabilidad,panelMascotas,panelPropietario);
        ctrl.start();
        view.setVisible(true);
    }

}
