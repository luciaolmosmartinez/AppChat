package um.tds.Main;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import um.tds.Modelado.Usuario;
import um.tds.Persistencia.AdaptadorUsuario;
import um.tds.Persistencia.DAOException;
import um.tds.Persistencia.FactoriaDAO;

public class DataLoader {

    public static void cargarDatosIniciales() {
        AdaptadorUsuario adaptadorU = null;
        try {
            adaptadorU = (AdaptadorUsuario) FactoriaDAO.getInstancia().getUsuarioDAO();
        } catch (DAOException e) {
        }
        List<Usuario> usuarios = adaptadorU.recuperarTodosUsuarios();

        if (usuarios.isEmpty()) {

            /*
             * CREDENCIALES PARA INICIAR SESIÓN EN LA CUENTA 
             * TELEFONO: 123456789
             * CONTRASEÑA: l
             */
            Usuario lucia = new Usuario("lucia om", "123456789", "l@um.es", "l".toCharArray(), LocalDate.of(2004, Month.JULY, 21), "", "");
            adaptadorU.registrarUsuario(lucia);

            /*
             * CREDENCIALES PARA INICIAR SESIÓN EN LA CUENTA 
             * TELEFONO: 987654321
             * CONTRASEÑA: a
             */
            Usuario ana = new Usuario("ana mg", "987654321", "a@um.es", "a".toCharArray(), LocalDate.of(2004, Month.MAY, 23), "Hola, me gusta leer", "");
            adaptadorU.registrarUsuario(ana);

            /*
             * CREDENCIALES PARA INICIAR SESIÓN EN LA CUENTA 
             * TELEFONO: 012345678
             * CONTRASEÑA: l
             */
            Usuario lucia2 = new Usuario("lucia om2", "012345678", "l2@um.es", "l".toCharArray(), LocalDate.of(2004, Month.JULY, 21), "", "");
            adaptadorU.registrarUsuario(lucia2);

            /*
             * CREDENCIALES PARA INICIAR SESIÓN EN LA CUENTA 
             * TELEFONO: 876543210
             * CONTRASEÑA: a
             */
            Usuario ana2 = new Usuario("ana mg2", "876543210", "a2@um.es", "a".toCharArray(), LocalDate.of(2004, Month.MAY, 23), "", "");
            adaptadorU.registrarUsuario(ana2);
        }
    }
}