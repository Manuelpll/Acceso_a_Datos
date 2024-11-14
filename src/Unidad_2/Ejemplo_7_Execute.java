package Unidad_2;

import java.sql.*;

public class Ejemplo_7_Execute {
    public static void main(String[] args) throws
            ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection
                ("jdbc:mysql://localhost/hospital", "Mparr", "Password_123");
        String sql="SELECT * FROM Emp";
        Statement sentencia = conexion.createStatement();
        boolean valor = sentencia.execute(sql);
        if (valor) {
            ResultSet rs = sentencia.getResultSet();
            while (rs.next())
                System.out.printf("%d, %s, %s \n",
                        rs.getInt(1), rs.getString (2), rs.getString(3));
            rs.close();
        } else {
            int f = sentencia.getUpdateCount();
            System.out.printf("Filas afectadas:%d \n", f);
        }
        sentencia.close();
        conexion.close();
    }// Fin main
}
