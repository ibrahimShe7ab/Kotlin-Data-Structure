package linkedList

data class Node<T : Any>(val value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> $next"
        } else {
            "$value"
        }
    }
}


class LinkedList<T : Any> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0
        private set

    fun isEmpty() = size == 0

    fun push(value: T): LinkedList<T> {
        head = Node(value, head)
        if (tail == null) tail = head
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            return push(value)
        }
        val newNode = Node(value)
        tail?.next = newNode
        tail = newNode
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        if (index >= size) return null
        var current = head
        var i = 0
        while (i < index) {
            current = current?.next
            i++
        }
        return current
    }

    fun insertAt(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val newNode = Node(value, afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T? {
        if (isEmpty()) return null
        val result = head?.value
        head = head?.next
        size--
        if (isEmpty()) tail = null
        return result
    }

    fun removeLast(): T? {
        if (head?.next == null) return pop()

        var prev = head
        var current = head?.next

        while (current?.next != null) {
            prev = current
            current = current.next
        }

        prev?.next = null
        tail = prev
        size--
        return current?.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value
        if (node.next == tail) tail = node
        node.next = node.next?.next
        size--
        return result
    }

    override fun toString(): String {
        return head?.toString() ?: "Empty List"
    }
}


//reversed
//getMiddle
//cycle
//mergeSort



fun <T: Any> LinkedList<T>.printInReversed(){
    this.nodeAt(0)?.printNodeReversed()

}


fun <T: Any> Node<T>.printNodeReversed(){
    this.next?.printNodeReversed()
    if (this.next !=null) print("->")
    print(this.value.toString())
}

fun <T: Any> LinkedList<T>.cycle(): Boolean{
    var fast=this.nodeAt(0)
    var slow=this.nodeAt(0)

    while (fast !=null &&fast.next!=null){
        slow=slow?.next
        fast=fast.next?.next
    }
    return fast == slow
}

fun <T: Any> LinkedList<T>.getMiddle(){
    var fast=this.nodeAt(0)
    var slow=this.nodeAt(0)
    while (fast!=null){
        fast=fast.next
        if (fast !=null){
            slow=slow?.next
            fast=fast.next

        }
    }
    println("the middle is equal : ${slow?.value}")

}
fun <T: Any> LinkedList<T>.mergeSort(l1: Node<Int>?,l2: Node<Int>?): Node<Int>?{

    if (l1 ==null) return l2
    if (l2 ==null) return l1

    return if (l1.value <l2.value){
        l1.next=mergeSort(l1.next,l2)
        l1
    }else{
        l2.next=mergeSort(l2.next,l1)
        l2

    }


}

fun<T: Any> LinkedList<T>.removeDuplicated(){
    var current=this.nodeAt(0)
    while (current?.next!=null){
        if (current.value ==current.next?.value ){
            current.next=current.next?.next
        } else{
            current=current.next
        }
    }
}


































