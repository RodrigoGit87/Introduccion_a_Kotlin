package introduccion_Kotlin

/*
*Una coleccion es una estructura q agrupa objetos(elementos) relacionados en una sola unidad, permitiendo
* organizarlos y almacenarlos. Pueden ser de solo lectura (inmutables) o modificables (mutables)
*Kotlin soporta:
* - List: coleccion ordenada q permite duplicados
* - Set: coleccion desordenada pero de elementos únicos
* - Map: colecciones de pares clave:valor*/
fun main(){
    println(" == List ==")
    //listOf genera una lista inmutable, es decir no se puede modificar
    val sistemaSolar = listOf ("Mercurio","Venus","Tierra","Marte","Jupiter","Saturno","Urano","Neptuno")
    println(sistemaSolar.size)
    println(sistemaSolar.get(2))
    println(sistemaSolar.indexOf("Marte"))
    for (planeta in sistemaSolar) print (planeta+" ")
    println()

    //Para generar una lista mutable, usaremos mutableListOf()
    val listaMutable = mutableListOf("Mercurio","Venus","Tierra","Marte","Jupiter","Saturno","Urano","Neptuno")
    listaMutable.add("Plutón") //add añade el elemento al final de la lista
    listaMutable.add(5,"Theia") // add con un numero,lo añade en el indice del numero
    listaMutable.remove("Theia")
    listaMutable.set(8, "ton618") //.set modifica un elemento en el indice especificado
    for (p in listaMutable) print(p +" ")
    println()

    println(" == Set ==")
    // Set no permite elementos duplicados. Respecto a la inmutabilidad es igual q en List
    /* Set es la mejor opción cuando tu prioridad principal es asegurar la unicidad de los datos o
    realizar operaciones de teoría de conjuntos
    Por ejemplo, convertir una List en Set, permite "limpiar la lista de duplicados."*/

    val perifericos = mutableSetOf("monitor","ratón","teclado")
    println(perifericos.size)   // 3
    perifericos.add("mando gaming")
    perifericos.add("mando gaming") // Repetido, se ignora
    println(perifericos.size)   // 4
    for (i in perifericos) print(i +" ")
    perifericos.remove("mando gaming")
    println()

    println(" == Map ==")
    /* Los mapas son colecciones de clave:valor (key:value)
    * Las claves son únicas, pero los valores no lo son*/
    val score = mutableMapOf<String, Int>(
        "Player1" to 10,
        "Noobish_Pro" to 32,
        "Rosa_Melano" to 17,
        "Elber" to 4,
        "galarga" to 67
    )
    println(score.size) // 5
    score["Traitor"] = 10 // añadir directamente al map, la key entre corchetes y asignar el valor
    for (p in score) println(p)
    println()
    score.remove("Traitor")


    //Podemos aplicar la desestructuracion
    for ((jugador,victorias) in score){
        println("El jugador $jugador tiene $victorias victorias")
    }

}