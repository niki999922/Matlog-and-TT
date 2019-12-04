package ru.ifmo.parser.expression.operations

import ru.ifmo.A
import ru.ifmo.Painter
import ru.ifmo.parser.Node
import ru.ifmo.parser.expression.values.Variable
import ru.ifmo.parser.expression.values.NodeWrapper

class Application(private var left: Node, private var right: Node) : Node {
    var parentNode: Node? = null
    var debug_i = lazy {
        ++Node.debug_ind
    }

    override fun debugInd() = debug_i.value

    override fun node() = "Application"

    override fun leftChild() = left

    override fun rightChild() = right

    override fun parent(): Node? = parentNode

    override fun setParent(node: Node) {
        parentNode = node
    }

    override fun printNode() = "(${left.printNode()} ${right.printNode()})"

    override fun getBReduction(): Node? {
//        if (left is NodeWrapper) {
//            while ((left as NodeWrapper).node is NodeWrapper) {
//                (left as NodeWrapper).node = ((left as NodeWrapper).node as NodeWrapper).node
//            }
//            (left as NodeWrapper).node.setParent(left)
//        }
//        if (right is NodeWrapper) {
//            while ((right as NodeWrapper).node is NodeWrapper) {
//                (right as NodeWrapper).node = ((right as NodeWrapper).node as NodeWrapper).node
//            }
//            (right as NodeWrapper).node.setParent(right)
//        }


//        while (left is NodeWrapper) {
//            left = left.leftChild()!!
//        }
//        while (right is NodeWrapper) {
//            right = right.leftChild()!!
//        }

        if (left is Lambda) {
            var copy = (left as Lambda).createCopy()
            copy.setParent(this)
            left = copy
            left.normalizeLinks(mutableMapOf())
            left.renameLambdaVariables()//delete

            return this
        }
        if (left is NodeWrapper) {
            var l = left as NodeWrapper
            while (l.node is NodeWrapper) {
                l = l.node as NodeWrapper
            }
            if (l.node is Lambda) {
                var copy = (left as NodeWrapper).node.createCopy()
                copy.setParent(this)
                left = copy
                left.normalizeLinks(mutableMapOf())
                left.renameLambdaVariables()//delete
                return this
            }



//            if ((left as NodeWrapper).node is Lambda) {
//                var copy = (left as NodeWrapper).node.createCopy()
//                copy.setParent(this)
//                left = copy
//                left.normalizeLinks(mutableMapOf())
//                left.renameLambdaVariables()    //need remove??????????????????
//                (left as NodeWrapper).node.setParent(this)
//                left = (left as NodeWrapper).node
//                return this
//            }
        }

        return left.getBReduction() ?: right.getBReduction()
    }

    override fun createCopy(): Node {
        var l = left.createCopy()
        var r = right.createCopy()
        l.setParent(this)
        r.setParent(this)

        return Application(l, r)
    }

    override fun openWrapper(listNode: MutableSet<NodeWrapper>) : Node {
//        if (!listNode.contains(left) && left is NodeWrapper) {
            while (!listNode.contains(left as NodeWrapper) && left is NodeWrapper) {
//        if (!listNode.contains(left) && left is NodeWrapper) {
                left = left.leftChild()!!
            }

//        }

        while (!listNode.contains(right) && right is NodeWrapper) {
//        if (!listNode.contains(right) && right is NodeWrapper) {
            right = right.leftChild()!!
        }


//        if (!listNode.contains(left)) {
////            if (left.leftChild() is Application)
//            left = left.leftChild()!!
//        }
//
//        if (!listNode.contains(right)) {
//            right = right.leftChild()!!
//        }

//        left.openWrapper(listNode)
//        right.openWrapper(listNode)
        return Application(left.openWrapper(listNode),right.openWrapper(listNode))
    }

    override fun normalizeLinks(listNode: MutableMap<String, NodeWrapper>) {
        if (left is Variable) {
            val leftVar = left as Variable
            listNode[leftVar.printNode()].let {
                if (it == null) return@let
                if (leftVar.printNode() == it.leftChild().printNode()) {
                    left = it
                }
            }
        } else {
            left.normalizeLinks(listNode)
        }


        if (right is Variable) {
            val rightVar = right as Variable
            listNode[rightVar.printNode()].let {
                if (it == null) return@let
                if (rightVar.printNode() == it.leftChild().printNode()) {
                    right = it
                }
            }
        } else {
            right.normalizeLinks(listNode)
        }
        left.setParent(this)
        right.setParent(this)
//        Painter.draw(A.treeMy!!) //debug
//        Painter.draw(this) //debug
    }

