import java.time.LocalDate;
import java.util.*;

public abstract class Usuario {
    private String nombre;
    private String apellidos;
    private int anoNacimiento;
    private String ciudad;
    private String estado;
    private String curp;
    private String direccion;
    private String fechaRegistro;
    private String numeroControl;
    private Rol rol;
    private String nombreUsuario;
    private String contrasena;
    private Carreras carrera;

    public Usuario(String nombre, String apellidos, int anoNacimiento2, String ciudad, String estado, String curp, String direccion, LocalDate fechaRegistro, String numeroControl, Rol rol, String nombreUsuario, String contrasena, Carreras carrera) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anoNacimiento = anoNacimiento2;
        this.ciudad = ciudad;
        this.estado = estado;
        this.curp = curp;
        this.direccion = direccion;
        this.fechaRegistro = String.valueOf(fechaRegistro);
        this.numeroControl = numeroControl;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.carrera = carrera;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellidos() {return apellidos;}

    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    public int getAnoNacimiento() {return anoNacimiento;}

    public void setAnoNacimiento(int anoNacimiento) {this.anoNacimiento = anoNacimiento;}

    public String getCiudad() {return ciudad;}

    public void setCiudad(String ciudad) {this.ciudad = ciudad;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public String getCurp() {return curp;}

    public void setCurp(String curp) {this.curp = curp;}

    public String getContrasena() {return contrasena;}

    public void setContrasena(String contrasena) {this.contrasena = contrasena;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getFechaRegistro() {return fechaRegistro;}

    public void setFechaRegistro(LocalDate fechaRegistro) {this.fechaRegistro = String.valueOf(fechaRegistro);}

    public String getNumeroControl() {return numeroControl;}

    public void setNumeroControl(String numeroControl) {this.numeroControl = numeroControl;}

    public Carreras getCarrera() {return carrera;}

    public Rol getRol() {return rol;}

    public void setRol(Rol rol) {this.rol = rol;}

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public static String generarNumeroControl(char letraNombre, Rol rol) { 

        //este metodo genera el numero de control para cualquier profe, alumno, coordinador

        String numeroControl = "";
        String caracter = rol == Rol.ALUMNO ? "l" : rol == Rol.PROFESOR ? "M" : "C";
        String siglasCarrera = Sistema.carrera == Carreras.SISTEMAS ? "ISC" : Sistema.carrera == Carreras.MATERIALES ? "IMAT" : "ELC";

        numeroControl += caracter + letraNombre + "24" + siglasCarrera;

        for(Usuario usuario : Sistema.usuarios.get(Sistema.carrera).get(rol)) {
            String [] numeroPartes = usuario.getNumeroControl().split("-");
            if(numeroPartes[0].equals(numeroControl)) {
                int numero = Integer.parseInt(numeroPartes[1]) + 1;
                numeroControl += String.valueOf(numero);
                break;
            }
        }   

        return numeroControl;
    }


    public static ArrayList datosComun(Rol rol) {
        ArrayList<String> datosComun = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        String rolUsuario = rol == Rol.ALUMNO ? "Alumno" : rol == Rol.PROFESOR ? "Profesor" : "Coordinador";

        System.out.println(String.format("\n\n---- Bienvenido al registro del %s", rolUsuario + " ----"));
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nNombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido paterno: ");
        String apellidoP = scanner.nextLine();
        System.out.print("Apellido materno: ");
        String apellidoM = scanner.nextLine();
        String fechaNacimiento = validarFecha(); // Método para validar fecha
        System.out.print("Género (H/M): ");
        String genero = scanner.nextLine().toUpperCase();
        System.out.print("Estado: ");
        String estado = validarEstado(scanner.nextLine());
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        String nombreUsuario = registrarNombreUsuario();
        String numeroControl = generarNumeroControl(nombre.charAt(0), rol);
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        String curp = generarCurp(nombre, apellidoP, apellidoM, fechaNacimiento, genero, estado);

        datosComun.addAll(Arrays.asList(nombre, apellidoP.concat(" ").concat(apellidoM), fechaNacimiento, estado, ciudad, direccion, curp.toUpperCase(), nombreUsuario, contrasena, numeroControl));
        return datosComun;
    }

    public static String registrarNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;
        do {
            System.out.print("Ingresa el nombre de usuario: ");
            nombreUsuario = scanner.nextLine();
            nombreUsuarioExistente = false;
            for(Map<Rol, ArrayList<Usuario>> usuariosList : Sistema.usuarios.values()) {
                for(ArrayList<Usuario> usuarios : usuariosList.values()) {
                    for(Usuario usuario : usuarios) {
                        if(usuario.getNombreUsuario().equals(nombreUsuario)) {
                            nombreUsuarioExistente = true;
                            System.out.println("\nEste nombre de usuario ya ha sido registrado, por favor ingrese uno diferente");
                            break;
                        }
                    }

                }
            }
        } 
        while (nombreUsuarioExistente);
        return nombreUsuario;
    }


    public static String validarFecha() {
        Scanner scanner = new Scanner(System.in);
        boolean fechaValida = false;
        String fechaIngresada = "";

        while (!fechaValida) {
            System.out.print("Ingresa una fecha con formato yyyy-MM-dd:");
            fechaIngresada = scanner.nextLine();

            String[] partesFecha = fechaIngresada.split("-");
            int año = Integer.parseInt(partesFecha[0]);
            int mes = Integer.parseInt(partesFecha[1]);
            int dia = Integer.parseInt(partesFecha[2]);


            // si ano es == a el actual hacer esto
            if (año == LocalDate.now().getYear()){
                if (mes >= 1 && mes <= 12 && mes <= LocalDate.now().getMonthValue() ) {
                    // Validar el día
                    if (dia >= 1 && dia <= obtenerDiasEnMes(mes)) {
                        fechaValida = true;
                    } else {
                        System.out.println("\nError: El día ingresado no corresponde al mes especificado.");
                    }
                } else {
                    System.out.println("\nError: El mes ingresado no es válido.");
                }

            }

             // Verificar que el año no sea futuro pero tampoco presente
             if (año < LocalDate.now().getYear() && año > 1907 ) {
                // Validar el mes

                if (mes >= 1 && mes <= 12  ) {
                    // Validar el día
                    if (dia >= 1 && dia <= obtenerDiasEnMes(mes)) {
                        fechaValida = true;
                    } else {
                        System.out.println("\nError: El día ingresado no corresponde al mes especificado.");
                    }
                } else {
                    System.out.println("\nError: El mes ingresado no es válido.");
                }
            } else {
                System.out.println("\nError: El año ingresado no puede ser un año futuro o muy muy viejo.");
            }//fin if
        }//while

      return fechaIngresada;
    }//metodovalidar

    public static int obtenerDiasEnMes(int mes) {
        switch (mes) {
            case 2:
                return 28; 
                 
            case 4:
                return 30; // Abril, junio, septiembre y noviembre tienen 30 días

            case 6: 
                return 30;

            case 9: 
                return 30;

            case 11: 
                return 30;

            default:
                return 31; // Los demás meses tienen 31 días
        }
    }


    public static String validarEstado(String estado) {
        Map<String, String> estados = new HashMap<>();
        estados.put("AS", "Aguascalientes");
        estados.put("BC", "Baja California");
        estados.put("BS", "Baja California Sur");
        estados.put("CC", "Campeche");
        estados.put("CL", "Coahuila de Zaragoza");
        estados.put("CM", "Colima");
        estados.put("CS", "Chiapas");
        estados.put("CH", "Chihuahua");
        estados.put("DF", "Ciudad de México");
        estados.put("DG", "Durango");
        estados.put("GT", "Guanajuato");
        estados.put("GR", "Guerrero");
        estados.put("HG", "Hidalgo");
        estados.put("JC", "Jalisco");
        estados.put("MC", "México");
        estados.put("MN", "Michoacán de Ocampo");
        estados.put("MS", "Morelos");
        estados.put("NT", "Nayarit");
        estados.put("NL", "Nuevo León");
        estados.put("OC", "Oaxaca");
        estados.put("PL", "Puebla");
        estados.put("QT", "Querétaro");
        estados.put("QR", "Quintana Roo");
        estados.put("SP", "San Luis Potosí");
        estados.put("SL", "Sinaloa");
        estados.put("SR", "Sonora");
        estados.put("TC", "Tabasco");
        estados.put("TS", "Tamaulipas");
        estados.put("TL", "Tlaxcala");
        estados.put("VZ", "Veracruz");
        estados.put("YN", "Yucatán");
        estados.put("ZS", "Zacatecas");

        String estadoUpper = estado.toUpperCase();

        if (estados.containsKey(estadoUpper)) {
            return estadoUpper;
        } else {
            Scanner scanner = new Scanner(System.in);
            while (!estados.containsKey(estadoUpper)) {
                System.out.print("Ingresa un Estado que si Exista" );
                estadoUpper = scanner.nextLine().toUpperCase();
            }
        }

        return estadoUpper;
    }

    public static String generarCurp(String nombre, String apellidoP, String apellidoM, String fechaNacimiento, String genero, String estado) {
        String primerLetraApellidoP = apellidoP.substring(0, 1).toUpperCase();
        String primeraVocalApellidoP = obtenerPrimeraVocal(apellidoP);
        String primerLetraApellidoM = apellidoM.substring(0, 1).toUpperCase();
        String primerLetraNombre = nombre.substring(0, 1).toUpperCase();
        String[] fecha = fechaNacimiento.split("-");
        String año = fecha[0].substring(2);
        String mes = fecha[1];
        String dia = fecha[2];

        String curp = primerLetraApellidoP + primeraVocalApellidoP + primerLetraApellidoM + primerLetraNombre + año + mes + dia + genero + estado;

        curp += "00"; //Los 0 son por la homoclave, me da flojera hacerla jaja

        return curp;
    }

    public static String obtenerPrimeraVocal(String apellido) {
        String apellidoUpper = apellido.toUpperCase();
        for (int i = 1; i < apellidoUpper.length(); i++) {
            char c = apellidoUpper.charAt(i);
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                return String.valueOf(c);
            }
        }
        return "X";
    }
}

