package stack

interface StackImp<T: Any> {

    fun push(element:T)
    fun pop():T?
    fun peek():T?

    fun size(): Int
    fun isEmpty(): Boolean



}