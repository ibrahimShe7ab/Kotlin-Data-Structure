package queue

import stack.Stack

class Queue<T: Any>: QueueImp<T> {
   val queue=arrayListOf<T>()
    override fun enqueue(element: T) {
    queue.add(element)
     }

    override fun dequeue(): T?=if (queue.isEmpty()) {null}else queue.removeAt(0)


    override fun peek(): T? {
   return queue.firstOrNull()

     }

    override fun size(): Int =queue.size

    override fun isEmpty(): Boolean =size() ==0
}


fun <T:Any> Queue<T>.lastPlayer():T?{
    val result=this.dequeue()

    this.enqueue(result as T)

    return result
}

fun<T: Any> Queue<T>.reversed(){
    val stack= Stack<T>()
    var next=this.dequeue()
    while (next !=null){
        stack.push(next)
        next=this.dequeue()
    }

    next=stack.pop()
    while (next !=null){
        this.enqueue(next)
        next=stack.pop()
    }




}




















