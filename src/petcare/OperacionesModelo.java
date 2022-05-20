/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petcare;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class OperacionesModelo {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    //Insert Statements
    private static String SQL_Insert_TAnimales = "Insert into animales(nombre) values (?)";
    private static String SQL_Insert_TContabilidad = "Insert into contabilidad(id_servicio,costo) values (?,?)";
    private static String SQL_Insert_TMascotas = "Insert into mascotas(id_propietario,id_raza,nombre) values (?,?,?);";
    private static String SQL_Insert_TPropietarios = "Insert into propietarios(nombre, telefono) values (?,?)";
    private static String SQL_Insert_TRazas = "Insert into razas(id_animales,raza) values (?,?)";
    private static String SQL_Insert_TRegistro = "Insert into registro(id_propietario,id_servicio,id_mascota) values (?,?,?)";
    private static String SQL_Insert_TServicio = "Insert into servicios(servicio,costo) values (?,?)";
    //Update Statements
    private static String SQL_Update_TAnimales = "UPDATE ANIMALES SET NOMBRE = ? WHERE ID = ?";
    private static String SQL_Update_TContabilidad = "UPDATE CONTABILIDAD SET ID_SERVICIO = ?, COSTO = ?  WHERE ID = ? ";
    private static String SQL_Update_TMascotas = "UPDATE MASCOTAS SET ID_PROPIETARIO = ?, ID_RAZA = ? , NOMBRE = ? WHERE ID = ?";
    private static String SQL_Update_TPropietarios = "UPDATE PROPIETARIOS SET NOMBRE = ?, TELEFONO = ? WHERE ID = ?";
    private static String SQL_Update_TRazas = "UPDATE RAZAS SET RAZA = ?, ID_ANIMALES = ?  WHERE ID = ? ";
    private static String SQL_Update_TRegistro = "UPDATE REGISTRO SET ID_PROPIETARIO = ?, ID_SERVICIO = ? , ID_MASCOTA = ? WHERE ID = ?";
    private static String SQL_Update_TRegistroFechFin = "UPDATE REGISTRO SET FECH_FIN = ?, FINALIZAR = 1  WHERE ID = ?";
    private static String SQL_Update_TServicio = "UPDATE SERVICIOS SET SERVICIO  = ?, COSTO  = ? WHERE ID = ?";

    //Delete Statements
    private static String SQL_Delete_TRazas = "Delete from Razas where id = ?";

// </editor-fold>   
    private PreparedStatement PS;
    Conector cn;
    ResultSet rs;

    public OperacionesModelo() {
        PS = null;
        cn = new Conector();
    }

    public int insertAnimales(String nombre) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Insert_TAnimales);
            PS.setString(1, nombre);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error guardando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int insertContabilidad(int idService, int costo) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Insert_TContabilidad);
            PS.setInt(1, idService);
            PS.setInt(2, costo);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error guardando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int insertMascotas(int idPropietario, int idRaza, String nombre) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Insert_TMascotas);
            PS.setInt(1, idPropietario);
            PS.setInt(2, idRaza);
            PS.setString(3, nombre);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error guardando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int insertPropietarios(String nombre, String telefono) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Insert_TPropietarios);
            PS.setString(1, nombre);
            PS.setString(2, telefono);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error guardando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int insertRazas(int idAnimal, String raza) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Insert_TRazas);
            PS.setInt(1, idAnimal);
            PS.setString(2, raza);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error guardando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int insertRegistro(int id_propietario, int id_servicio, int id_mascota) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Insert_TRegistro);
            PS.setInt(1, id_propietario);
            PS.setInt(2, id_servicio);
            PS.setInt(3, id_mascota);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error guardando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int insertServicios(String servicio, int costo) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Insert_TServicio);
            PS.setString(1, servicio);
            PS.setInt(2, costo);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error guardando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int updateAnimales(String nombre, int id) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Update_TAnimales);
            PS.setString(1, nombre);
            PS.setInt(2, id);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error actualizando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int updateContabilidad(int id_servicio, int costo, int id) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Update_TContabilidad);
            PS.setInt(1, id_servicio);
            PS.setInt(2, costo);
            PS.setInt(3, id);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error actualizando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int updateMascotas(int id_propietario, int id_raza, String nombre, int id) {
        int res = 0;

        try {
            PS = cn.getConexion().prepareStatement(SQL_Update_TMascotas);
            PS.setInt(1, id_propietario);
            PS.setInt(2, id_raza);
            PS.setString(3, nombre);
            PS.setInt(4, id);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error actualizando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int updatePropietarios(String nom, String telefono, int id) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Update_TPropietarios);
            PS.setString(1, nom);
            PS.setString(2, telefono);
            PS.setInt(3, id);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error actualizando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int updateRazas(String raza, int id_animal, int id) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Update_TRazas);
            PS.setString(1, raza);
            PS.setInt(2, id_animal);
            PS.setInt(3, id);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error actualizando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int updateRegistro(int id_prop, int id_service, int id_mascota, int id) {
        int res = 0;
        //ID_PROPIETARIO = ?, ID_SERVICIO = ?, FECH_INI = ?, FECH_FIN = ?  WHERE ID = ?
        try {
            PS = cn.getConexion().prepareStatement(SQL_Update_TRegistro);
            PS.setInt(1, id_prop);
            PS.setInt(2, id_service);
            PS.setInt(3, id_mascota);
            PS.setInt(4, id);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error actualizando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int updateRegistroFechFin(String fech_fin, int id) {
        int res = 0;
        //ID_PROPIETARIO = ?, ID_SERVICIO = ?, FECH_INI = ?, FECH_FIN = ?  WHERE ID = ?
        try {
            PS = cn.getConexion().prepareStatement(SQL_Update_TRegistroFechFin);
            PS.setString(1, fech_fin);
            PS.setInt(2, id);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error actualizando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public int updateServicios(String servicio, int costo, int id) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Update_TServicio);
            PS.setString(1, servicio);
            PS.setInt(2, costo);
            PS.setInt(3, id);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error actualizando" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Conexión cerrada");
        }

        return res;
    }

    public ArrayList<Map> selectPropietarios() {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        try {
            PS = cn.getConexion().prepareStatement("Select * from propietarios order by id desc");
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("nombre", rs.getString(2));
                mpProp.put("telefono", rs.getString(3));
                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }

        return arrayListProp;
    }

    public ArrayList<Map> selectMascotas() {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        try {
            PS = cn.getConexion().prepareStatement("Select * from mascotas order by id desc");
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("id_propietario", String.valueOf(rs.getInt(2)));
                mpProp.put("id_raza", String.valueOf((rs.getInt(3))));
                mpProp.put("nombre", rs.getString(4));
                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }

        return arrayListProp;
    }

    public ArrayList<Map> selectMascotasByUser(int id_user) {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        try {
            PS = cn.getConexion().prepareStatement("Select * from mascotas where id_propietario = ? order by id desc");
            PS.setInt(1, id_user);
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("id_propietario", String.valueOf(rs.getInt(2)));
                mpProp.put("id_raza", String.valueOf((rs.getInt(3))));
                mpProp.put("nombre", rs.getString(4));
                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }

        return arrayListProp;
    }

    public ArrayList<Map> selectRegistros() {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        try {
            PS = cn.getConexion().prepareStatement("Select * from registro order by id desc");
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("nombre", rs.getString(2));
                mpProp.put("telefono", rs.getString(3));
                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }

        return arrayListProp;
    }

    public ArrayList<Map> selectRegistrosNFinalizado() {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dateToStr = dateFormat.format(date);
        try {
            PS = cn.getConexion().prepareStatement("Select * from registro where finalizar = 0 order by id desc");
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("id_propietario", String.valueOf(rs.getInt(2)));
                mpProp.put("id_servicio", String.valueOf(rs.getInt(3)));
                mpProp.put("fech_ini", dateFormat.format(rs.getTimestamp(4)));
                mpProp.put("id_mascota", String.valueOf(rs.getInt(7)));

                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }
        return arrayListProp;
    }

    public ArrayList<Map> selectContabilidad() {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        try {
            PS = cn.getConexion().prepareStatement("Select * from propietarios order by id desc");
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("nombre", rs.getString(2));
                mpProp.put("telefono", rs.getString(3));
                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }

        return arrayListProp;
    }

    public ArrayList<Map> selectAnimales() {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        try {
            PS = cn.getConexion().prepareStatement("Select * from animales order by id ");
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("nombre", rs.getString(2));
                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }

        return arrayListProp;
    }

    public ArrayList<Map> selectAnimalesDesc() {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        try {
            PS = cn.getConexion().prepareStatement("Select * from animales order by id desc");
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("nombre", rs.getString(2));
                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }

        return arrayListProp;
    }

    public ArrayList<Map> selectRazas(int animal) {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        try {
            PS = cn.getConexion().prepareStatement("Select * from razas where id_animales = ? order by id desc");
            PS.setInt(1, animal);
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("id_animales", rs.getString(2));
                mpProp.put("raza", rs.getString(3));
                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }

        return arrayListProp;
    }

    public ArrayList<Map> selectRazasEsp(int animal, String raza) {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        try {
            PS = cn.getConexion().prepareStatement("SELECT * FROM razas where id_animales = ? and raza = ? ");
            PS.setInt(1, animal);
            PS.setString(2, raza);
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("id_animales", rs.getString(2));
                mpProp.put("raza", rs.getString(3));
                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }

        return arrayListProp;
    }

    public ArrayList<Map> selectRazasGen() {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        try {
            PS = cn.getConexion().prepareStatement("SELECT * FROM razas");
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("id_animales", rs.getString(2));
                mpProp.put("raza", rs.getString(3));
                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }

        return arrayListProp;
    }

    public ArrayList<Map> selectServicios() {
        ArrayList<Map> arrayListProp = new ArrayList<Map>();
        try {
            PS = cn.getConexion().prepareStatement("Select * from servicios order by id desc");
            rs = PS.executeQuery();
            while (rs.next()) {
                Map<String, String> mpProp = new HashMap<String, String>();
                mpProp.put("id", String.valueOf(rs.getInt(1)));
                mpProp.put("servicio", rs.getString(2));
                mpProp.put("costo", rs.getString(3));
                arrayListProp.add(mpProp);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando " + e);
        } finally {
            PS = null;
            cn.close();
            rs = null;
            System.out.println("Conexión cerrada");
        }

        return arrayListProp;
    }

    public int deleteRazas(int id_raza) {
        int res = 0;
        try {
            PS = cn.getConexion().prepareStatement(SQL_Delete_TRazas);
            PS.setInt(1, id_raza);
            res = PS.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error de eliminacion" + e);
        } finally {
            PS = null;
            cn.close();
            System.out.println("Eliminacion realizada!");
        }

        return res;
    }

    
}
