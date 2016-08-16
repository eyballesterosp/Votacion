package centinela;

import java.util.Scanner;

public class Centinela {

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        boolean centinela = true;
        int indicador = 0, filtroEstadoCivil = 0, filtroEdad = 0;
        int votacion[] = null;
        int[] estadoCivil = null;
        int[] edad = null;
        int[] calificacion = null;
        int personasIngresadas = 1;
        int opcion = 0, tamañoMaximo = 0;
        System.out.println("Ingrese la cantidad máxima de Personas a participar en las votaciones");
        tamañoMaximo = Input.nextInt();
        edad = new int[tamañoMaximo];
        estadoCivil = new int[tamañoMaximo];
        calificacion = new int[tamañoMaximo];
        while (centinela == true) {
            opcion = menu();
            if (opcion == 1) {
                if (personasIngresadas < tamañoMaximo) {
                    votacion = ingresarVotacion();
                    edad[personasIngresadas] = votacion[0];
                    estadoCivil[personasIngresadas] = votacion[1];
                    calificacion[personasIngresadas] = votacion[2];
                    personasIngresadas = personasIngresadas + 1;
                } else {
                    System.out.println("Ya participaron todos las personas posibles");
                }
            } else if (opcion == 2) {
                System.out.println("Sobre que estado civil desea hacer el filtro");
                filtroEstadoCivil = Input.nextInt();
                System.out.println("Sobre que rango de edad desea hacer el filtro");
                filtroEdad = Input.nextInt();
                ReporteParcial(edad, estadoCivil, calificacion,
                        personasIngresadas - 1, filtroEdad, filtroEstadoCivil);
            } else {
                ReporteFinal(calificacion, personasIngresadas - 1);
            }
            System.out.println("Si desea finalizar presione 0, para continuar presione 1");
            indicador = Input.nextInt();
            if (indicador == 0){
                centinela = false;
            }
        }
        System.out.println("Se ha finalizado la ejecución del proceso de elecciones");
    }

    public static int menu() {
        Scanner Input = new Scanner(System.in);
        System.out.println("\"Seleccione la opcion a ejecutar 1. Ingresar Votacion. 2. Reporte Parcial. 3. Reporte Final Elecciones");
        int opcion = Input.nextInt();
        return opcion;
    }

    public static void ReporteParcial(int[] edad, int[] estadoCivil, int[] Calificacion, int tamaño, int filtroEdad, int filtroEstadoCivil) {
        System.out.println("Reporte Parcial");
        int total = 0;
        int nummCumpleFiltro = 0;
        double promedio = 0;
        for (int i = 0; i < tamaño; i++) {
            if (estadoCivil[i] == filtroEstadoCivil && edad[i] == filtroEdad) {
                nummCumpleFiltro = nummCumpleFiltro + 1;

                total = total + Calificacion[i];
            }
        }
         promedio = total / nummCumpleFiltro;
        System.out.println("Resultados Parcial: " + " Votaron " + nummCumpleFiltro + " Personas con Estado Civil " + filtroEstadoCivil + " Y en rango de edad de " + filtroEdad + " con promedio total de " + promedio);

    }

    public static void ReporteFinal(int[] calificacion, int tamaño) {
        System.out.println("Reporte Final");
        int total = 0;

        for (int i = 0; i < tamaño; i++) {
            total = total + calificacion[i];
        }

        total = total / tamaño;
        System.out.println("Resultado Final" + " Numero de encuestados actuales " + tamaño + " Promedio Votacion " + total);
    }

    public static int[] ingresarVotacion() {
        Scanner Input = new Scanner(System.in);
        int votacion [] = new int[3];
        System.out.println("Ingrese Rango de edad: Presione 1 si tiene menos de 18 años, 2. si tiene entre 18 y 55. 3. Si tiene más de 55");
        votacion[0] = Input.nextInt();
        System.out.println("Situcion Civil: Presione 1 si es soltero, 2 Si es casado");
        votacion[1] = Input.nextInt();
        System.out.println("Ingrese calificación del curso entre 0 y 10");
        votacion[2] = Input.nextInt();
        return votacion;
    }
}
