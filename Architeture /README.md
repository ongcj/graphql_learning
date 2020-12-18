# Architecture
Notes taken for architectural use case for GraphQL. 

- GraphQL can potentially be used with any available network protocol such as TCP, WebSockets, etc. 
- GraphQL do not care about the database, or the format that is used to store the data. 
The below are the 3 major use cases of GraphQL and demonstrate the flexibility in terms of the context where GraphQL can be used. 

## GraphQL server with a connected database
- Greenfield projects
- Single web server that implements GraphQL
- GraphQL server resolves queries and constructs response with data that it fetches from the database
    - When a query arrives at the GraphQL server, the server read the query payload and fetches the required information from the database. 

## GraphQL server to integrate existing system
GraphQL server as a thin layer in front a number of third party or legacy system and integrates these systems through a single GraphQL API.
- Compelling for developers with legacy infrastructures and many APIs that have grown over the years which impose a high maintenance burden.
- GraphQL can be used to unify existing systems and hide its complexity behind a GraphQL API. 


## A hybrid approach with a connected database and integration of existing system

In this architecture, when a query is received by the server, the server will resolve it and either retrieve the required data from the connected database or from the integrated API.

## How GraphQL cope with different environment

GraphQL cope with different environment through the **Resolver function**.

- Payload of a GraphQL queries/mutations consist of a set of fields.
- In the GraphQL implementation, each of these fields corresponds to exactly one function that is called resolver. 
- Purpose of a resolver function is to fetch the data for its corresponding field.