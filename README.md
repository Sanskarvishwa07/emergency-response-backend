# 🚑 Smart Emergency Response System — Backend

A full-stack emergency response system that uses graph-based algorithms to find the nearest hospital, calculate optimal routes, and assess emergency severity in real-time.

## 🔗 Live Repositories
- **Backend:** https://github.com/Sanskarvishwa07/emergency-response-backend
- **Frontend:** https://github.com/Sanskarvishwa07/emergency-response-frontend

## 📌 Overview
When a medical emergency occurs, every second matters. This system automatically:
- Finds the **nearest available hospital** using Haversine Formula
- Calculates the **shortest traffic-weighted route** using Dijkstra's Algorithm
- Computes a **Severity Score** based on symptoms, age, distance, and traffic
- Displays everything on a **live interactive map**

## ✨ Features
- ✅ User Registration & Login with JWT Authentication
- ✅ Hospital CRUD APIs (Add, Get, Delete)
- ✅ Nearest Hospital Finder (Haversine Formula)
- ✅ Shortest Path Routing (Dijkstra's Algorithm)
- ✅ Traffic-Weighted Route Optimization
- ✅ ETA Calculation (minutes to arrival)
- ✅ Emergency Request Management
- ✅ Multi-Factor Severity Score Calculator
- ✅ Secure Spring Security Configuration
- ✅ PostgreSQL Database Integration
- ✅ RESTful API Architecture with CORS support

## 🛠️ Tech Stack
| Layer | Technology |
|-------|-----------|
| Framework | Spring Boot 3.5 |
| Language | Java 17 |
| Security | Spring Security + JWT |
| Database | PostgreSQL 18 |
| ORM | Spring Data JPA + Hibernate |
| Password | BCrypt Hashing |
| Build Tool | Maven |
| API Testing | Postman |

## 🧮 Key Algorithms

### 1. Haversine Formula
Calculates accurate GPS distance between patient and hospital accounting for Earth's curvature.
a = sin²(Δφ/2) + cos(φ₁)·cos(φ₂)·sin²(Δλ/2)
c = 2·atan2(√a, √(1-a))
d = R·c  (R = 6371 km)

### 2. Dijkstra's Algorithm
Finds shortest traffic-weighted path from patient to hospital.
Traffic Weights:
HIGH   = 2.0x distance
MEDIUM = 1.5x distance
LOW    = 1.0x distance
Time Complexity: O((V+E) log V)

### 3. Severity Score Formula
Severity = (S × 0.40) + (A × 0.20) + (D × 0.25) + (T × 0.15)
S = Symptom Weight (1-10)
A = Age Factor (10.0 if age<5 or >60, else 5.0)
D = Distance Penalty (normalized 0-10)
T = Traffic Penalty (HIGH=10, MEDIUM=6.5, LOW=3.0)

## 📁 Project Structure
src/main/java/com/emergency/emergency_response/
├── config/
│   ├── JwtAuthFilter.java
│   └── SecurityConfig.java
├── controller/
│   ├── AuthController.java
│   ├── HospitalController.java
│   ├── EmergencyController.java
│   └── RouteController.java
├── service/
│   ├── AuthService.java
│   ├── HospitalService.java
│   ├── EmergencyService.java
│   └── RouteService.java
├── model/
│   ├── User.java
│   ├── Hospital.java
│   ├── EmergencyRequest.java
│   ├── GraphNode.java
│   └── GraphEdge.java
└── util/
├── JwtUtil.java
├── HaversineUtil.java
├── SeverityCalculator.java
└── DijkstraAlgorithm.java

## 🌐 API Endpoints
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | /api/auth/register | Register new user | No |
| POST | /api/auth/login | Login and get JWT | No |
| GET | /api/hospitals | Get all hospitals | Yes |
| POST | /api/hospitals | Add hospital | Yes |
| GET | /api/hospitals/{id} | Get hospital by ID | Yes |
| DELETE | /api/hospitals/{id} | Delete hospital | Yes |
| GET | /api/hospitals/nearest | Find nearest hospital | Yes |
| POST | /api/emergency | Create emergency request | Yes |
| GET | /api/emergency | Get all emergencies | Yes |
| GET | /api/emergency/{id} | Get emergency by ID | Yes |
| POST | /api/route/node | Add graph node | Yes |
| POST | /api/route/edge | Add graph edge | Yes |
| GET | /api/route/shortest | Shortest path + ETA | Yes |

## ⚙️ Installation & Setup

### Prerequisites
- Java JDK 17+
- Maven 3.x
- PostgreSQL 18
- Postman (for API testing)

### Steps
```bash
git clone https://github.com/Sanskarvishwa07/emergency-response-backend.git
cd emergency-response-backend
# Update application.properties with your PostgreSQL password
mvn spring-boot:run
```
Server starts at: `http://localhost:8080`

## 🗄️ Database Tables
| Table | Purpose |
|-------|---------|
| users | User authentication data |
| hospitals | Hospital details and location |
| emergency_requests | All emergency events |
| graph_nodes | Road network locations |
| graph_edges | Road segments with traffic weights |

## 🔐 Security
- All endpoints protected except `/api/auth/**`
- JWT tokens expire in 24 hours
- Passwords hashed with BCrypt (strength 10)
- CORS configured for frontend (localhost:3000)

## 🚀 Future Enhancements
- Real-time traffic API integration
- WebSocket for live dashboard updates
- SMS/Email notifications
- Mobile application (React Native)
- Machine learning for emergency prediction

## 👨‍💻 Author
**Sanskar Vishwakarma**
M.Sc. Mathematics with Computer Science — 4th Semester
Jamia Millia Islamia, New Delhi
GitHub: https://github.com/Sanskarvishwa07
