# Aggregator Design Pattern Example

## Overview

This project demonstrates the **Aggregator Design Pattern** in a microservices architecture using
Spring Boot. The application aggregates data from three distinct services:

1. **Product Service**: Provides information about products.
2. **Review Service**: Retrieves reviews associated with a product.
3. **Promotion Service**: Fetches promotional offers applicable to a product.

### Architecture Diagram

```plaintext
+-------------------+
|                   |
|  Product Service  |
|                   |
+-------------------+
         |
         |
+-------------------+
|                   |
|   Review Service  |
|                   |
+-------------------+
         |
         |
+-------------------+
|                   |
| Promotion Service  |
|                   |
+-------------------+
         |
         |
+-------------------+
|                   |
|   Aggregator      |
|                   |
+-------------------+

take pull from ## https://github.com/priyodas12/ReviewService.git
