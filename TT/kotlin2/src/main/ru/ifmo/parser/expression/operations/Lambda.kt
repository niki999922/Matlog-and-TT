package ru.ifmo.parser.expression.operations

import ru.ifmo.parser.Node
import ru.ifmo.parser.expression.values.Variable
import ru.ifmo.parser.expression.values.NodeWrapper

class Lambda(var left: Node, var right: Node) : Node {
    var parentCount = 0
    var debug_i = lazy {
        ++Node.debug_ind
    }

    override fun debugInd() = debug_i.value

    override fun node() = "Lambda"

    override fun leftChild() = left

    override fun rightChild() = right

    override fun printNode(): String {
        while (right is NodeWrapper && right.getValueParentCount() == parentCount) {
            right = (right as NodeWrapper).node
        }

        return "(\\${left.printNode()}.${right.printNode()})"
    }

    override fun getBReduction(nodeTmp: NodeWrapper): Node? {
        while (right is NodeWrapper && right.getValueParentCount() == parentCount) {
            right = (right as NodeWrapper).node
        }

        nodeTmp.node = this
        return right.getBReduction(nodeTmp)
    }

    override fun createCopy(): Node {
        var l = left.createCopy()
        var r = right.createCopy()
        return Lambda(l, r)
    }

    override fun addParentCount() {
        ++parentCount
    }

    override fun getValueParentCount() = parentCount

    override fun normalizeNamesLambda(listName: MutableMap<String, String>) {
        val leftVariable = left as Variable
        leftVariable.addParentCount()
        val oldVariableWrapper = listName[leftVariable.node]

        val newName = "vtyh56${Node.indexVariable}"
        ++Node.indexVariable
        val oldName = leftVariable.node

        leftVariable.node = newName

        listName[oldName] = newName

        if (right is Variable) {
            val rightVar = right as Variable
            listName[rightVar.node].let {
                if (it == null) return@let
                rightVar.node = it
            }
        } else {
            right.normalizeNamesLambda(listName)
        }
        right.addParentCount()

        if (oldVariableWrapper != null) {
            listName[oldName] = oldVariableWrapper
        } else {
            listName.remove(oldName)
        }
    }

    override fun setWrapperInVariable(name: String, nodeWrapper: NodeWrapper) {
        if ((left as Variable).node == name) return
        if (right is Variable) {
            val rightVar = right as Variable
            if (rightVar.node == name) {
                right = nodeWrapper
                right.addParentCount()
            }
        } else {
            right.setWrapperInVariable(name,nodeWrapper)
        }
    }

    override fun bReduction(parent: Node) {}
}