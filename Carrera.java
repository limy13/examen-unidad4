import java.time.LocalDate;

public class Carrera {
    String id;
    String nombreCarrera;
    int cantidadDeGrupos;
    int cantidadDeAlumnos;
    String materia1, materia2, materia3;
    final LocalDate fechaCarrera = LocalDate.now();
    Coordinador coordinador;

    public Carrera(String nombreCarrera, String materia1, String materia2, String materia3, Coordinador coordinador) {
        this.nombreCarrera = nombreCarrera;
        this.materia1 = materia1;
        this.materia2 = materia2;
        this.materia3 = materia3;
        this.coordinador = coordinador;
    }


}