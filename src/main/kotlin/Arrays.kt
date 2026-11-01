package introduccion_Kotlin
/* El tipo de array mas común en Kotlin es el array de tipo objeto.
Sin embargo el array no se puede poner 'val'(constante) tiene que ser 'var', aunque los elementos que
contenga si sean tipo 'val'*/
    fun main(){
    println(" === ARRAYS ===")
    // declaracion de un array
    var riversArray = arrayOf("Nilo", "Amazonas", "Yangtze")

    //añadir elemento al array
    riversArray += "Mississippi"

    println(riversArray.joinToString()) //metodo para convertir el array en String
    println(riversArray.size) // número de items en el array
    println(riversArray[0]) // acceso a item concreto en el array

    // recorrer array con ciclo for
    println("- Recorrer valores de un array con ciclo for")
    for ( item in riversArray ) print(item + " ") // muestra los valores q hay en el array, no los indices

    println()
    println("- Recorrer los indices del array con ciclo for")
    for (i in riversArray.indices) print("$i ") // palabra reservada 'indices'. (Sí, en español :D )
    println()

    println("- Lo mismo pero mostrando el valor de cada indice:")
    for (i in riversArray.indices) println("$i - ${riversArray[i]}")

    //Desestructuración de elementos
    /*Es habitual crear pares de clave:valor,por ejemplo quiero ver el saldo de una cuenta 'paypal'
    y la cantidad 'x'*/
    println("- Desestructuración de elementos")
    val account = "Paypal" to 50.4 // el 'to' crea una tupla clave:valor
    println(account) // (Paypal, 50.4) <- aquí account es un objeto que podemos desestructurar

    val (name, balance) = account //al crear una variable entre parentesis con los nombres de la clave y del valor,
    // y asignando el objeto account a dicha variable, lo hemos desestructurado en esos dos nombres.
    println("Cuenta: $name") // Cuenta: Paypal
    println("Saldo: $balance") //Saldo: 50.4

    println("- Desestructuración de un array")
    val champions = arrayOf("Teemo", "Ahri", "Vayne", "Brand", "Kindred")
    for ((i, v) in champions.withIndex()) {
        println("[$i, $v]")
    }
}