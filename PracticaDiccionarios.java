package practicadiccionarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Realiza un buscador de sinónimos. Aprovecha el diccionario español-inglés
 * utilizado en los ejercicios de clase, modificándolo o ampliándolo
 * convenientemente. El programa preguntará una palabra y dará una lista de
 * sinónimos (palabras que tienen el mismo significado). Por ejemplo, si se
 * introduce la palabra “caliente”, el programa dará como resultado: ardiente,
 * candente, abrasador. ¿Cómo sabe el programa cuáles son los sinónimos de
 * “caliente”? Muy fácil, en el diccionario debe existir la entrada (“caliente”,
 * “hot”), por tanto solo tendrá que buscar las palabras en español que también
 * signifiquen “hot”; esta información estará en las entradas (“ardiente”,
 * “hot”), (“candente”, “hot”) y (“abrasador”, “hot”). Además de dar la lista de
 * sinónimos, el programa debe ser capaz de aprender. Cuando una palabra no
 * tiene sinónimos, es decir, cuando aparece la palabra en español con su
 * traducción y esa traducción no la tiene ninguna otra palabra española, se le
 * preguntará al usuario si quiere añadir uno (un sinónimo) y, en caso
 * afirmativo, se pedirá la palabra y se añadirá al diccionario. Se puede dar la
 * circunstancia de que el usuario introduzca una palabra en español que no está
 * en el diccionario; en tal caso, se mostrará el consiguiente mensaje y se dará
 * la posibilidad al usuario de añadir la entrada correspondiente en el
 * diccionario pidiendo, claro está, la palabra en inglés.
 *
 * @author jesus
 */
public class PracticaDiccionarios {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<String, String> diccionarioEs = new HashMap<String, String>(); //creación del HashMap

        diccionarioEs.put("Ardiente", "Hot"); //Introducción de datos en el  HashMap
        diccionarioEs.put("Candente", "Hot");
        diccionarioEs.put("Hola", "Hello");
        diccionarioEs.put("Abrasador", "Hot");

        String significado = ""; // Se crea el String significado para utilizarlo más tarde
        ArrayList<String> sinonimo = new ArrayList<String>(); // Se crea el arrayList
        System.out.print("Introduzca una palabra en español: ");
        String palabraConsultada = s.nextLine(); // creación del String palabraConsultada para recoger la palabra que el usuario queire conocer.
        if (diccionarioEs.containsKey(palabraConsultada)) { // comprobación de si la palabraConsultada se encuentra en el diccionario
            significado = diccionarioEs.get(palabraConsultada); // recogida de la palabra consutada en la variable significado

            System.out.println();
            System.out.println("La palabra en inglés es: " + diccionarioEs.get(palabraConsultada));

            for (Map.Entry pareja : diccionarioEs.entrySet()) { // Bucle para recorrer todo el HashMap e introducirlo en la variable pareja.

                if (significado.equals(pareja.getValue())) { //comprobación de si la palabraConsultada y recogida anteriormente en significado, para encontrar los sinónimos
                    if (!palabraConsultada.equals(pareja.getKey())) {// para recoger los sinónimos en el arrayList
                        sinonimo.add((String) pareja.getKey());
                    }
                }
            }
        } else { // por si la palabra consultadas no se encuentra en el diccionario
            System.out.print("La palabra consultada no se encuentra en el diccionario");
        }

        if (!sinonimo.isEmpty()) { // Si en el arrayList hemos incluidos algún sinónimo y nos lo muestra
            System.out.println("Y cuenta con los siguientes sinónimos:");
            System.out.println(sinonimo);
        } else {
            System.out.println("No cuenta con Sinónimos"); // si en el arrayList no hemos incluido ningún sinónimo
        }
    }
}
