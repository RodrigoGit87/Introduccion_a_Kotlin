package introduccion_Kotlin

    /**
     * === En Kotlin, el condicional 'IF' es una expresión primaria. Esto implica que al evaluar una condición se produce
     * un valor que puede ser usado en el retorno de una función o en la asignación de una variable. ===*/

    fun main() {
        println(" === IF ===")
        // ejemplo: evaluar la vida del enemigo, si es menor o igual a 15, establecer el ataque de la carta
        // en 9, si no en 6.
        val enemyHeroHealth = 14
        var cardAttack:Int = if (enemyHeroHealth <= 15) 9 else 6

        println("Ataque: $cardAttack")

        /*La rama if-else pueden ser convertidas en bloques si se usan llaves.
        * Esto quiere decir q se puede tener múltiples líneas en el cuerpo de cada una.
        * Pero la última línea debe ser el valor resultante del bloque*/

        cardAttack = if (enemyHeroHealth <= 15) {
            println("Grrrrr !!")
            9
        } else {
            println("...")
            6
        }
        println("Ataque: $cardAttack")
        println(" === WHEN ===")
    /* === La expresión 'WHEN' sustituye al switch de Java ===*/
        val input:Char = 'y'

        when (input) {
            'y' -> println("Continuando..")
            'n' -> println("Cerrando..")
            else -> println("Invalid input")
        }
        // Se pueden poner varias expresiones seguidas separadas por comas para un mismo resultado:

        val valor = 6
        when (valor) {
            1,2,3 -> println("Turno nocturno")
            4,5,6 -> println("Turno diurno")
        }
        //También es posible usar expresiones como rangos,comparaciones,operaciones,instanciaciones...
        print("Introduzca un numero: ")
        val entrada= readln()!!.toInt() // <-- el operador !! evita q la entrada sea nula.
        when (entrada) {
            in 1..49 -> println("$entrada entre [1..49]")
            in 50..99 -> println ("$entrada entre [50..99]")
            else -> println("Fuera de los rangos contemplados")
        }
        // Cuando se quiere comparar expresiones booleanas sin tener un valor de comparación, entonces
        // el 'when' puede escribirse sin argumento:
        val a=-5
        when{
            a > 0 -> println("$a es positivo")
            a == 0 -> println("$a es cero")
            else -> println("Es negativo")
        }
        // Declaración de variable en el argumento del 'when'. Esta variable será de solo lectura.
        val playerLuck = 0.2
        val bonus = 0.3
        when (val damage:Double = playerLuck + bonus){
            in 0.0..0.3 -> println("Daño recibido: ${damage*10}")
            in 0.3..0.6 -> println("Daño recibido: ${damage*20}")
            in 0.6..1.0 -> println("Daño recibido: ${damage*30}")
        }
        //En ese ejemplo la variable damage solo es conocida (su 'ambito') dentro del bloque 'when'.Fuera de él no existe
        println(" === Supertipo ANY===")

    /* ===  Any es el tipo raíz de la jerarquia de tipos en Kotlin
     Es un supertipo de todos los tipos no nulos
     Al especificar un tipo como 'Any', indicamos q la variable puede contener cualquier valor no nulo
     Al usarlo, podemos combinar los tipos de datos, lo q significa q podemos tener varios tipos de
     datos en una colección.    ===*/
        // - Para comprobar el tipo de una variable con la expresion 'when' usamos el operador 'is'
        val formResponse:Any = 12
        when (formResponse) {
            is Int -> println("$formResponse es un Int")
            is String -> println("$formResponse es un String")
            is Boolean -> println("$formResponse es un Boolean")
        }
        println(" === FOR ===")
    /*=== El bucle FOR en Kotlin se asemeja al foreach de otros lenguajes ===*/
        //iterar un rango
        for (i in 1..5 ) print("$i, ")
        println(" ")

        //iterar un rango de chars
        for (char in 'a'..'z') print(char +", " )
        println(" ")

        //iterar con avance de 2, con la palabra reservada 'step'. Solo funciona con rangos
        for (char in 'a'..'z' step 2) print(char +", " )
        println(" ")

        //iterar un rango en reversa, con metodo .downTo()
        for (char in 'f'.downTo('a')) print(char+" ")
        println(" ")

        // iterar excluyendo el límite superior. En  este ejemplo va desde la 'a' hasta la 'e', porque
        // se excluye la 'f'
        for (char in 'a' until 'f') print(char +" ")
        println(" ")

        //iterar un String directamente
        var myString = "hello world"
        for (c in myString) print(c + "-")
        println(" ")

        println(" === WHILE ===")
        //como siempre, hay q declarar la variable de excepcion (i) antes del ciclo while
        var sum = 0
        var i = 1

        while (i <= 10) {
            sum += i++
        }
        println("Suma: $sum")

        println(" === DO WHILE ===")
        var again:Boolean

        do {
            println("Eligir una opción")
            println("1. Python")
            println("2. Java")
            println("3. Kotlin")
            println("4. Typescript")

            print("Respuesta: ")
            val userInput = readln().toIntOrNull() // Convierte a Int o devuelve null si no es un número
            // Si es null o no está entre 1 y 4, repetimos
            again = userInput == null || userInput !in 1..4
            if (again) {
                println("opcion no válida")
            } else {
                println("opcion $userInput valida")
            }
        }while (again)

        println(" === BREAK ===")
        // La expresion de salto 'break' solo se permite en el interior de los bucles.
        // Sirve para finalizar el bucle, sin necesidad de q se haya completado.
        while (true){
            println("Escribe salir para terminar el proceso")
            val userInput = readln().lowercase()
            if (userInput == "salir") break
        }
        println(" === BREAK ETIQUETADO===")
        val matriz = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 0),
        )
        //Se etiqueta con '@'
        Loop@ for (fila in matriz.indices) {
            for (columna in matriz[fila].indices) {
                if (matriz[fila][columna] == 0) {
                    println("Matriz inválida en [$columna,$fila]")
                    break@Loop //Si este break no tuviese la etiqueta, solo rompería el for de las columnas
                    //y seguiría iterando el for de las filas. Con esto, rompemos el loop for completo.
                }
            }
        }
        println(" === CONTINUE ===")
        //Permite saltar ciertas iteraciones de un ciclo y que siga iterando las restantes
        for (i in 1..20){
            if(i % 4 != 0){
                continue
            }
            println("$i")
        }

    }
