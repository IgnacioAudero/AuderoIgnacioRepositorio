import java.util.Scanner;

public class Mutantes {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String[] dna = new String[6];

        System.out.println("BIENVENIDO AL DETECTOR DE MUTANTES\n\nIngrese una secuencia de 4 letras\nLas letras validas son 'A', 'C', 'G' o 'T'\n");

        for (int i = 0; i < dna.length; i++) {
            while (true){
                System.out.print("Ingrese la fila " + (i + 1) + ": ");
                String secuencia = sc.nextLine().toUpperCase();

                if (secuencia.length() != 6){
                    System.out.println("ERROR. Debe ingresar una secuencia de 4 letras, intente nuevamente.\n");
                }else {
                    if (secuencia.matches("^[ACGT]+$")){
                        dna[i] = secuencia;
                        break;
                    }else {
                        System.out.println("ERROR. La secuencia tiene que estar compuesta de las letras 'A', 'C', 'G' o 'T', intente nuevamente.\n");
                    }
                }
            }
        }

        if (esMutant(dna)){
            System.out.println("\nSegun el ADN ingresado indica que la persona ES MUTANTE");
        }else {
            System.out.println("\nSegun el ADN ingresado indica que la persona NO ES MUTANTE");
        }
    }

    public static boolean esMutant(String[] dna) {
        int longitud = dna.length;

        for (int i = 0; i < longitud; i++) {
            for (int j = 0; j < longitud - 3; j++) {
                if (dna[i].charAt(j) == dna[i].charAt(j + 1) && dna[i].charAt(j) == dna[i].charAt(j + 2) && dna[i].charAt(j) == dna[i].charAt(j + 3)) {
                    return true;
                }
            }
        }

        for (int i = 0; i < longitud - 3; i++) {
            for (int j = 0; j < longitud; j++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j) && dna[i].charAt(j) == dna[i + 2].charAt(j) && dna[i].charAt(j) == dna[i + 3].charAt(j)) {
                    return true;
                }
            }
        }

        for (int i = 0; i < longitud - 3; i++) {
            for (int j = 0; j < longitud - 3; j++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j + 1) && dna[i].charAt(j) == dna[i + 2].charAt(j + 2) && dna[i].charAt(j) == dna[i + 3].charAt(j + 3)) {
                    return true;
                }
            }
        }

        for (int i = 0; i < longitud - 3; i++) {
            for (int j = 3; j < longitud; j++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j - 1) && dna[i].charAt(j) == dna[i + 2].charAt(j - 2) && dna[i].charAt(j) == dna[i + 3].charAt(j - 3)) {
                    return true;
                }
            }
        }

        return false;
    }
}
