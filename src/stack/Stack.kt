package stack

import linkedList.LinkedList


//class Stack<T: Any>: StackImp<T> {
//    var storage=mutableListOf<T>()
//
//    override fun push(element: T) {
//    storage.add(element)
//    }
//
//    override fun pop(): T? {
//       return if (storage.isNotEmpty()){
//           storage.removeAt(storage.size-1)
//
//       }
//        else{
//            null
//        }
//     }
//
//    override fun peek(): T? {
//        return  storage.lastOrNull()
//
//     }
//
//    override fun size(): Int = storage.size
//     override fun isEmpty(): Boolean  = storage.isEmpty()
//}





class Stack <T: Any>: StackImp<T>{
    val storage=mutableListOf<T>()
    override fun push(element: T) {
storage.add(element)
    }

    override fun pop(): T? {

        return if (storage.isNotEmpty()){
            storage.removeAt(storage.size -1 )
        }else{
            null
        }
     }

    override fun peek(): T? {
            return storage.lastOrNull()
     }

    override fun size(): Int =  storage.size

    override fun isEmpty(): Boolean = storage.isEmpty()

}

fun Stack<String>.checkParentheses(string: String): Boolean{

    for(ch in string){
        if (ch =='('){
            this.push(ch.toString())

        }else if (ch ==')'){
            if (this.isEmpty()){
                return false
            }else{ this.pop()}
        }

    }

    return this.isEmpty()

}

fun  Stack<String>.reversed(string: String): String{

    for (i in string){
        this.push(i.toString())
    }

    var reversed=""
    while (!this.isEmpty()){
         reversed += this.pop()
    }
    return reversed

}

//fun Stack<Int>.check(string: String): Int?{
//    for (ch in string){
//
//        when{
//            ch.isDigit() ->this.push(ch.toString().toInt())
//            else -> {
//                val b =this.pop()
//                val a=this.pop()
//                val result = when(ch){
//                     '+' -> a?.plus(b  !!) ?: 0
//                      '-' -> a?.minus(b!!) ?: 0
//                     '*' -> a?.times(b!!) ?: 0
//                     '/'-> a?.div(b!!) ?: 0
//                    else -> { print("error")}
//                }
//                this.push(result as Int)
//            }
//        }
//    }
//    return this.pop()
//}


fun Stack<Int>.che(expression: String): Int?{

    for (ch in expression){
        when{
            ch.isDigit() -> this.push(ch.toString().toInt())
            else -> {
                if (this.size() <2) println("error")
                val b= this.pop()!!
                val a=this.pop()!!
                val result= when(ch){
                    '+' -> a +b
                    '-' -> a-b
                    '*' -> a*b
                    '/'  -> a /b

                    else -> {
                        IllegalArgumentException("error")
                    }
                }
                  this.push(result.toString().toInt())

            }
        }


    }
return this.pop()
}

fun <T: Any> LinkedList<T>.rever() {
    val stack= ArrayDeque<T>()
    var current=this.nodeAt(0)

    while (current !=null){

        stack.addFirst(current.value)
        current=current.next
    }
    while (stack.isNotEmpty()){
        println(stack.removeFirst())
    }


}































fun main() {
    val stack= Stack<String>()
    val stack2= LinkedList<Int>()
//  val value=  stack.checkParentheses("(()()()hi all)")
//
    stack2.push(1).push(2).push(3)
//    println(stack2)
    val x= stack2.rever()
    print(x)
}

























