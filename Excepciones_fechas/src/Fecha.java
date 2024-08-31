import javax.swing.JOptionPane;

public class Fecha {

    public static void main(String[] args) {
        try {
            // Solicitar al usuario que ingrese el día
            int diauser = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el día"));

            // Solicitar al usuario que ingrese el mes
            int mesuser = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes"));

            // Solicitar al usuario que ingrese el año
            int aniouser = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año"));

            // Verificar si la fecha es válida
            if (esFechaValida(diauser, mesuser, aniouser)) {
                JOptionPane.showMessageDialog(null, "Fecha válida: " + diauser + "/" + mesuser + "/" + aniouser);
            } else {
                JOptionPane.showMessageDialog(null, "Fecha inválida: " + diauser + "/" + mesuser + "/" + aniouser, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor, ingrese números enteros para el día, mes y año.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metodo para validar la fecha
    private static boolean esFechaValida(int dia, int mes, int anio) {
        if (mes < 1 || mes > 12) {
            return false;
        }

        int diasEnMes = obtenerDiasEnMes(mes, anio);
        return dia > 0 && dia <= diasEnMes;
    }

    // Metodo para obtener el número de días en un mes determinado
    private static int obtenerDiasEnMes(int mes, int anio) {
        switch (mes) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (esAnioBisiesto(anio)) ? 29 : 28;
            default:
                return 31;
        }
    }

    // Metodo para determinar si un año es bisiesto
    private static boolean esAnioBisiesto(int anio) {
        if (anio % 4 == 0) {
            if (anio % 100 == 0) {
                return anio % 400 == 0;
            }
            return true;
        }
        return false;
    }
}