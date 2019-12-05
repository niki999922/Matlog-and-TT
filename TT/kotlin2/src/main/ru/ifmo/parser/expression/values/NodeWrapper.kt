package ru.ifmo.parser.expression.values

import ru.ifmo.A
import ru.ifmo.Painter
import ru.ifmo.parser.Node

data class NodeWrapper(var node: Node) : Node {
    var parentNode: Node? = null
    var parentCount = 0

    var debug_i = lazy {
        ++Node.debug_ind
    }

    override fun debugInd() = debug_i.value

    override fun node() = "Variable Wrapper"

    override fun printNode():String {
        while (node is NodeWrapper && node.getValueParentCount() == parentCount) {
            (node as NodeWrapper).node.setParent(this)
            node = (node as NodeWrapper).node
        }

        return node.printNode()
    }

    override fun leftChild() = node

    override fun rightChild(): Node? = null

    override fun parent(): Node? = parentNode

    override fun setParent(node: Node) {
        parentNode = node
    }
    override fun addParentCount() {
        ++parentCount
    }

    override fun subParentCount() {
        --parentCount
    }
    override fun setValueParentCount(value: Int) {
        parentCount = value
    }


    override fun getBReduction(): Node? {
        while (node is NodeWrapper && node.getValueParentCount() == parentCount) {
            (node as NodeWrapper).node.setParent(this)
            node = (node as NodeWrapper).node
        }
        return node.getBReduction()
    }

    override fun createCopy(): Node {
        var copy = node.createCopy()
        copy.setParent(this)
        return copy
    }

    override fun openWrapper(listNode: MutableSet<NodeWrapper>): Node {
        node = node.openWrapper(listNode)
        return this
    }
    override fun getValueParentCount() = parentCount

    override fun normalizeLinks(listNode: MutableMap<String, NodeWrapper>) {
        node.normalizeLinks(listNode)
        node.addParentCount()
//        Painter.draw(A.treeMy!!) //debug
//        Painter.draw(this) //debug
    }

    override fun normalizeLambdaLink(lambdaArgument: NodeWrapper) {
        node.normalizeLambdaLink(lambdaArgument)
    }

    override fun renameLambdaVariables() = node.renameLambdaVariables()

    override fun newRenameLambdaVariables(listNode: MutableMap<String, String>) {
        node.newRenameLambdaVariables(listNode)
    }

    override fun bReduction() {}

    override fun oldCreateCopy(listNode: MutableMap<String, NodeWrapper>): Node {
        return node.oldCreateCopy(listNode)
    }
}