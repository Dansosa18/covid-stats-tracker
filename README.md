
<h1 align="center">🦠 COVID-19 Statistics API </h1>
<p align="center">
  🌍 Java application to consume and store global COVID-19 statistics 🌐  
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-22-blue?logo=java" alt="Java 17">
  <img src="https://img.shields.io/badge/MySQL-DB-important?logo=mysql">
</p>

---

## 🚀 What is this?

This project is a COVID-19 statistics client that:

- 📡 **Consumes real-time data** from an external API (RapidAPI).
- 💾 **Saves reports** to a MySQL database.
- 🧠 Is developed using best practices and modern technologies.

Perfect for practicing API integration, data persistence, and Java architecture.

---

## 🧰 Technologies Used

| Technology       | Description |
|------------------|-------------|
| ☕ Java 22        | Main language |
| 🧱 Maven         | Dependency management |
| 🐬 MySQL         | Relational database |
| 📦 JPA (Jakarta) | Data persistence |
| 🌐 HTTP Client   | External API calls |
| 🧊 Jackson       | JSON ↔️ Object conversion |

---

## 📦 Project Structure

```
📦 src
 ┣ 📂 dto/             → Data classes (Region, Report, etc.)
 ┣ 📂 service/         → API client and business logic
 ┣ 📂 main/            → Main class (ApiApplication)
 ┗ 📄 application.properties → General configuration
```

---

## ⚙️ Initial Setup

1. 🔽 **Clone the repository**:
   ```bash
   git clone <REPOSITORY_URL>
   cd <PROJECT_NAME> git checkout memo
   ```

2. 🛠️ **Configure the database** in `Persistence.xml`:
   ```ini
   <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/covid?useSSL=false&amp;serverTimezone=UTC"/>
            <property name="jakarta.persistence.jdbc.user" value="your user"/>
            <property name="jakarta.persistence.jdbc.password" value="your password"/>
   ```

3. 🐬 **Create the database**:
   ```sql
   CREATE DATABASE COVID;
   ```

4. 🔑 **Add your RapidAPI key** in `ApiHttpClient.java`:
   ```java
   private static final String RAPIDAPI_KEY = "<YOUR_RAPIDAPI_KEY>";
   ```

---

## 💡 Highlighted Features

- 📍 **Get regions**:  
  ```java
  getRegions();
  ```

- 🏞️ **Get provinces**:  
  ```java
  getProvinces("ISO_CODE");
  ```

- 📊 **Get reports by date**:  
  ```java
  getReports("ISO_CODE", "YYYY-MM-DD");
  ```

- 💾 **Save reports to the database**:
  ```java
  ReportDao reportDao = new ReportDao();
  reportDao.saveReport(myReport);
  ```

---

## 🗄️ Database Table Structure

```sql
CREATE TABLE Report (
    id INT AUTO_INCREMENT PRIMARY KEY,
    iso VARCHAR(10),
    province VARCHAR(255),
    name VARCHAR(255),
    confirmed INT,
    deaths INT,
    recovered INT
);
```

---

## ▶️ How to Run

```bash
ApiApplication.main();
```

---

## ✍️ Authors

Developed with 💙 by students of **Universidad Mariano Gálvez**  

| ALUMNO                  | CARNET        |
|-------------------------|---------------|
| 🧑🏻‍💻 MARCOS MENDEZ   | 0905-23-5324  |
| 🧑🏽‍💻 DANIEL SOSA     | 0905-23-8230  |
| 🧑🏽‍💻 YOURGEN THOMMEL | 0905-23-14003 |



For educational and professional practice purposes.

---

<p align="center">
  <strong>Thanks for visiting this project! Take care of your health and keep learning 🚀</strong>
</p>

<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/1/15/Escudo_de_la_universidad_Mariano_G%C3%A1lvez_Guatemala.svg" width="200"/>
</p>
