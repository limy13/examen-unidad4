import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Profesor extends Usuario {
    private String rfc;
    private double sueldo;
    private ArrayList<Materias> materiasImparte;

    public Profesor(String nombre, String apellidos, int anoNacimiento, String ciudad, String estado, String curp, String direccion, LocalDate fechaRegistro, String numeroControl, String rfc, double sueldo, ArrayList<Materias> materias, String nombreUsuario, String contrasena, Carreras carrera) {
        super(nombre, apellidos, anoNacimiento, ciudad, estado, curp, direccion, fechaRegistro, numeroControl, Rol.PROFESOR, nombreUsuario, contrasena, carrera);
        this.rfc = rfc;
        this.sueldo = sueldo;
        this.materiasImparte = materias;
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

    public ArrayList<Materias> getMateriasImparte() {
        return materiasImparte;
    }

    public void setMaterias(ArrayList<Materias> materias) {
        this.materiasImparte = materias;
    }

    public void verInformacionPersonal() {
        System.out.println("\n---- Información Personal ----\n");
        System.out.println("Nombre completo: " + this.getNombre() + " " + this.getApellidos());
        System.out.println("Fecha de nacimiento: " + this.getAnoNacimiento());
        System.out.println("Ciudad: " + this.getCiudad());
        System.out.println("Estado: " + this.getEstado());
        System.out.println("CURP: " + this.getCurp());
        System.out.println("Dirección: " + this.getDireccion());
        System.out.println("Fecha de registro: " + this.getFechaRegistro());
        System.out.println("Número de control: " + this.getNumeroControl());
        System.out.println("RFC: " + this.getRfc());
        System.out.println("Sueldo: " + this.getSueldo());
    }
}
