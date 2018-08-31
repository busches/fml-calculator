package com.fml.calculator

// Based on https://rosettacode.org/wiki/Combinations_with_repetitions#Kotlin
class CombosWithReps<T>(private val comboSize: Int, private val items: List<T>) {
    private val combination = IntArray(comboSize)
    private var count = 0
    private val itemsSize = items.size
    private val comboList = ArrayList<ArrayList<T>>()

    init {
        generate(0)
        println("There are $count combinations of $itemsSize things taken $comboSize at a time with repetitions")
    }

    fun getComboList() = comboList

    private fun generate(k: Int) {
        if (k >= comboSize) {
            val combo = ArrayList<T>()
            for (i in 0 until comboSize) {
                combo.add(items[combination[i]])
            }
            comboList.add(combo)
            count++
        } else {
            for (j in 0 until itemsSize)
                if (k == 0 || j >= combination[k - 1]) {
                    combination[k] = j
                    generate(k + 1)
                }
        }
    }
}
