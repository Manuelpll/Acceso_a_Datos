package Unidad_2;
import java.sql.*;
import java.util.Scanner;

public class Ejemplo9_InsertPreStatement {
    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/hospital";
        String usuario = "Mparr";
        String contraseña = "Password_123";


        Scanner scanner = new Scanner(System.in);


        System.out.print("Introduce el número de departamento (DEPT_NO): ");
        int deptNo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduce el nombre del departamento (DNOMBRE): ");
        String dnombre = scanner.nextLine();

        System.out.print("Introduce la localidad del departamento (LOC): ");
        String loc = scanner.nextLine();


        String sql = "INSERT INTO DEPT (DEPT_NO, DNOMBRE, LOC) VALUES (?, ?, ?)";

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Preparar la sentencia SQL
            PreparedStatement sentencia = conexion.prepareStatement(sql);


            sentencia.setInt(1, deptNo);
            sentencia.setString(2, dnombre);
            sentencia.setString(3, loc);


            int filas = sentencia.executeUpdate();
            System.out.println("Filas afectadas: " + filas);


            sentencia.close();
            conexion.close();
            scanner.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error en la conexión o en la ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
