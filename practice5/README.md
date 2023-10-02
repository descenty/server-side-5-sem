Dev run using Docker Compose (local Docker image)

```bash
./gradlew jibDockerBuild && docker compose up --build
```

Prod run using Docker Compose (with Docker Hub)

```bash
./gradlew jib && docker compose up --build