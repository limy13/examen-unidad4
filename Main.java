import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Semestre semestre1 = new Semestre(1, new ArrayList<>());

        Alumno alumno1 = new Alumno("Juan", "Perez", 2000, "Morelia", "Michoacán", "JUPX000000HNEXXXA0", "Calle Falsa 123", LocalDate.now(), "lJ20ISC1", semestre1, grupoA, 0, new ArrayList<>(), "juanP", "juanP", Carreras.SISTEMAS);
        Profesor profesor1 = new Profesor("Maria", "Lopez", 1985, "Morelia", "Michoacán", "MALX850101MCMRXXA0", "Calle Verdadera 456", LocalDate.now(), "MP24ISC1", "RFC12345678", 15000.0, new ArrayList<>(), "mariaL", "mariaL", Carreras.MATERIALES);

        System.out.println("Alumno: " + alumno1.getNombre() + " " + alumno1.getApellidos() + ", Carrera: " + alumno1.getCarrera() + ", Rol: " + alumno1.getRol());
        System.out.println("Profesor: " + profesor1.getNombre() + " " + profesor1.getApellidos() + ", RFC: " + profesor1.getRfc() + ", Rol: " + profesor1.getRol());
    }
}
