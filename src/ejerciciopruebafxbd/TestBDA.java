package ejerciciopruebafxbd;

import java.sql.*;

public class TestBDA {

    public static void main(String[] args) throws Exception {
        String bd = "parques";
        String login = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/" + bd;
        
        try (Connection conn = DriverManager.getConnection(url, login, password)) {

            //CONECTADOS CON LA BDA REFERENCIADA POR URL, CON EL USUARIO LOGIN Y SU PASSWORD
            if (conn != null) {
                System.out.println("Conexion a base de datos " + url + " ... OK");

            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
