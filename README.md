## Run local

```sh
./mvnw spring-boot:run \
-Dspring-boot.run.arguments=" \
--APP_TIME_DB=60000 \
--SPRING_DATASOURCE_USERNAME=? \
--SPRING_DATASOURCE_PASSWORD=? \
--SPRING_DATASOURCE_URL=?"
```

## Test

Using httpie:
```sh
# print host-name and IP
http localhost:8080/api/info

# last 3 inserted rows
http localhost:8080/api/show

http localhost:8080/api/ping
```

# Container

### Build Image

- Edit (version) and run `docker/build-image.sh`
- Create `local-docker-compose.yml` (see template)

### Run/Test
- Run `docker-compose -f docker/local-docker-compose.yml up -d`
- [Test](#test) _see "docker-compose" PORT number_
- Stop `docker-compose -f docker/local-docker-compose.yml down`

### Publish Image
- `docker login`
- `docker push bproenca/oci-app-bcp:?` 

## Deploy

```sh
scp -i ~/<pem> Wallet_db4bcp.zip  opc@<ip>:/home/opc/wks/wallet

```

## OCI Test

https://httpie.io/
```sh
http https://www.brunobcp.com/api/info
http --follow http://www.brunobcp.com/api/info
```