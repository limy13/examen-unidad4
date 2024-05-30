import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private int decision; //sirve para tomar una decision en cualquier menú
    private Sistema sistema = new Sistema();

    public void iniciarSesion() {
        boolean datosCorrectos = true, salir = false;
        do {
            System.out.println("\n---- BIENVENIDO A MINDBOX ITM ----\n");
            try {
                System.out.print("Ingresa tu usuario para continuar: ");
                String usuario = scanner.nextLine();
                System.out.print("Ingresa tu contraseña: ");
                String contrasena = scanner.nextLine();
            
                Usuario usuarioActual = sistema.verificarInicioSesion(usuario, contrasena);
                if(usuarioActual != null) {
                    UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                    seleccionarMenu();
                }
                else {
                    System.out.println("\nUsuario o contraseña incorrectos.");
                    do {
                        try {
                            System.out.print("\n¿Desea intentarlo otra vez? (1 = si, 2 = no)");
                            int decision = scanner.nextInt();
                            if(decision == 2) {
                                datosCorrectos = false;
                                salir = true;
                            }
                            else if (decision == 1){
                                datosCorrectos = true;
                                salir = true;
                            }
                            else {
                                System.out.println("\nPor favor ingrese una de las opciones disponibles");
                            }
                        }
                        catch (Exception e) {
                            System.out.println("\nPor favor ingrese una de las opciones disponibles");
                        }
                    }
                    while(!salir);
                }
            }
            catch (Exception e) {
                System.out.println("\nPor favor ingrese una cadena");
            }
        }
        while(datosCorrectos);
    }

    private void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {

            case COORDINADOR: menuCoordinador(usuario.getNombreUsuario()); //le manda por parametro ek nombre de usuario para que muestre quien esta en sesion
                break;
            case ALUMNO: menuAlumno(usuario.getNombreUsuario());
                break;
            case PROFESOR: menuAlumno(usuario.getNombreUsuario());
            break;
        }
    }

    public void menuCoordinador(String nombreUsuario) {
        do {
            System.out.println("\n****************************************");
            System.out.println("\n---- BIENVENIDO COORDINADOR ----\n");
            System.out.println(nombreUsuario);
            System.out.println("\n1. Mostrar registro de alumnos graduados");
            System.out.println("2. Registrar alumno");
            System.out.println("3. Consultar alumno"); //aqui va junto consultar el historial del alumno
            System.out.println("4. Modificar datos de alumno");
            System.out.println("5. Eliminar alumno");
            System.out.println("6. Registrar calificaciones");
            System.out.println("7. Consultar calificaciones");
            System.out.println("8. Registrar profesor");
            System.out.println("9. Consultar profesor");
            System.out.println("10. Modificar datos de profesor");
            System.out.println("11. Eliminar profesor");
            System.out.println("12. Avanzar de semestre");
            System.out.println("13. Cerrar sesión");
            System.out.print("\nIngrese opción: ");
            decision = scanner.nextInt();
            //queda pendiente el caso de coordinador

            switch(decision) {

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;
                    
                case 9:
                    break;

                case 10:
                    break;

                case 11:
                    break;

                case 12:
                    break;

                case 13:
                    break;
            }
        }
        while(decision != 13);
    }

    public void menuAlumno(String nombreUsuario) {
        do {
            System.out.println("\n****************************************");
            System.out.println("\n---- BIENVENIDO ALUMNO ----\n");
            System.out.println("Usuario: " + nombreUsuario);
            System.out.println("\n1. Ver mis calificaciones");
            System.out.println("2. Ver mis cursos inscritos");
            System.out.println("3. Ver mi información personal");
            System.out.println("4. Cerrar sesión");
            System.out.print("\nIngrese opción: ");
            decision = scanner.nextInt();

            switch (decision) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        } while (decision != 5);
    }

    public void menuMaestro(String nombreUsuario) {
        do {
            System.out.println("\n****************************************");
            System.out.println("\n---- BIENVENIDO MAESTRO ----\n");
            System.out.println("Usuario: " + nombreUsuario);
            System.out.println("\n1. Ver mis grupos");
            System.out.println("2. Ver mis materias asignadas");
            System.out.println("3. Ingresar calificaciones");
            System.out.println("4. Ver información personal");
            System.out.println("5. Cerrar sesión");
            System.out.print("\nIngrese opción: ");
            decision = scanner.nextInt();

            switch (decision) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        } while (decision != 6);
    }


}
