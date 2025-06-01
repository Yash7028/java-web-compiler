# 🧠 Java Live Compiler

A real-time Java compiler built with **Spring Boot**, **Monaco Editor**, and **Tailwind CSS**. Write, compile, run, and download Java code directly from your browser.

---

## ✨ Features

- 🔄 Real-time Java code execution via a Spring Boot backend  
- 💡 Syntax highlighting, autocompletion, and error underlining using Monaco Editor  
- 🌗 Light/Dark theme toggle  
- 📥 Download your Java code as a `.java` file  
- 🖥 Responsive layout with side-by-side output in fullscreen  
- 🐳 Docker support for easy deployment  

---

## 🛠 Tech Stack

**Frontend**:  
- HTML  
- Tailwind CSS  
- Monaco Editor (Java syntax support)  

**Backend**:  
- Java  
- Spring Boot (Java Compiler API)  

**Deployment**:  
- Docker (OpenJDK 17 base image)  

---

## 🚀 Getting Started

### 🔧 **Run Locally**

- git clone https://github.com/your-username/java-live-compiler.git
- cd java-live-compiler
- ./mvnw spring-boot:run
- Then visit:
📍 http://localhost:8080

🐳 **Run with Docker**
- docker build -t java-live-compiler .
- docker run -p 8080:8080 java-live-compiler
- Then visit:
📍 http://localhost:8080

🆓 Free Hosting Suggestions
🌐 Render

