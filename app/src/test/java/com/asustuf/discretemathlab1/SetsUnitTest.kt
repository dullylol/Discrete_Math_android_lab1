package com.asustuf.discretemathlab1

import com.asustuf.discretemathlab1.model.SetsOperations
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SetsUnitTest {
//    @Test
//    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
//    }

    private val a = setOf('a', 'b', 'c', 'd', 'e')
    private val b = setOf('c', 'd', 'e', 'f', 'g', 'h')

    @Test
    fun sets_union() {
        println(SetsOperations.union(a, b))
    }

    @Test
    fun sets_intersection() {
        println(SetsOperations.intersection(a, b))
    }

    @Test
    fun sets_difference() {
        println(SetsOperations.difference(a, b))
    }

    @Test
    fun sets_symmetricDifference() {
        println(SetsOperations.symmetricDifference(a, b))
    }
}