    override fun renameLambdaVariables() {
        left.renameLambdaVariables()
        right.renameLambdaVariables()
    }

    override fun newRenameLambdaVariables(listNode: MutableMap<String, String>) {
        left.newRenameLambdaVariables(listNode)
        right.newRenameLambdaVariables(listNode)
    }

    override fun bReduction() {
        val leftLambda = left as Lambda
//        leftLambda.normalizeLinks(mutableMapOf()) //!!!!!!!!!!!!!!!!!!!!
        val lambdaArgWrapper = (leftLambda.leftChild() as NodeWrapper)

//        leftLambda.right = leftLambda.right.openWrapper(mutableSetOf(lambdaArgWrapper))


//        if (right is NodeWrapper) {
//            (right as NodeWrapper).node.setParent(lambdaArgWrapper) //????
//            lambdaArgWrapper.node = (right as NodeWrapper).node
//        } else {
            right.setParent(lambdaArgWrapper)
            lambdaArgWrapper.node = right
//        }


        if (parentNode != null) {
            if (parentNode is NodeWrapper) {
//                var tmp: Node = parentNode as NodeWrapper
//                while (tmp is NodeWrapper && tmp.parent() != null) {
//                    tmp = tmp.parentNode!!
//                }
//                if (tmp is Application) {
//                    tmp.left = leftLambda.rightChild()
//                    leftLambda.rightChild().setParent(tmp)
//                    return
//                }
//                if (tmp is Lambda) {
//                    tmp.right = leftLambda.rightChild()
//                    leftLambda.rightChild().setParent(tmp)
//                    return
//                }
//                if (tmp is NodeWrapper) {
//                    tmp.node = leftLambda.rightChild()
//                    leftLambda.rightChild().setParent(tmp)
//                    return
//                }
//
//                return

                var prevPar = parentNode as NodeWrapper
//                var sonPar = leftLambda.right

                (parentNode as NodeWrapper).node = leftLambda.right
//                leftLambda.rightChild().setParent(parentNode!!)
                leftLambda.rightChild().setParent(prevPar)
//                leftLambda.rightChild().setParent(parentNode as NodeWrapper)
//                (parentNode as NodeWrapper).node = leftLambda.rightChild()
                return
            }
            if (parentNode is Application) {
//                leftLambda.rightChild().setParent(parentNode!!)
//                (parentNode as NodeWrapper).node = sonPar

                var prevApl = parentNode as Application
                if ((parentNode as Application).leftChild() === this) {
                    (parentNode as Application).left = leftLambda.rightChild()
                } else {
                    (parentNode as Application).right = leftLambda.rightChild()
                }
//                (parentNode as Application).left = leftLambda.rightChild()
                leftLambda.rightChild().setParent(prevApl)
                return
            }
            if (parentNode is Lambda) {
                var prevLam = parentNode as Lambda
                (parentNode as Lambda).right = leftLambda.rightChild()
                leftLambda.rightChild().setParent(prevLam)
                return
            }


        } else {

            println("Wow b redux from root")
        }
//        leftLambda.rightChild().openWrapper(mutableSetOf(lambdaArgWrapper))

    }

    override fun oldCreateCopy(listNode: MutableMap<String, NodeWrapper>): Node {
        if (left is Variable) {
            val leftVar = left as Variable
            listNode[leftVar.printNode()].let {
                if (it == null) return@let
                if (leftVar.printNode() == it.leftChild().printNode()) {
                    left = it
                }
            }
        } else {
            left.oldCreateCopy(listNode)
        }

        if (right is Variable) {
            val rightVar = right as Variable
            listNode[rightVar.printNode()].let {
                if (it == null) return@let
                if (rightVar.printNode() == it.leftChild().printNode()) {
                    right = it
                }
            }
        } else {
            right.oldCreateCopy(listNode)
        }

//        left.setParent(this)
//        right.setParent(this)

        return Application(left.oldCreateCopy(listNode),right.oldCreateCopy(listNode))
    }
}