package ru.ifmo.parser.expression.operations

import ru.ifmo.parser.Node
import ru.ifmo.parser.expression.values.Variable
import ru.ifmo.parser.expression.values.NodeWrapper

class Application(var left: Node, var right: Node) : Node {
    var parentNode: Node? = null
    var parentCount = 0
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

    override fun addParentCount() {
        ++parentCount
    }

    override fun subParentCount() {
        --parentCount
    }

    override fun printNode(): String {
        while (left is NodeWrapper && left.getValueParentCount() == parentCount) {
            (left as NodeWrapper).node.setParent(this)
            left = (left as NodeWrapper).node
        }

        while (right is NodeWrapper && right.getValueParentCount() == parentCount) {
            (right as NodeWrapper).node.setParent(this)
            right = (right as NodeWrapper).node
        }

        return "(${left.printNode()} ${right.printNode()})"
    }

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


//05.12
        while (left is NodeWrapper && left.getValueParentCount() == parentCount) {
            (left as NodeWrapper).node.setParent(this)
            left = (left as NodeWrapper).node
        }

        while (right is NodeWrapper && right.getValueParentCount() == parentCount) {
            (right as NodeWrapper).node.setParent(this)
            right = (right as NodeWrapper).node
        }

//not work this 26 tl
        if (right is Application) {
            var r = right as Application
            if (r.left is NodeWrapper && left is NodeWrapper && ((left as NodeWrapper).node === (r.left as NodeWrapper).node)) {
                r.left = left
            }
        }


        if (right is Application) {
            var r = right as Application
            if (r.right is NodeWrapper && left is NodeWrapper && ((left as NodeWrapper).node === (r.right as NodeWrapper).node)) {
                r.right = left
            }
        }


        if (left is Application) {
            var l = left as Application
            if (l.left is NodeWrapper && right is NodeWrapper && ((right as NodeWrapper).node === (l.left as NodeWrapper).node)) {
                l.left = right
            }
        }


        if (left is Application) {
            var l = left as Application
            if (l.right is NodeWrapper && right is NodeWrapper && ((right as NodeWrapper).node === (l.right as NodeWrapper).node)) {
                l.right = right
            }
        }


//not work this
//        if (left is Application){
//            var l = left as Application
//            while (l.right is NodeWrapper && right is NodeWrapper && ((right as NodeWrapper).node === (l.right as NodeWrapper).node)) {
//                    l.right = right
//            }
//        }
//
//        if (left is Application){
//            var r = left as Application
//            while (r.left is NodeWrapper && left is NodeWrapper && ((left as NodeWrapper).node === (r.left as NodeWrapper).node)) {
//                    r.left = left
//            }
//        }
//
//
//        if (right is Application){
//            var l = right as Application
//            while (l.right is NodeWrapper && right is NodeWrapper && ((right as NodeWrapper).node === (l.right as NodeWrapper).node)) {
//                    l.right = right
//            }
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
            left.addParentCount()


//            var lam = left as Lambda
//            var newWr = NodeWrapper(lam.left)
//            lam.left = newWr
//            newWr.node.setParent(newWr)
//            lam.right.normalizeLambdaLink(newWr)

//            left.normalizeLinks(mutableMapOf())
//            left.renameLambdaVariables()//delete
            left.normalizeNamesLambda(mutableMapOf())
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
                left.addParentCount()


//                var lam = left as Lambda
//                var newWr = NodeWrapper(lam.left)
//                lam.left = newWr
//                newWr.node.setParent(newWr)
//                lam.right.normalizeLambdaLink(newWr)


//                left.normalizeLinks(mutableMapOf())
//                left.renameLambdaVariables()//delete
                left.normalizeNamesLambda(mutableMapOf())
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

    override fun setValueParentCount(value: Int) {
        parentCount = value
    }

    override fun openWrapper(listNode: MutableSet<NodeWrapper>): Node {
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
        return Application(left.openWrapper(listNode), right.openWrapper(listNode))
    }

    override fun getValueParentCount() = parentCount

    override fun deleteNaxerWrappers() {
        while (left is NodeWrapper && left.getValueParentCount() == parentCount) {
            (left as NodeWrapper).node.setParent(this)
            left = (left as NodeWrapper).node
        }

        while (right is NodeWrapper && right.getValueParentCount() == parentCount) {
            (right as NodeWrapper).node.setParent(this)
            right = (right as NodeWrapper).node
        }


        if (right is Application) {
            var r = right as Application
            if (r.left is NodeWrapper && left is NodeWrapper && ((left as NodeWrapper).node === (r.left as NodeWrapper).node)) {
                r.left = left
            }
        }


        if (right is Application) {
            var r = right as Application
            if (r.right is NodeWrapper && left is NodeWrapper && ((left as NodeWrapper).node === (r.right as NodeWrapper).node)) {
                r.right = left
            }
        }


        if (left is Application) {
            var l = left as Application
            if (l.left is NodeWrapper && right is NodeWrapper && ((right as NodeWrapper).node === (l.left as NodeWrapper).node)) {
                l.left = right
            }
        }


        if (left is Application) {
            var l = left as Application
            if (l.right is NodeWrapper && right is NodeWrapper && ((right as NodeWrapper).node === (l.right as NodeWrapper).node)) {
                l.right = right
            }
        }


        left.deleteNaxerWrappers()
        right.deleteNaxerWrappers()
    }


