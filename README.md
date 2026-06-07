# Smart Emergency Response System

## Overview

Smart Emergency Response System is a full-stack web application designed to help users quickly find nearby hospitals and emergency services during critical situations. The system uses graph-based routing algorithms to determine optimal paths and improve emergency response efficiency.

## Features

* User Registration & Login with JWT Authentication
* Emergency Request Management
* Nearby Hospital Discovery
* Shortest Route Calculation using Dijkstra Algorithm
* Interactive Map Integration
* Severity Assessment Module
* Secure Spring Security Configuration
* PostgreSQL Database Integration
* RESTful API Architecture

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* PostgreSQL
* JWT Authentication
* Maven

### Frontend

* React.js
* Axios
* React Router
* Leaflet/OpenStreetMap

## Project Architecture

Frontend (React)
↓
REST APIs
↓
Spring Boot Backend
↓
PostgreSQL Database

## Key Algorithms

* Dijkstra Algorithm for shortest path calculation
* Haversine Formula for distance calculation
* Severity Calculation Logic for emergency prioritization

## Project Structure

### Backend Repository

* Authentication Module
* Hospital Management Module
* Emergency Request Module
* Route Optimization Module
* Security Configuration

### Frontend Repository

* Login & Registration Pages
* Dashboard
* Emergency Request Form
* Map View
* Hospital Information Display

## Installation

### Backend

```bash
git clone <backend-repository-url>
cd emergency-response-backend
mvn spring-boot:run
```

### Frontend

```bash
git clone <frontend-repository-url>
cd emergency-response-frontend
npm install
npm start
```

## Future Enhancements

* Real-Time Ambulance Tracking
* AI-Based Emergency Prioritization
* SMS & Email Notifications
* Live Traffic Integration
* Mobile Application Support

## Author

Sanskar Vishwakarma

M.Sc. Mathematics with Computer Science

Smart Emergency Response System Project
