import java.time.LocalDate;
import java.util.List;

public class Profesor extends Usuario {
    private String rfc;
    private double sueldo;
    private List<Materia> materias;

    public Profesor(String nombre, String apellidos, int anoNacimiento, String ciudad, String estado, String curp, String direccion, LocalDate fechaRegistro, String numeroControl, String rfc, double sueldo, List<Materia> materias, String nombreUsuario, String contrasena, Carreras carrera) {
        super(nombre, apellidos, anoNacimiento, ciudad, estado, curp, direccion, fechaRegistro, numeroControl, Rol.PROFESOR, nombreUsuario, contrasena, carrera);
        this.rfc = rfc;
        this.sueldo = sueldo;
        this.materias = materias;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
