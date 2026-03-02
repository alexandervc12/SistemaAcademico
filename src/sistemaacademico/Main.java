/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaacademico;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private static ArrayList<Nota> notas = new ArrayList<>();
    private static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }
    
    public static void mostrarMenu() {
        System.out.println("\n=== SISTEMA ACADÉMICO UPC ===");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar estudiante");
        System.out.println("4. Actualizar estudiante");
        System.out.println("5. Eliminar estudiante");
        System.out.println("6. Registrar asignatura");
        System.out.println("7. Listar asignaturas");
        System.out.println("8. Buscar asignatura");
        System.out.println("9. Actualizar asignatura");
        System.out.println("10. Eliminar asignatura");
        System.out.println("11. Registrar nota");
        System.out.println("12. Listar notas");
        System.out.println("13. Buscar nota");
        System.out.println("14. Actualizar nota");
        System.out.println("15. Eliminar nota");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    public static int leerOpcion() {
        try {
            return Integer.parseInt(leer.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> registrarEstudiante();
            case 2 -> listarEstudiantes();
            case 3 -> buscarEstudiante();
            case 4 -> actualizarEstudiante();
            case 5 -> eliminarEstudiante();
            case 6 -> registrarAsignatura();
            case 7 -> listarAsignaturas();
            case 8 -> buscarAsignatura();
            case 9 -> actualizarAsignatura();
            case 10 -> eliminarAsignatura();
            case 11 -> registrarNota();
            case 12 -> listarNotas();
            case 13 -> buscarNota();
            case 14 -> actualizarNota();
            case 15 -> eliminarNota();
            case 0 -> System.out.println("¡Saliendo....!");
            default -> System.out.println("Opción inválida");
        }
    }

    
        public static void registrarEstudiante() {
            System.out.println("\n--- REGISTRAR ESTUDIANTE ---");
            System.out.print("Código: ");
            String codigo = leer.nextLine();
            System.out.print("Nombre: ");
            String nombre = leer.nextLine();
            System.out.print("Apellido: ");
            String apellido = leer.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(leer.nextLine());
            System.out.print("Semestre: ");
            int semestre = Integer.parseInt(leer.nextLine());

            Estudiante e = new Estudiante(codigo, nombre, apellido, edad, semestre);
            estudiantes.add(e);
            System.out.println("Estudiante registrado exitosamente");
    }
        
        public static void listarEstudiantes() {
            System.out.println("\n--- LISTA DE ESTUDIANTES ---");
            if (estudiantes.isEmpty()) {
                System.out.println("No hay estudiantes registrados");
                return;
            }
            for (int i = 0; i < estudiantes.size(); i++) {
                System.out.println((i + 1) + ". " + estudiantes.get(i));
            }
        }

        public static void buscarEstudiante() {
            System.out.println("\n--- BUSCAR ESTUDIANTE ---");
            System.out.print("Ingrese código del estudiante: ");
            String codigo = leer.nextLine();

            for (Estudiante e : estudiantes) {
                if (e.getCodigo().equals(codigo)) {
                    System.out.println(" Estudiante encontrado:");
                    System.out.println(e);
                    return;
                }
            }
            System.out.println("Estudiante no encontrado");
        }
        
        public static void actualizarEstudiante() {
            System.out.println("\n--- ACTUALIZAR ESTUDIANTE ---");
            System.out.print("Ingrese código del estudiante a actualizar: ");
            String codigo = leer.nextLine();

            for (Estudiante e : estudiantes) {
                if (e.getCodigo().equals(codigo)) {
                    System.out.println("Datos actuales: " + e);
                    System.out.print("Nuevo nombre : ");
                    String nombre = leer.nextLine();
                    if (!nombre.isEmpty()) e.setNombre(nombre);

                    System.out.print("Nuevo apellido : ");
                    String apellido = leer.nextLine();
                    if (!apellido.isEmpty()) e.setApellido(apellido);

                    System.out.print("Nueva edad : ");
                    String edadStr = leer.nextLine();
                    if (!edadStr.isEmpty()) e.setEdad(Integer.parseInt(edadStr));

                    System.out.print("Nuevo semestre : ");
                    String semestreStr = leer.nextLine();
                    if (!semestreStr.isEmpty()) e.setSemestre(Integer.parseInt(semestreStr));

                    System.out.println(" Estudiante actualizado");
                    return;
                }
            }
            System.out.println(" Estudiante no encontrado");
        }
        
        public static void eliminarEstudiante() {
            System.out.println("\n--- ELIMINAR ESTUDIANTE ---");
            System.out.print("Ingrese código del estudiante a eliminar: ");
            String codigo = leer.nextLine();

            for (int i = 0; i < estudiantes.size(); i++) {
                if (estudiantes.get(i).getCodigo().equals(codigo)) {
                    estudiantes.remove(i);
                    System.out.println(" Estudiante eliminado");
                    return;
                }
            }
            System.out.println(" Estudiante no encontrado");
        }
        
        
}