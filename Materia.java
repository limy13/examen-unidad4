import java.util.ArrayList;

public class Materia {
    private Materias nombre;
    private String profesor;
    private Carreras carrera;
    private static int NUMERO_MATERIAS = 1;
    private int id;

    public Materia(Materias nombre, String profesor, Carreras carrera) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.carrera = carrera;
        this.id = NUMERO_MATERIAS;
        NUMERO_MATERIAS++;
    }

    public Materias getNombre() {
        return nombre;
    }

    public void setNombre(Materias nombre) {
        this.nombre = nombre;
    }

    

    
}
