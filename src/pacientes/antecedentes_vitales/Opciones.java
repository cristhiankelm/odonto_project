package pacientes.antecedentes_vitales;

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
        String sql = Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getId());
            ps.setString(2, uc.getPulso());
            ps.setString(3, uc.getPresion());
            ps.setString(4, uc.getTemperatura());
            ps.setString(5, uc.getFrecuencia_respiratoria());
            ps.setString(6, uc.getPeso());
            ps.setString(7, uc.getTalla());
            ps.setString(8, uc.getIndice_masa_corporal());
            ps.setString(9, uc.getTipo_sangre());
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
            ps.setString(1, uc.getPulso());
            ps.setString(2, uc.getPresion());
            ps.setString(3, uc.getTemperatura());
            ps.setString(4, uc.getFrecuencia_respiratoria());
            ps.setString(5, uc.getPeso());
            ps.setString(6, uc.getTalla());
            ps.setString(7, uc.getIndice_masa_corporal());
            ps.setString(8, uc.getTipo_sangre());
            ps.setInt(9, uc.getId());
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
