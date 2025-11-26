import java.util.Scanner;

public class SeleccionDeMenu {
    Scanner sc = new Scanner(System.in);
    MonedasDelMundo[] monedas = MonedasDelMundo.values();
    ConsultaTasaDeCambio tasa = new ConsultaTasaDeCambio();


    private void mostrarNumeros(){
        for (MonedasDelMundo moneda : MonedasDelMundo.values()) {
            System.out.println((moneda.ordinal() + 1) + ") " + moneda.name() + "-" + moneda.getDescripcion());
        }
    }

    public void menu(){
        String base = "";
        String destino = "";
        while (true) {
            System.out.println("***************************");
            System.out.println("CONVERSOR DE MONEDA");
            System.out.println("***************************\n");
            //moneda base
            try {
                System.out.println("Ingrese el número de moneda a convertir: ");
                mostrarNumeros();
                int seleccion = sc.nextInt();
                sc.nextLine();
                //validaciones
                if (seleccion >= 1 && seleccion <= monedas.length) {
                    base = monedas[seleccion - 1].name();
                } else {
                    System.out.println("Ingrese un número del 1 al " + monedas.length);
                }

                //moneda destino
                System.out.println("Ingrese el numero de moneda que quiere convertir: ");
                mostrarNumeros();
                int seleccionDos = sc.nextInt();
                if (seleccionDos >= 0 && seleccionDos < monedas.length) {
                    destino = monedas[seleccionDos - 1].name();
                } else {
                    System.out.println("Ingrese un número del 1 al " + monedas.length);
                }
                sc.nextLine();


                //llamada a la api con los parámetros
                try {
                    TipoDeCambio resu = tasa.consultaApi(base, destino);
                    System.out.println("\n-------------------------------");
                    System.out.println("Tasa de cambio:");
                    System.out.println("1) Base: " + base + " ===> Destino: " + destino);
                    System.out.println(resu.conversion_rate());
                    System.out.println("-------------------------------\n");
                } catch (NullPointerException e){
                    System.out.println("La api falló!!");
                    System.out.println(e.getMessage());
                }
            } catch (Exception e){
                System.out.println("Ingrese un número!");
                System.out.println(e.getMessage());
            }

            System.out.println("Desea continuar? ");
            System.out.println("Ingrese el numero correspondiente!");
            System.out.println("1: SI ");
            System.out.println("2: NO ");
            int decision = sc.nextInt();
            sc.nextLine();
            if (decision == 2){
                System.out.println("Gracias por usar nuestro software!!");
                break;
            }
        }
    }
}
