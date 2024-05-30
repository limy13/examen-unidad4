import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario {
    private Carreras carrera;
    private Semestre semestre;
    private Grupo grupo;
    private double promedio;
    private List<Materia> materia; 
    private List<Calificaciones> calificaciones; //verificar esta clase

    public Alumno(String nombre, String apellidos, int anoNacimiento, String ciudad, String estado, String curp, String direccion, LocalDate fechaRegistro, String numeroControl, Semestre semestre, Grupo grupo, double promedio, List<Calificaciones> calificaciones, String nombreUsuario, String contrasena, Carreras carrera) {
        super(nombre, apellidos, anoNacimiento, ciudad, estado, curp, direccion, LocalDate.now(), numeroControl, Rol.ALUMNO, nombreUsuario, contrasena, carrera);
        this.carrera = carrera;
        this.semestre = semestre;
        this.grupo = grupo;
        this.promedio = promedio;
        this.calificaciones = calificaciones;
    }

    public Carreras getCarrera() {
        return carrera;
    }

    public void setCarrera(Carreras carrera) {
        this.carrera = carrera;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public List<Calificaciones> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificaciones> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public static void registrarAlumno() {
        ArrayList<String> datosComun = datosComun(Rol.ALUMNO);
        String nombre = datosComun.get(0);

    }
}
