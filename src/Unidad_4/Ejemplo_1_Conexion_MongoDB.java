package Unidad_4;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Ejemplo_1_Conexion_MongoDB {

        public static void main(String[] args) {
            // URL de conexión (ajústala según tu configuración)
            String uri = "mongodb://localhost:27017";

            try (MongoClient mongoClient = MongoClients.create(uri)) {
                // Obtener la base de datos
                MongoDatabase database = mongoClient.getDatabase("mibasededatos");
                // Mensaje de éxito
                System.out.println("Conectado a la base de datos: " + database.getName());
            } catch (Exception e) {
                System.out.println("Error de conexión: " + e.getMessage());
            }
        }
}
