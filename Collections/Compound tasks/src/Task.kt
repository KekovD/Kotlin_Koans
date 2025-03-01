// Find the most expensive product among all the delivered products ordered by the customer
fun findMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders.filter { it.isDelivered }
        .flatMap { it.products }
        .maxByOrNull { it.price }

// Count the number of times a product was ordered across all customers
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
    customers.sumOf { customer ->
        customer.orders.sumOf { order ->
            order.products.count { it == product }
        }
    }

// Get all ordered products (including duplicates)
fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap { it.products }