    override fun normalizeLinks(listNode: MutableMap<String, NodeWrapper>) {

        if (left is Variable) {
            val leftVar = left as Variable
            listNode[leftVar.printNode()].let {
                if (it == null) return@let
                if (leftVar.printNode() == it.leftChild().printNode()) {
                    left = it
                    left.addParentCount()

                }
            }
        } else {
            left.setParent(this)
            left.normalizeLinks(listNode)
            left.addParentCount()
        }


        if (right is Variable) {
            val rightVar = right as Variable
            listNode[rightVar.printNode()].let {
                if (it == null) return@let
                if (rightVar.printNode() == it.leftChild().printNode()) {
                    right = it
                    right.addParentCount()
                }
            }
        } else {
            right.normalizeLinks(listNode)
            right.setParent(this)
            right.addParentCount()
        }
//        left.setParent(this)
//        right.setParent(this)

//        Painter.draw(A.treeMy!!) //debug
//        Painter.draw(this) //debug
    }

    override fun normalizeLambdaLink(lambdaArgument: NodeWrapper) {
        if (left is Variable) {
            if (left.printNode() == lambdaArgument.printNode()) {
                left = lambdaArgument
            }
        } else {
            left.normalizeLambdaLink(lambdaArgument)
            left.setParent(this)
        }


        if (right is Variable) {
            if (right.printNode() == lambdaArgument.printNode()) {
                right = lambdaArgument
            }
        } else {
            right.normalizeLambdaLink(lambdaArgument)
            right.setParent(this)
        }
    }

    override fun renameLambdaVariables() {
        left.renameLambdaVariables()
        right.renameLambdaVariables()
    }

    override fun normalizeNamesLambda(listName: MutableMap<String, String>) {
        if (left is Variable) {
            val leftVar = left as Variable
            listName[leftVar.node].let {
                if (it == null) return@let
                leftVar.node = it
                leftVar.addParentCount()
                leftVar.setParent(this)
            }
        } else {
            left.normalizeNamesLambda(listName)
            left.setParent(this)
            left.addParentCount()
        }


        if (right is Variable) {
            val rightVar = right as Variable
            listName[rightVar.node].let {
                if (it == null) return@let
                rightVar.node = it
                rightVar.addParentCount()
                rightVar.setParent(this)
            }
        } else {
            right.normalizeNamesLambda(listName)
            right.setParent(this)
            right.addParentCount()
        }
    }

    override fun setWrapperInVariable(name: String, nodeWrapper: NodeWrapper) {
        if (left is Variable) {
            val leftVar = left as Variable
            if (leftVar.node == name) {
                left = nodeWrapper
                left.addParentCount()
            }
        } else {
            left.setWrapperInVariable(name, nodeWrapper)
        }

        if (right is Variable) {
            val rightVar = right as Variable
            if (rightVar.node == name) {
                this.right = nodeWrapper
                right.addParentCount()
            }
        } else {
            right.setWrapperInVariable(name, nodeWrapper)
        }
    }

    override fun newRenameLambdaVariables(listNode: MutableMap<String, String>) {
        left.newRenameLambdaVariables(listNode)
        right.newRenameLambdaVariables(listNode)
    }

    override fun bReduction() {
        val leftLambda = left as Lambda
//        leftLambda.normalizeLinks(mutableMapOf()) //!!!!!!!!!!!!!!!!!!!!
//        val lambdaArg = (leftLambda.leftChild() as NodeWrapper)
        val lambdaArg = (leftLambda.leftChild() as Variable)

//        lambdaArgWrapper.subParentCount()
//        lambdaArgWrapper.node.subParentCount()
//        leftLambda.right = leftLambda.right.openWrapper(mutableSetOf(lambdaArgWrapper))


//        if (right is NodeWrapper && ((right as NodeWrapper).node is NodeWrapper)) {
        //NEVER HERE
//            var r1 = (right as NodeWrapper)
//            var r2 = ((right as NodeWrapper).node as NodeWrapper)

//on
//            r2.setParent(this)
//            right = r2

//without different
//            r2.node.setParent(r1)
//            r1.node = r2.node

//            (right as NodeWrapper).node.setParent(lambdaArgWrapper) //????
//            lambdaArgWrapper.node = (right as NodeWrapper).node

//
//        } else {
//            right.setParent(lambdaArg)
//            lambdaArg.node = right
//        }


        val newWrapper = NodeWrapper(right)
        right.setParent(newWrapper)
        if (leftLambda.right is Variable) {
            val rightVar = leftLambda.right as Variable
            if (rightVar.node == lambdaArg.node) {
                leftLambda.right = newWrapper
                leftLambda.right.addParentCount()
//                leftLambda.right.setParent(leftLambda)
            }
        } else {
            leftLambda.right.setWrapperInVariable(lambdaArg.node, newWrapper)
        }
//        leftLambda.right.setParent(leftLambda)

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
                leftLambda.right.deleteNaxerWrappers()
                return
            }
            if (parentNode is Application) {
//                leftLambda.rightChild().setParent(parentNode!!)
//                (parentNode as NodeWrapper).node = sonPar

                var prevApl = parentNode as Application
                if ((parentNode as Application).leftChild() === this) {
                    (parentNode as Application).left = leftLambda.rightChild()
                    (parentNode as Application).left.deleteNaxerWrappers()
                } else {
                    (parentNode as Application).right = leftLambda.rightChild()
                    (parentNode as Application).right.deleteNaxerWrappers()
                }
//                (parentNode as Application).left = leftLambda.rightChild()
                leftLambda.rightChild().setParent(prevApl)

                return
            }
            if (parentNode is Lambda) {
                var prevLam = parentNode as Lambda
                (parentNode as Lambda).right = leftLambda.rightChild()
                leftLambda.rightChild().setParent(prevLam)
                leftLambda.rightChild().deleteNaxerWrappers()
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

        return Application(left.oldCreateCopy(listNode), right.oldCreateCopy(listNode))
    }
}