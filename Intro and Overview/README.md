# GraphQL Learning
Notes and example code for learning and understanding GraphQL

## What is GraphQL?
- New API standard by Facebook. Open sourced.
    - More flexible and powerful alternative to REST. 
- Enables declarative data fetching
    - Client can specify exactly what it needs from an API.
- Expose single endpoint and responds to queries. 
    - Instead of multiple endpoints that return fixed data structures, GraphQL only expose a single endpoint and response to precisely the data client asked for. 

## How does it work?

Most application today have the needs to fetch data that is stored remotely in some database. That where server comes into play. Whenever the client need some information that it wants to display to the user, it sends an **request** to the server. Server is programmed in a way that it can handle the request by retrieving appropriate information from the database and then sends it back to the client. 

### REST
The above can be achieved using REST. But when the concept of REST is developed, client application were relatively simple and development speed was not as dynamic as today. Thus, REST was a good fit for many applications. However, the API landscape has changed over the last couple of years and in particular, there are 3 factors that have been challenging the way how API are designed. 

1. Need for efficient data loading. 
    - Increased mobile usage, low-power devices and sloppy networks were the initial reason why Facebook developed GraphQL. GraphQL minimizes the amount of data that needs to be transferred over the network, and it greatly improves the applications that is operating in the mentioned condition.
2. Variety of different frontend frameworks and platforms on the client. 
    - This make it difficult to build and maintain a single API that would fit the requirements of all the different client. GraphQL allows different clients to access exactly what data it needs.
3. Adoption of Scrum 
    - Continuous deployment has become a norm in many companies. Rapid iteration and frequent product updates are necessary in such settings. Using REST, the way how data is exposed often needs to be change to account for specific requirements and design changes on the client side. 


### GraphQL

GraphQL was developed for more flexibility and efficiency in client-server interaction. It solves many of the shortcomings and inefficiencies that developers faced when interacting with REST. 

*Example*

Blogging Application that shows the user first name, all the post that the user have created, and lastly the most recent 3 followers. 

|Blogging Application|
|---|
|Mary|
|Blog 1 title|
|Blog 2 title|
|Blog 3 title|
|...|
|n-th follower|
|n-1-th follower|
|n-2-th follower|

In REST, normally there would be 3 APIs endpoints for the client to fetch the required data. 

|REST API endpoint|
|---|
|/users/<id>|
|/users/<id>/posts|
|/users/<id>/followers|

The steps required for the Blogging Application to display/render the application to the users would be as follows. 

*Step 1 Fetch the user data with /users/<id>*
```json
{
    "user": {
        "id": "asdasd123123",
        "name": "Mary",
        "birthday": "01-01-2020",
        "Gender": "Female",
        // many more...
    }
}
```
Server would response with the information shown above. But even though the application only just need the name, much redundant information are returned as well. By doing so, the application is putting weight on the user data plan.


*Step 2 Fetch the user post data with /users/<id>/posts*

This is similar to Step 1. Even though the application only needs the title of the blog post at this point, much redundant information such as id of the blog post, the content, etc., are also returned to the client.

*Step 3 Fetch the user post data with /users/<id>/followers*

Similar to Step 1 and 2. As the application only need the most recent 3 followers name, but every single follower information is returned.

Although it is possible to implement and develop an endpoint for this specify application profile screen, it is not an ideal way to go in today context as mention in the **3rd issue of REST**. Doing this, every time there is design or specification changes made on the frontend, there is a need to change the API, and it is not possible to iterate quickly on the product. 


With GraphQL, the above situation can be resolved. In GraphQL, there would only have a single endpoint that would be used by **all** the different clients. So with GraphQL, only a single request is sent to the server, and the server would response with all the specific required information. 

By sending a POST request, a query is included in the body which describe all the information requirements.

```
query {
  User(id: "asdasd123123") {
    name
    posts {
      title
    }
    followers(last: 3) {
      name
    } 
  } 
}
```
When GraphQL server receive this query, it will process it and fetch exactly the information that is specified from the database and then return it as a JSON object as shown below. 

```json
{
  "data": {
    "User": {
      "name": "Mary",
      "posts": [
        {"title":  "Blog 1 title"},
        {"title":  "Blog 2 title"},
        {"title":  "Blog 3 title"},
        // ...
        {"title":  "Blog n title"}

      ],
      "followers": [
        {"name" : "John"},
        {"name" : "Andy"},
        {"name" : "Jay"}
      ]   
    }
  }
}
```

GraphQL is able to eliminate the issue faced in REST. 
- In the REST section, 
    - it is mentioned that REST requires a **need for better efficient in terms of data loading**. 
        - In the REST example, over and under fetching is encounter. **Over fetching** is when there is a downloading of unnecessary data and **under fetching** is when the endpoint does not return enough information and there is a need to send multiple request. 
        - By using GraphQL, only returning exact information resolve such issue. 
    - Both 2 point, **variety of different frontend frameworks and platforms on the client** and **adoption of Scrum** is similar. There is a need for a better way to handle changes in such dynamics environment these days. 
        - With GraphQL, this issue do not exist anymore due to the flexible nature of GraphQL. 
        - Any changes on the client, due to product requirements and design change, do not result in any work required from the server. 

It is also able to provide insightful analytics to gain a deep understanding of how the available data is being used. As with every query, what information is required are known, this can help to evolve an API and deprecating specific fields that are not requested by any clients anymore.

Another major benefits is the schema and types. 
 - It uses the strong type system to define the capabilities of an API. All the types that are exposed in an API are written down in a schema through the GraphQL definition language. 
 - The schema serve as a contract between client and server, defining how the client can access the data. 
 - Frontend and backend teams can work completely independent without further communication since the structure of data is known through schema. 
