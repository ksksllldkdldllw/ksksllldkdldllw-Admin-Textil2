package util;

public final class SesionUsuario {

    private static int id;
    private static String nombre;
    private static String apellido;
    private static String usuario;
    private static String rol;

    private SesionUsuario() {
    }

    public static void iniciar(int idUsuario, String nombreUsuario, String apellidoUsuario,
            String nombreLogin, String rolUsuario) {
        id = idUsuario;
        nombre = nombreUsuario;
        apellido = apellidoUsuario;
        usuario = nombreLogin;
        rol = normalizarRol(rolUsuario);
    }

    public static void cerrar() {
        id = 0;
        nombre = null;
        apellido = null;
        usuario = null;
        rol = null;
    }

    public static int getId() {
        return id;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static String getRol() {
        return rol;
    }

    public static String getNombreCompleto() {
        if (nombre == null) {
            return "";
        }
        if (apellido == null || apellido.isBlank()) {
            return nombre;
        }
        return nombre + " " + apellido;
    }

    private static String normalizarRol(String valor) {
        return valor == null ? null : valor.trim();
    }

    public static boolean esAdministrador() {
        return "Administrador".equalsIgnoreCase(normalizarRol(rol));
    }

    public static boolean esVendedor() {
        return "Vendedor".equalsIgnoreCase(normalizarRol(rol));
    }

    public static boolean esCliente() {
        return "Cliente".equalsIgnoreCase(normalizarRol(rol));
    }
}
