package queue

interface QueueImp<T: Any> {
    
    fun enqueue(element:T)
    
    fun dequeue(): T?
    fun peek(): T?
    fun size(): Int
    fun isEmpty(): Boolean
    
}