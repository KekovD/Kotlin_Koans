class LazyProperty(val initializer: () -> Int) {
    private var initialized = false
    private var value: Int? = null

    val lazy: Int
        get() {
            if (!initialized) {
                value = initializer()
                initialized = true
            }
            return value!!
        }
}

