public class Calificaciones {
    private String materia;
    private double calificacion;

    public Calificaciones(String materia, double calificacion) {
        this.materia = materia;
        this.calificacion = calificacion;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
