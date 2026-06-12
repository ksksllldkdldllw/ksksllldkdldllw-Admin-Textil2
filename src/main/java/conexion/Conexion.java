package conexion;

import util.DatabaseMigrator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

    private static final String DB_FILE_NAME = "textil.db";
    private static boolean migracionesAplicadas = false;

  private Connection conectar = null;

    public Connection establecerConexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + obtenerRutaBaseDatos();
            conectar = DriverManager.getConnection(url);
            aplicarMigracionesSiNecesario(conectar);
            return conectar;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.toString());
            return null;
        }
    }

    public static String obtenerRutaBaseDatos() {
        String configurada = leerRutaDesdeConfig();
        if (configurada != null) {
            return configurada;
        }

        String userDir = System.getProperty("user.dir");
        File dbEnProyecto = new File(userDir, DB_FILE_NAME);
        if (dbEnProyecto.exists()) {
            return dbEnProyecto.getAbsolutePath();
        }

        try {
            String jarPath = Conexion.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath();

            File jarFile = new File(jarPath);
            if (jarFile.isFile()) {
                File dbJuntoJar = new File(jarFile.getParent(), DB_FILE_NAME);
                return dbJuntoJar.getAbsolutePath();
            }
        } catch (Exception ignored) {
        }

        return dbEnProyecto.getAbsolutePath();
    }

    private static String leerRutaDesdeConfig() {
        Properties props = new Properties();
        File config = new File(System.getProperty("user.dir"), "config.properties");
        if (!config.exists()) {
            return null;
        }

        try (FileInputStream fis = new FileInputStream(config)) {
            props.load(fis);
            String path = props.getProperty("db.path", "").trim();
            if (!path.isEmpty()) {
                return new File(path).getAbsolutePath();
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer config.properties: " + e.getMessage());
        }

        return null;
    }

    private static void aplicarMigracionesSiNecesario(Connection cn) throws SQLException {
        if (!migracionesAplicadas) {
            DatabaseMigrator.aplicarMigraciones(cn);
            migracionesAplicadas = true;
        }
    }
}
