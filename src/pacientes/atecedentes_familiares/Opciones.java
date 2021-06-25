
package pacientes.atecedentes_familiares;

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
            ps.setInt   (1, uc.getId());
            ps.setString(2, uc.getHeredo_familiar());
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
            ps.setString(1, uc.getHeredo_familiar());
            ps.setInt   (2, uc.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return false;
    }

    public static boolean eliminar(Sentencias uc) {
        int rsu = 0;
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
