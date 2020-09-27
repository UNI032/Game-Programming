val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun main() {
    //eager, creates a new list
    val eager = decorations.filter { it[0] == 'p'}
    println("1. eager: $eager")

    //lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] =='p' }
    println("2. filtered: $filtered")

    val newList = filtered.toList()
    println("2. new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("3. access: $it")
        it
    }

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")
    val lst = lazyMap.toList()
    println("lazymap : $lst")
}