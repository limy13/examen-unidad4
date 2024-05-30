import java.time.LocalDate;
import java.util.List;

public class Graduado {
    private static LocalDate fechaGraduacion = LocalDate.now();
    private Carrera carrera;
    private List<Alumno> alumnos;
    private String generacionGraduacion;

    public static void a(){
        System.out.println(fechaGraduacion);
    }
}
