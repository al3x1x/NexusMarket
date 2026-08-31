# 🏛️ Domain Model - NexusMarket

This document details the domain layer classes for the NexusMarket application. Built using **Hexagonal Architecture** and **Domain-Driven Design (DDD)**, these classes are framework-agnostic Java POJOs focused solely on business logic.

---

## 1. Identity & Access Module

Handles platform users, security roles, status tracking, and address profiles.

### Classes
* **`Address`** *(Value Object)*: Encapsulates physical location details used for billing and shipping. Holds immutable attributes: `street`, `city`, `zipCode`, and `country`.
* **`User`** *(Concrete Entity)*: The core entity for all system users. Contains general profile data: `id` (Long), `fullName` (String), `email` (String), `role` (UserRole), and `status` (UserStatus).
* **`Buyer`** *(Extends `User`)*: Specialized entity for marketplace shoppers. Extends `User` by adding a `primaryAddress` (Address), `additionalAddresses` (List<Address>), and `commercialStatus` (CommercialStatus).

> **Design note:** Roles like `SELLER`, `LOGISTIC_OPERATOR`, `ADMINISTRATOR`, and `SUPERVISOR` use the base `User` entity directly with their respective `UserRole`. This avoids creating unnecessary empty subclasses without specific domain logic.

### Enums
* **`UserRole`**: `BUYER`, `SELLER`, `LOGISTIC_OPERATOR`, `ADMINISTRATOR`, `SUPERVISOR`.
* **`UserStatus`**: `ACTIVE`, `BLOCKED`, `INACTIVE`.
* **`CommercialStatus`**: `ACTIVE`, `SUSPENDED`, `UNDER_REVIEW`.

---

## 2. Catalog & Logistics Module

Manages products, storage locations, stock records, and inventory audit logs.

### Classes
* **`Product`**: Represents items available in the catalog. Contains `id` (Long), `productType` (ProductType), `variants` (List<String> for options like size or color), and `status` (ProductStatus).
* **`Warehouse`**: Represents physical or virtual storage facilities. Tracks `id` (Long) and `warehouseType` (WarehouseType).
* **`InventoryMovement`** *(Value Object)*: An immutable record tracking individual stock adjustments. Contains `movementType` (MovementType) and `quantity` (Integer).
* **`Inventory`**: Bridges products and warehouses to track current stock levels. Holds `id` (Long), `productId` (Long), `warehouseId` (Long), `availableQuantity` (Integer), `condition` (InventoryCondition), and a audit list of `movements` (List<InventoryMovement>).

### Enums
* **`ProductType`**: `PHYSICAL`, `DIGITAL`.
* **`ProductStatus`**: `PUBLISHED`, `SUSPENDED`, `DISCONTINUED`.
* **`WarehouseType`**: `MARKETPLACE`, `SELLER`.
* **`InventoryCondition`**: `GOOD`, `DAMAGED`.
* **`MovementType`**: `ENTRY`, `RESERVATION`, `SALE`, `ADJUSTMENT`, `RETURN`.

---

## 3. Orders & Post-Sale Module

Handles order lifecycles, billing, package delivery, and administrator-managed refunds.

### Classes
* **`OrderItem`** *(Value Object)*: Represents a single line item within a customer order. Stores `productId` (Long), `quantity` (Integer), and unit `price` (Double) locked at purchase time.
* **`Order`**: Represents the primary commercial transaction. Holds `id` (Long), `buyerId` (Long), `status` (OrderStatus), and a list of purchased `items` (List<OrderItem>).
* **`Invoice`**: Financial record generated once an order is paid. Contains `id` (Long), `orderId` (Long), `totalAmount` (Double), and `issueDate` (LocalDateTime).
* **`Shipment`**: Manages the physical fulfillment and delivery tracking of an order. Holds `id` (Long), `orderId` (Long), `logisticOperatorId` (Long), `destinationAddress` (Address), and `trackingStatus` (ShipmentStatus).
* **`Refund`**: Manages monetary return requests authorized by administrators. Contains `id` (Long), `orderId` (Long), `administratorId` (Long), `refundAmount` (Double), `reason` (String), and `status` (RefundStatus).

### Enums
* **`OrderStatus`**: `CART`, `PENDING_PAYMENT`, `PAID`, `DISPATCHED`, `DELIVERED_FINISHED`.
* **`ShipmentStatus`**: `PACKING`, `DISPATCHED`, `IN_TRANSIT`, `DELIVERED`.
* **`RefundStatus`**: `PENDING`, `APPROVED`, `REJECTED`, `COMPLETED`.