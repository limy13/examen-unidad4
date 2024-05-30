import java.util.ArrayList;

public class Materia {
    private Materias nombre;
    private String profesor;
    private Carreras carrera;
    private static int NUMERO_MATERIAS;

    public Materia(Materias nombre, String profesor, Carreras carrera) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.carrera = carrera;
    }

    public Materias getNombre() {
        return nombre;
    }

    public void setNombre(Materias nombre) {
        this.nombre = nombre;
    }

    public Materia asignarMaestro(Materias mater) { //le asigna un maestro a la materia y devuelve dicha mateia ya con el maestro asignado
        for(Usuario usuario : Sistema.usuarios.get(Sistema.carrera).get(Rol.PROFESOR)) {
            Profesor profesor = (Profesor) usuario;
            for(Materias nombreMateria : profesor.getMateriasImparte()) {
                if(mater == nombreMateria) {
                    Materia materia = new Materia(mater, profesor.getNombre().concat(" ").concat(profesor.getApellidos()), Sistema.carrera);
                    return materia;
                }
            }
        }
        return null;
    }

    public ArrayList<Materia> asignarMaterias(int numero) {
        ArrayList<Materia> materias = null;
        if(numero == 1 && Sistema.carrera == Carreras.SISTEMAS) {
            materias.add(asignarMaestro(Materias.PROGRAMACION_1));
            materias.add(asignarMaestro(Materias.CALCULO_1));
            materias.add(asignarMaestro(Materias.PROBABILIDAD_1));
        }
    }
}
