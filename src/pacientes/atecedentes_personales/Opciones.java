
package pacientes.atecedentes_personales;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rojeru San CL
 */
public class Opciones {

    static ConexionBD cc = new ConexionBD();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static boolean registrar(Sentencias uc) {
        int rsu = 0;
        String sql = Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getId());
            ps.setString(2, uc.getAlimentacion());
            ps.setString(3, uc.getHabitacion());
            ps.setString(4, uc.getHabitos_higienicos());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return false;
    }

    public static boolean actualizar(Sentencias uc) {
        String sql = Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);            
            ps.setString(1, uc.getAlimentacion());
            ps.setString(2, uc.getHabitacion());
            ps.setString(3, uc.getHabitos_higienicos());
            ps.setInt(4, uc.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return false;
    }

    public static boolean eliminar(Sentencias uc) {
        String sql = Sentencias.ELIMINAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return false;
    }

    public static boolean eliminarTodo() {
        int rsu = 0;
        String sql = Sentencias.ELIMINAR_TODO;

        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
            rsu++;
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return false;
    }
}