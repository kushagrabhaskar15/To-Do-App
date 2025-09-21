# Full Stack To-Do App

A modern **To-Do application** built with **React** and **Tailwind CSS** for the frontend and **Spring Boot** for the backend. Users can create, view, update, and delete tasks, all while enjoying a sleek, responsive interface. The project can be run locally or using **Docker** for easy deployment.

---

## Table of Contents

* [Features](#features)
* [Technologies](#technologies)
* [Project Structure](#project-structure)
* [Getting Started](#getting-started)

  * [Backend Setup](#backend-setup)
  * [Frontend Setup](#frontend-setup)
* [API Endpoints](#api-endpoints)
* [Docker Setup](#docker-setup)
* [Screenshots](#screenshots)
* [Contributing](#contributing)
* [License](#license)

---

## Features

* Add new tasks with a title and optional description
* Mark tasks as completed
* Edit and delete tasks
* Responsive UI using **Tailwind CSS**
* RESTful API powered by **Spring Boot**
* Persistent storage using **MySQL** or **H2** database
* Full Docker support for easy deployment

---

## Technologies

**Frontend:**

* React
* Tailwind CSS
* Axios for API calls

**Backend:**

* Spring Boot
* Spring Data JPA
* MySQL or H2 Database
* Maven

**Deployment:**

* Docker & Docker Compose

---

## Project Structure

```
todo-app/
│
├── backend/             # Spring Boot backend
│   ├── src/main/java/...
│   ├── src/main/resources/application.properties
│   └── pom.xml
│
├── frontend/            # React frontend
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   └── App.jsx
│   ├── public/
│   └── package.json
│
└── docker-compose.yml   # Docker Compose file
```

---

## Getting Started

### Backend Setup

1. Clone the repository:

```bash
git clone <your-repo-url>
cd backend
```

2. Configure the database in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_app
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

3. Build and run the backend:

```bash
mvn clean install
mvn spring-boot:run
```

Backend will start on: `http://localhost:8080`

---

### Frontend Setup

1. Navigate to the frontend folder:

```bash
cd frontend
```

2. Install dependencies:

```bash
npm install
```

3. Start the development server:

```bash
npm start
```

Frontend will run on: `http://localhost:3000`

---

## API Endpoints

| Method | Endpoint          | Description             |
| ------ | ----------------- | ----------------------- |
| GET    | `/api/todos`      | Get all tasks           |
| GET    | `/api/todos/{id}` | Get a task by ID        |
| POST   | `/api/todos`      | Create a new task       |
| PUT    | `/api/todos/{id}` | Update an existing task |
| DELETE | `/api/todos/{id}` | Delete a task by ID     |

---

## Docker Setup

You can run the full-stack app using **Docker Compose** for easy deployment.

### Backend Dockerfile (`backend/Dockerfile`)

```dockerfile
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
```

---

### Frontend Dockerfile (`frontend/Dockerfile`)

```dockerfile
# Build stage
FROM node:20-alpine as build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

# Production stage
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

---

### Docker Compose (`docker-compose.yml`)

```yaml
version: "3.9"

services:
  backend:
    build: ./backend
    container_name: todo-backend
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/todo_app
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: example
      SPRING_JPA_HIBERNATE_DDL_AUTO: update
    depends_on:
      - db

  frontend:
    build: ./frontend
    container_name: todo-frontend
    ports:
      - "3000:80"
    depends_on:
      - backend

  db:
    image: mysql:8.0
    container_name: todo-db
    environment:
      MYSQL_ROOT_PASSWORD: example
      MYSQL_DATABASE: todo_app
    ports:
      - "3306:3306"
    volumes:
      - db_data:/var/lib/mysql

volumes:
  db_data:
```

---

### Run the App with Docker

```bash
docker-compose up --build
```

* Backend: `http://localhost:8080`
* Frontend: `http://localhost:3000`

> Inside Docker network, the frontend can access backend via `http://backend:8080`.

---

## Screenshots

*(Add screenshots here of your app in desktop and mobile views)*

---

## Contributing

1. Fork the repo
2. Create a branch (`git checkout -b feature-name`)
3. Make your changes
4. Commit (`git commit -m 'Add feature'`)
5. Push (`git push origin feature-name`)
6. Open a Pull Request

---

## License

This project is licensed under the MIT License.
