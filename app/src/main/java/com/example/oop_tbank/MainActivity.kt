package com.example.oop_tbank

interface Animal {
    val weight: Double
    val age: Int
    fun animalType(): String
}

interface Dog : Animal {
    val bite: BiteType
    override fun animalType(): String {
        return "Собака"
    }
}

interface Cat : Animal {
    val behavior: BehaviorType
    override fun animalType(): String {
        return "Кошка"
    }
}

enum class BiteType {
    STRAIGHT, OVERSHOT, UNDERSHOT
}

enum class BehaviorType {
    ACTIVE, PASSIVE
}

class Husky(
    override val weight: Double,
    override val age: Int,
    override val bite: BiteType,
) : Dog

class Corgi(
    override val weight: Double,
    override val age: Int,
    override val bite: BiteType
) : Dog

class ScottishCat(
    override val weight: Double,
    override val age: Int,
    override val behavior: BehaviorType
) : Cat

class SiamCat(
    override val weight: Double,
    override val age: Int,
    override val behavior: BehaviorType
) : Cat

class ZooShop {
    fun determineAnimal(animal: Animal): String {
        return animal.animalType()
    }
}

fun main() {
    val husky = Husky(
        weight = 15.4,
        age = 5,
        bite = BiteType.OVERSHOT
    )
    val corgi = Corgi(
        weight = 7.3,
        age = 2,
        bite = BiteType.STRAIGHT
    )
    val scottish = ScottishCat(
        weight = 2.2,
        age = 1,
        behavior = BehaviorType.ACTIVE
    )
    val siam = SiamCat(
        weight = 4.1,
        age = 6,
        behavior = BehaviorType.PASSIVE
    )
    val zooShop = ZooShop()
    println("Хаски - это ${zooShop.determineAnimal(husky)}")
    println("Корги - это ${zooShop.determineAnimal(corgi)}")
    println("Скотти - это ${zooShop.determineAnimal(scottish)}")
    println("Сиам - это ${zooShop.determineAnimal(siam)}")
}

