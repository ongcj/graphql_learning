### GraphQL Type System
GraphQL scalars are atomic values. It can only be selected as a whole and cannot be divided into multiple fields. In graph theory terms, a GraphQL operation can be considers a root tree and scalars can be considered the leave of that tree.

Out of the box scalars:
```java
scalar BigDecimal
scalar BigInteger
scalar Byte
scalar Char
scalar Short
scalar Long
```

Defining customer scalars is also possible.
