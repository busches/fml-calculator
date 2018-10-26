package com.fml.calculator

object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        val movies = this::class.java.classLoader.getResource("movies.csv")
            .readText()
            .split("\n")
            .map { it.split(",") }
            .map { Movie(it[0], Integer.parseInt(it[1].trim()), Integer.parseInt(it[2].trim())) }

        CombosWithReps(8, movies).getComboList()
            .map { MovieTheater(it) }
            .filter { it.totalCost() <= 1000 }
            .groupBy { it.totalRevenue() }
            .toSortedMap()
            .toList()
            .asReversed()
            .take(5)
            .forEach { println(it) }

    }
}
