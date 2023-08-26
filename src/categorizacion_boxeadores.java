import java.util.*;

public class categorizacion_boxeadores {
    public static Scanner entrada = new Scanner(System.in);
    public static List<String> categorias = new ArrayList<>();

    public static void categorizacion() {
        System.out.println("Ingrese el número de boxeadores:");
        int numBoxeadores = entrada.nextInt();

        for (int i = 0; i < numBoxeadores; i++) {
            System.out.println("Ingrese peso del boxeador:");
            float peso = entrada.nextFloat();

            String categoria = categorizarPeso(peso);
            if (categoria != null) {
                categorias.add(categoria);
                System.out.println("Pertenece a la categoría: " + categoria);
            } else {
                System.out.println("Peso no válido para categorizar");
            }
        }
    }

    public static String categorizarPeso(float peso) {
        if (peso >= 91) {
            return "Peso superpesado";
        } else if (peso >= 81) {
            return "Peso pesado";
        } else if (peso >= 75) {
            return "Peso semipesado";
        } else if (peso >= 69) {
            return "Peso welter";
        } else if (peso >= 64) {
            return "Peso superligero";
        } else if (peso >= 60) {
            return "Peso ligero";
        } else if (peso >= 57) {
            return "Peso pluma";
        } else if (peso >= 54) {
            return "Peso gallo";
        } else if (peso >= 51) {
            return "Peso mosca";
        } else if (peso >= 48) {
            return "Peso minimosca";
        }
        return null;
    }

    public static void buscar() {
        System.out.println("Qué categoría desea revisar:");
        System.out.println(
                "1.Peso superpesado\n2.Peso pesado\n3.Peso semipesado\n4.Peso welter\n5.Peso superligero\n6.Peso ligero\n7.Peso pluma\n8.Peso gallo\n9.Peso mosca\n10.Peso minimosca");
        int opcion = entrada.nextInt();

        if (opcion < 1 || opcion > 10) {
            System.out.println("Opción no válida");
            return;
        }

        String categoria = categorias.get(opcion - 1);
        int conteo = Collections.frequency(categorias, categoria);

        System.out.println("La categoría " + categoria + " tiene " + conteo + " individuos");
    }

    public static void main(String[] args) {
        System.out.println("Bienvenido");
        boolean corte = true;

        while (corte) {
            System.out.println(
                    "¿Qué operación desea realizar?\n1. Analizar pesos\n2. Analizar boxeadores en categoría\n3. Salir");
            int opera_menu = entrada.nextInt();

            switch (opera_menu) {
                case 1:
                    categorizacion();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    System.out.println("Saliendo");
                    corte = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

        entrada.close();
    }
}
