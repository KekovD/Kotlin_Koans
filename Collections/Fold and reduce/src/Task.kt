// Returns the set of products that a customer has ordered
fun Customer.getOrderedProducts(): Set<Product> =
    orders.flatMap { it.products }.toSet()

// Returns the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> =
    customers.map { it.getOrderedProducts() }
        .reduceOrNull { acc, products -> acc.intersect(products) } ?: emptySet()
