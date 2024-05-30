import java.time.LocalDate;

public class Coordinador extends Usuario {

    private String [] materias;
    private double sueldo;
    private String rfc;

    public Coordinador(String nombre, String apellidos, int anoNacimiento, String ciudad, String estado, String curp, String direccion, String numeroControl, String [] materias, double sueldo, String rfc, String nombreUsuario, String contrasena, Carreras carrera) {
        super(nombre, apellidos, anoNacimiento, ciudad, estado, curp, direccion, LocalDate.now(), numeroControl, Rol.COORDINADOR, nombreUsuario, contrasena, carrera);
        this.materias = materias;
        this.sueldo = sueldo;
        this.rfc = rfc;
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

    

    


}
