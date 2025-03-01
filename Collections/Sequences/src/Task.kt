// Find the most expensive product among all the delivered products ordered by the customer.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders
        .filter { it.isDelivered }
        .asSequence()
        .flatMap { it.products.asSequence() }
        .maxByOrNull { it.price }
}

// Count the amount of times a product was ordered.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.sumOf { customer ->
        customer.orders.sumOf { order ->
            order.products.count { it == product }
        }
    }
}

// Get all ordered products (including duplicates) using a sequence.
fun Customer.getOrderedProducts(): Sequence<Product> =
    orders.asSequence().flatMap { it.products.asSequence() }
