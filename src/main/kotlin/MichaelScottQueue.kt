package org.example

import java.util.concurrent.atomic.AtomicReference

class MichaelScottQueue<T> {
    private val blank = Node<T>(null)
    private val head = AtomicReference(blank)
    private val tail = AtomicReference(blank)

    fun push(unit: T) {
        val node = Node(unit)
        while (true) {
            val nowTail = tail.get()
            val nextNode = nowTail.next.get()
            if (nowTail.next.compareAndSet(null, node)) {
                tail.compareAndSet(nowTail, node)
                break
            } else {
                tail.compareAndSet(nowTail, nextNode)
            }
        }
    }

    fun pop(): T? {
        while (true) {
            val nowHead = head.get()
            val nowTail = tail.get()
            val nextNode = nowHead.next.get()
            val value = nextNode?.value
            if (nowHead == nowTail) {
                tail.compareAndSet(nowTail, nextNode)
            } else if (head.compareAndSet(nowHead, nextNode)) {
                return value
            }
        }
    }
}
