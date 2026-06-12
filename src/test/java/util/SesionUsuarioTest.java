package util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class SesionUsuarioTest {

    @Test
    public void clienteDebeTenerPermisoParaVerCatalogo() {
        SesionUsuario.iniciar(1, "Cliente", "Prueba", "cliente", "cliente");

        assertTrue(SesionUsuario.esCliente());
        assertFalse(SesionUsuario.esAdministrador());
        assertFalse(SesionUsuario.esVendedor());
    }
}
