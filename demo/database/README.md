`cd mock_data`
`wget https://github.com/morenoh149/postgresDBSamples/raw/master/adventureworks/data.zip .`
`unzip data.zip`
`cd ..`

`docker build . --tag mock-postgres:1.0`

```
docker run --name postgres-spring-graphql \
 -e POSTGRES_PASSWORD=password \
 -d -p 5432:5432 \
 mock-postgres:1.0
```

