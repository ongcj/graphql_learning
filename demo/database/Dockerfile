FROM postgres:alpine
RUN mkdir data
COPY ./mock_data/* data/
COPY install.sql /docker-entrypoint-initdb.d/