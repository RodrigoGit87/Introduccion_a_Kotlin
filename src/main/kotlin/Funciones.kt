package introduccion_Kotlin

/*Una función es bloque de código con nombre que se puede llamar para realizar una tarea específica.
Y puede ser llamada en el lugar que se necesite. Se usa la palabra reservada 'fun'*/

/*  fun nombre (parametro/s) {...}  */

/**
 * FUNCIONES CON CUERPO DE EXPRESIÓN
 * Si la función retorna solo una expresión, se puede reducir su sintaxis. La expresión irá después del signo
* = en línea con la firma de la funcion. Este tipo de declaración permite inferir el tipo Ejemplo: */
fun model(x: Int, y:Int, z: Int) = 3 * x - 2 * y + z * z

/**
 * FUNCIONES DE RETORNO TIPO UNIT *  es la palabra reservada análoga a void en Java. Esto determine que una función no retorna valor.
 * En el ejemplo fun isVowel... la función solo imprime según el condicional, no 'guarda' un valor en la función*/

fun isVowel(c: Char): Unit{ // Se puede omitir Unit (kotlin lo infiere)
    when(c){
        'a','e','i','o','u' -> {
            println("$c is a vowel")
        } else -> println("$c is not a vowel")
    }
}

/**
 * ARGUMENTOS POR DEFECTO
 * Usar el operador = en la declaración del parámetro/s de la función
 * */

val customers = arrayListOf<String>("Carlos","Miguel","Victor")

fun loadCustomer(limit:Int=0): String{
    return customers[limit]
}

/**
 * ARGUMENTOS VARIABLES
 * Aplicar el modificador 'vararg' al parámetro para que acepte un número variable de valores
 */
fun maxLength(vararg words:String):Int{ // la función aceptará un número x de Strings
    var max=0
    for (word in words){
        if (word.length > max) max = word.length
    }
    return max
}

/**
 * FUNCIONES LAMBDA
 * Una fun lambda es un literal de función que puede ser usado como expresión.
 * Una forma compacta de implementar una función anónima.
 * Siempre va entre llaves y no soportan return
 *
 * {parametro: tipo, parametro: tipo -> expresión}*/

fun sumarDos(n: Int) = n +2 //al ser reescrita como lambda, seria:
val sumarDosLambda = {n:Int -> n + 2}

/**
 * ASIGNACION LAMBDA DE UNA FUNCION TRADICIONAL
 */

fun suma(a: Int, b: Int):Int{
    return a + b
}
val miSuma= ::suma //<- ::nombreFuncion, así se asigna a la variable miSuma la funcion suma

/**
 * ASIGNACION DE UNA LAMBDA
 * Una lambda se puede asignar en una variable nueva
 */
val mediaTresNotas = {nota1: Double, nota2: Double, nota3: Double -> (nota1 + nota2 + nota3) / 3}
val notas = mediaTresNotas
//  println(notas(4.0,7.5,6.0))

/**
 * =========
 */
fun main () {
    println("fun model(1,0,5)= ${model(1, 0, 5)}") // fun model(1,0,5)= 28

    isVowel('z') // z is not a vowel

    println("Cliente: ${loadCustomer()}") // Cliente: Carlos (porque hemos puesto como parámetro que la función retorne el
                                        // limit, que está declarado en 0.)
    println("Cliente: ${loadCustomer(1)}") //Cliente: Miguel (al modificar el argumento limit)
    println()

    /**
     * Para la función maxLength que retorna la palabra más larga (en número de caracteres)
     * podemos poner manualmente un número X de strings, por ejemplo 4 palabras diferentes.
     */

    println("La palabra mas larga tiene: ${maxLength("Carro","Manzana","Bosque","Avión")}") //7

    /** O bien con el operador spread '*' que desempaqueta el array y sus elementos se tratarán como
    * si se hubiesen pasado manualmente.*/

    val arrayAnimales = arrayOf("Perro","Gato","Gorila","Jabalí")
    println("La palabra mas larga tiene: ${maxLength(*arrayAnimales)}"); // 6

    /**
     * Llamada a las lambdas
     */
    println(sumarDosLambda(13)) //15
    println(notas(4.0,7.5,6.0)) //  5.833333333333333

    //otro ejemplo de lambda
    val alternarMensaje = {
        println("Hola")
        "Adiós"} ()
    println(alternarMensaje) // Hola
                            //  Adiós

    /**
     * EJECUCIÓN DIRECTA DE UNA LAMBDA
     */
    val resultado = { n1: Int, n2: Int -> n1 + n2 } (5,5)
    println("lambda directa resultado(5,5): $resultado") // lambda directa resultado(5,5): 10
}
