import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario {
    private Carreras carrera;
    private Semestre semestre;
    private Grupo grupo;
    private double promedio;
    private List<Materia> materias; 
    private List<Calificaciones> calificaciones; //verificar esta clase

    public Alumno(String nombre, String apellidos, int anoNacimiento, String ciudad, String estado, String curp, String direccion, String numeroControl, Semestre semestre, Grupo grupo, double promedio, List<Calificaciones> calificaciones, String nombreUsuario, String contrasena, Carreras carrera) {
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
        String apellidos = datosComun.get(1);
        String [] fechaNacimiento = datosComun.get(2).split("-");
        String estado = datosComun.get(3);
        String ciudad = datosComun.get(4);
        String direccion = datosComun.get(5);
        String curp = datosComun.get(6);
        String nombreUsuario = datosComun.get(7);
        String contrasena = datosComun.get(8);
        String numeroControl = datosComun.get(9);
        //metodo asignar materias

        Alumno alumno = new Alumno(nombre, apellidos, Integer.parseInt(fechaNacimiento[2]), ciudad, estado, curp, direccion, numeroControl, new Semestre(1, null), null, 0, null, nombreUsuario, contrasena, Sistema.carrera);

        Sistema.usuarios.get(Sistema.carrera).get(Rol.ALUMNO);

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
        System.out.println("Carrera: " + this.getCarrera());
        System.out.println("Semestre: " + this.getSemestre());
        System.out.println("Grupo: " + this.getGrupo());
        System.out.println("Promedio: " + this.getPromedio());
    }
}
