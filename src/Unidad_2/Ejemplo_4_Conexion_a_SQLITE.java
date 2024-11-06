package Unidad_2;

import java.sql.*;

public class Ejemplo_4_Conexion_a_SQLITE {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Connection conexion = Conectar();
          Statement statement= (Statement) conexion;
         hacerConsulta(statement);
         cerrar(conexion, statement);
    }

    public static Connection Conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conexion = DriverManager.getConnection("jbdc:sqlite:D:/DB/SQLITE/ejemplo.db");
        return conexion;
    }

    private static Statement crearStatement(Connection con) {
        try {
            return con.createStatement();
        } catch (SQLException e) {
            System.out.println("Error al crear el statement: " + e.getMessage());
            return null;
        }
    }
    private static void hacerConsulta(Statement instruccion) {
        try {
            String consulta = "SELECT * FROM departamento";
            ResultSet resultado = instruccion.executeQuery(consulta);
            while (resultado.next()) {
                System.out.println("------------------");
                int dep_no = resultado.getInt("idnota");
                System.out.println("Id dep_no la nota: "+ dep_no);
                String dnombre = resultado.getString("dnombre");
                System.out.println("Nombre dep_no la asignatura: "+dnombre);
                String loc = resultado.getString("loc");
                System.out.println("Nota: "+loc);
                System.out.println("------------------");
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error al hacer la consulta: " + e.getMessage());
        }
    }
    private static void cerrar(Connection con, Statement instruccion) {
        try {
            instruccion.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

