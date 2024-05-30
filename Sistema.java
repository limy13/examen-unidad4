import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sistema {
    Carrera Sistemas=new Carrera("Sistemas", "Programacion", "Probabilidad", "Calculo", null);
    Carrera Materiales=new Carrera("Materiales", "Estadistica", "Contabilidad", "Calculo", null);
    Carrera Electronica =new Carrera("Electronica","Redes", "Circuitos", "Calculo", null);

    public static final Map<Carreras, Map<Rol, ArrayList<Usuario>>> usuarios = new HashMap<>();
    public static Carreras carrera; //accede a la carrera de la persona que inicia sesion

    Usuario verificarInicioSesion(String nombreUsuario, String contraseña) { 
        // este metodo verifica en todas las listas que hay si existe el nombre de 
        // usuario y contraseña, si si lo retorna y si no, retorna un null

        for(Map<Rol, ArrayList<Usuario>> lista : usuarios.values()) {
            for(ArrayList<Usuario> usuariosList : lista.values()) {
                for(Usuario usuario : usuariosList) {
                    if(usuario.getNombreUsuario().equals(nombreUsuario)) {
                        if(usuario.getContrasena().equals(contraseña)) {
                            carrera = usuario.getCarrera();
                            return usuario;
                        }
                    }
                }
            }
        }              
        return null;
    }

}