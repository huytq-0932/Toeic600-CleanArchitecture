package vn.sun.asterisk.common

fun <T> executeTheSameAction(vararg elements: T, action: (T) -> Unit) {
    elements.forEach(action)
}
