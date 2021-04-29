package com.asustuf.discretemathlab1.model

class SetsOperations {

    companion object {
        fun union(set1: Set<Char>, set2: Set<Char>) = (set1 + set2).toSortedSet()
        fun difference(set1: Set<Char>, set2: Set<Char>) = (set1 - set2).toSortedSet()
        fun intersection(set1: Set<Char>, set2: Set<Char>) = set1.toSortedSet().apply {
            this.removeIf {
                !set2.contains(it)
            }
        }
        fun symmetricDifference(set1: Set<Char>, set2: Set<Char>) =
            difference(union(set1, set2), intersection(set1, set2))
        fun isSubset(set1: Set<Char>, set2: Set<Char>) = set1.toSortedSet().containsAll(set2)
    }

}