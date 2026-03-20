# 🚀 Active Users Tracking System

A **Spring Boot web application** that tracks logged-in users in real-time and provides an **Admin Dashboard** for monitoring user activity.

---

## 📌 Features

* 🔐 User Authentication (Login & Signup)
* 👥 Track Active Users with Session Management
* ⏱️ Last Access Time Monitoring
* 🟢 User Status (Active / Inactive)
* 🛡️ Role-Based Access Control (Admin & User)
* 📊 Admin Panel for monitoring users
* ⚠️ Access Denied Popup for unauthorized users
* 🎨 Clean UI with improved popup messages

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot, Spring Security, Hibernate (JPA)
* **Frontend:** Thymeleaf, HTML, CSS, JavaScript
* **Database:** MySQL
* **Build Tool:** Maven

---

## 📂 Project Structure

```
src/
 ├── main/
 │   ├── java/
 │   │   └── com/clss/activeusers/
 │   │        ├── controller/
 │   │        ├── entity/
 │   │        ├── repository/
 │   │        ├── service/
 │   │        └── filter/
 │   └── resources/
 │        ├── templates/
 │        ├── static/
 │        └── application.properties
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository

```
git clone https://github.com/Thinakaran-dev/active-users-dashboard.git
cd your-repo-name
```

---

### 2️⃣ Configure Database

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

### 3️⃣ Run the Application

```
mvn spring-boot:run
```

---

### 4️⃣ Open in Browser

```
http://localhost:8080
```

---

## 👤 User Roles

| Role  | Access                  |
| ----- | ----------------------- |
| USER  | Dashboard               |
| ADMIN | Dashboard + Admin Panel |

---

## 🔐 Default Behavior

* Only **ADMIN** can access `/admin`
* Non-admin users will see a **popup message**

  > "You are not an admin!"

---

## 📸 Screenshots (Optional)

<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/1246d638-4c68-4a61-a118-fbfdbf851d85" />
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/6f0abb5e-e1fa-46ba-aa8c-5c31ae259c76" />
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/b6e51c86-49cf-4c50-ad2c-c773be1771e4" />


---

## 📈 Future Enhancements

* ✅ Real-time updates using WebSockets
* 📊 Advanced analytics dashboard
* 🔔 Notifications for user activity
* 🌐 Deployment (AWS / Docker)

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork this repo and submit a pull request.

---

## 📄 License

This project is open-source and available under the MIT License.

---

## 👨‍💻 Author

Developed by THINAKARAN

---
