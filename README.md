# 📚 BookLend

A fullstack application for managing a library's book lending system, featuring a Java Spring Boot backend and an Angular frontend.

---

## ✨ About

BookLend is designed to help libraries manage their book inventory, track loans, and organize user and author information. The system is ideal for libraries seeking a digital, modern, and efficient solution for lending management.

---

## 🚀 Requirements

- [Java JDK](https://adoptium.net/) 17 or higher
- [Maven](https://maven.apache.org/) 3.8+
- [Node.js](https://nodejs.org/) v16.x or v18.x
- [Angular CLI](https://angular.io/cli) v14.x
- (Optional) MySQL for backend storage

---

## ⚡ Installation

### 🛠️ Backend (Spring Boot)

1. **Navigate to the backend folder:**
   ```sh
   cd BookLend/ApiRestLibrary
   ```
2. **Build and run the backend:**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
   The API will be available at `http://localhost:8080` (default Spring Boot port).

3. **Configure your database connection in `application.properties` if needed.**

---

### 🛠️ Frontend (Angular)

1. **Navigate to the frontend folder:**
   ```sh
   cd BookLend/library
   ```
2. **Install dependencies:**
   ```sh
   npm install
   ```
3. **Start the Angular app:**
   ```sh
   npm start
   ```
   The app will be available at `http://localhost:4200` (default Angular port).

---

## 📝 Notes

- Make sure you have Java 17+, Maven, Node.js, and Angular CLI installed.
- For production, always use environment variables or secure config for sensitive data.
- The backend uses Spring Boot 3 and connects to MySQL by default.
- The frontend is built with Angular 14 and Bootstrap.

---

## 🤝 Contributing

Contributions and suggestions are welcome! Please open an issue or pull request. 🙌

---

## 📝 License

This project is licensed under the MIT License.

---

> **Note:**  
> Replace `<your-repo-url>` with your actual repository URL.  
> You can add screenshots or demo videos to make your README even more helpful!
