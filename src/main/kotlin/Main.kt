package introduccion_Kotlin

import kotlin.math.roundToInt

fun main() {
    /**
     * val es constante
     * var es para variables normales
     * Victor aconseja q usemos val */

        // Kotlin puede inferir el tipo de dato, siempre q sea evidente. Si no dará error y pedirá el tipo. Por convección y seguridad, es mejor tipar las variables.
        val dato = 5
        println(dato)

        //Kotlin no permite casteo como en Java. En Kotlin no existen tipos primitivos (los primitivos de Java son directamente objectos en kotlin)
        // Para convertir de un tipo de dato a otro, se usan métodos. Para la clase Number, los típicos métodos:    .toInt(),   toDouble(), .toShort()...

        val decimal:Double=75.99
        val entero:Int = decimal.roundToInt() //roundToInt() es mas eficiente q un .toInt() por que redondea el numero segun el decimal
        println (decimal)
        println (entero)

        // val usuario:String = null -> un String no admite valor null
        //Para permitir valores nulos en un String en Kotlin, añadir '?' en el tipo de la variable
        val usuarioNulo:String? = null

        println("usuario nulo: " + usuarioNulo)


        // Operador Elvis '?:' ES como el operador ternario, separa dos expresiones, si la expresion de la izquierda no se resuelve en un valor nulo,se devuelve ese valor
        // De lo contrario, se resuelve con el valor de la expresion a la derecha.
        val myString:String? = null
        println (myString?:"String is null")

        /**==== IMPRIMIR EN KOTLIN ====*/

        //1. Imprimir texto básico
        println("==============")
        println("¡Hola, Mundo!")

        //2. Imprimir variables (Plantillas de strings)

        //Para incluir el valor de una variable dentro del texto, utiliza el símbolo $ antes del nombre de la variable:
        val edad = 25
        println("Tengo $edad años.") // Resultado: Tengo 25 años.

        //3. Imprimir expresiones o propiedades
        // Si quieres mostrar el resultado de una operación, una función o acceder a la propiedad de un objeto, envuelve la expresión entre llaves ${}:

        val precio = 100
        println("El precio con un 10% de descuento es: ${precio * 0.9}")

        val nombre = "Carlos"
        println("Tu nombre tiene ${nombre.length} letras.")
    }