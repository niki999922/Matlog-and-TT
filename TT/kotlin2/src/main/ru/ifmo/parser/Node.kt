package ru.ifmo.parser

import ru.ifmo.parser.expression.values.NodeWrapper


interface Node {
    fun node(): String
    fun leftChild() : Node?
    fun rightChild() : Node?
    fun printNode() : String
    fun bReduction(parent: Node)
    fun createCopy() : Node
    fun getBReduction(nodeTmp: NodeWrapper): Node?
    fun addParentCount()
    fun getValueParentCount():Int
    fun normalizeNamesLambda(listName: MutableMap<String, String>)
    fun setWrapperInVariable(name: String, nodeWrapper: NodeWrapper)
    fun debugInd():Int

    companion object {
        var indexVariable = 0
        var debug_ind = 0
    }
}