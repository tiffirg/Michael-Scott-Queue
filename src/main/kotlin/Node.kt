package org.example

import java.util.concurrent.atomic.AtomicReference

class Node<T>(
    val value: T?,
    var next: AtomicReference<Node<T>?> = AtomicReference(null)
)