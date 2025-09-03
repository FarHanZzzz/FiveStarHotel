# Five Star Hotel Management System

A comprehensive JavaFX-based hotel management system designed for a five-star hotel with multiple user roles and integrated services.

## 🏨 Overview

The Five Star Hotel Management System is a desktop application built with JavaFX that provides a complete solution for managing hotel operations. The system supports multiple user roles including guests, staff members, and management personnel, each with specific functionalities tailored to their responsibilities.

## 🚀 Features

### Multi-Role User System
- **Hotel Guests**: Book services, leave reviews, manage reservations
- **CEO**: Strategic oversight, announcements, revenue reports, sponsorship campaigns
- **Hotel Head Manager**: Budget management, performance reports, staff inquiries
- **Front Desk Staff**: Guest check-in/check-out, transportation services, event management
- **Restaurant Manager**: Menu management, table reservations, performance tracking
- **Room Service Manager**: Service requests, worker scheduling, maintenance coordination
- **Room Service Worker**: Service delivery, performance reporting, special requests
- **Electrician**: Maintenance logs, equipment status tracking

### Core Functionalities

#### Guest Services
- **Room Service Requests**: Order food, beverages, and amenities
- **Restaurant Booking**: Table reservations and menu viewing
- **Event Reservations**: Book hotel facilities for special events
- **Laundry Services**: Request laundry and dry cleaning services
- **Transportation Services**: Book airport transfers and local transportation
- **Review System**: Submit reviews for hotel services and restaurant

#### Management Features
- **Announcement System**: Post and view company-wide announcements
- **Budget Management**: Track and manage departmental budgets
- **Performance Reports**: Monitor staff and department performance
- **Revenue Tracking**: View monthly revenue reports and analytics
- **Customer Reviews**: Monitor guest feedback and ratings
- **Staff Inquiries**: Handle internal staff queries and requests

#### Operational Features
- **Guest Check-in/Check-out**: Complete front desk operations
- **Menu Management**: Add, remove, and update restaurant menu items
- **Maintenance Logs**: Track equipment maintenance and repairs
- **Transportation Coordination**: Manage guest transportation requests
- **Event Management**: Handle special event bookings and logistics

## 🛠️ Technology Stack

- **Language**: Java 22
- **Framework**: JavaFX 22.0.1
- **Build Tool**: Maven
- **UI Framework**: FXML for scene design
- **Data Persistence**: Binary file serialization
- **Testing**: JUnit 5.10.2

## 📋 Prerequisites

- Java Development Kit (JDK) 22 or higher
- Maven 3.6 or higher
- JavaFX runtime (included in JDK 11+)

## 🚀 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd FiveStarHotel-master
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run the application**
   ```bash
   mvn javafx:run
   ```

   Or alternatively:
   ```bash
   mvn clean javafx:run
   ```

## 🏗️ Project Structure

```
FiveStarHotel-master/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── cse/fivestarhotel/
│   │   │       ├── CEO/                    # CEO management features
│   │   │       ├── Electrician/            # Maintenance and electrical services
│   │   │       ├── FrontDeskStaff/         # Front desk operations
│   │   │       ├── HotelGuest/             # Guest services and features
│   │   │       ├── HotelHeadManager/       # Head manager operations
│   │   │       ├── Login/                  # Authentication system
│   │   │       ├── RestaurantManager/      # Restaurant operations
│   │   │       ├── RoomServiceManager/     # Room service management
│   │   │       ├── RoomServiceWorker/      # Room service worker features
│   │   │       ├── HelloApplication.java   # Main application entry point
│   │   │       └── module-info.java        # Module configuration
│   │   └── resources/
│   │       └── cse/fivestarhotel/
│   │           ├── CEO/                    # CEO FXML files
│   │           ├── Electrician/            # Electrician FXML files
│   │           ├── FrontDeskStaff/         # Front desk FXML files
│   │           ├── HotelGuest/             # Guest FXML files
│   │           ├── HotelHeadManager/       # Head manager FXML files
│   │           ├── Login/                  # Login FXML files
│   │           ├── RestaurantManager/      # Restaurant FXML files
│   │           ├── RoomServiceManager/     # Room service manager FXML files
│   │           ├── RoomServiceWorker/      # Room service worker FXML files
│   │           ├── Img/                    # Application images and assets
│   │           └── hello-view.fxml         # Main view
│   └── test/
├── target/                                 # Compiled classes and build artifacts
├── pom.xml                                 # Maven configuration
├── mvnw                                    # Maven wrapper (Unix)
├── mvnw.cmd                               # Maven wrapper (Windows)
└── *.bin                                   # Data persistence files
```

## 👥 User Roles & Capabilities

### 🏨 Hotel Guest
- Create and manage guest accounts
- Book restaurant tables and view menus
- Request room service and special amenities
- Book laundry services
- Arrange transportation services
- Reserve hotel facilities for events
- Submit reviews and ratings

### 👔 CEO
- View company-wide announcements
- Manage sponsorship campaigns
- Update monthly goals and objectives
- View comprehensive revenue reports
- Monitor customer reviews and feedback
- Post announcements to all staff

### 🏢 Hotel Head Manager
- View and manage departmental budgets
- Monitor monthly revenue reports
- Generate performance reports
- Post announcements to staff
- Review customer feedback
- Handle staff inquiries and queries

### 🖥️ Front Desk Staff
- Process guest check-ins and check-outs
- Access guest details and information
- Manage transportation service requests
- View hotel guest reviews
- Handle event bookings
- Submit internal queries and reports

### 🍽️ Restaurant Manager
- Add and remove menu items
- View restaurant reviews and feedback
- Manage guest table reservations
- View menu details and pricing
- Submit performance reports
- Handle staff inquiries

### 🛏️ Room Service Manager
- Submit inquiries and reports
- Handle special guest requests
- View customer reviews
- Submit performance reports
- Coordinate with electrician for maintenance
- Manage room service operations

### 🧹 Room Service Worker
- Submit performance reports
- Handle special guest requests
- View laundry service requests
- Submit internal inquiries
- Manage service delivery

### ⚡ Electrician
- Maintain equipment maintenance logs
- Track task status and observations
- Update maintenance schedules
- Report equipment issues

## 💾 Data Management

The application uses binary file serialization for data persistence. Key data files include:

- `AnnoncementsDetails.bin` - Company announcements
- `BookEventDetails.bin` - Event reservations
- `BookTableDetails.bin` - Restaurant table bookings
- `CheckInGuestDetails.bin` - Guest check-in information
- `CreateAccountOfGuest.bin` - Guest account data
- `FrontDeskStaff.bin` - Front desk staff information
- `HotelGuestReview.bin` - Guest reviews and ratings
- `LaundryInfo.bin` - Laundry service requests
- `MaintainenceLogs.bin` - Equipment maintenance records
- `MenuDetails.bin` - Restaurant menu items
- `TransportationDetails.bin` - Transportation bookings

## 🎨 User Interface

The application features a modern, intuitive JavaFX-based interface with:
- Role-based dashboards
- Responsive navigation
- Data tables for information display
- Form-based data entry
- Integrated image assets
- Professional styling and layout

## 🔧 Configuration

### Maven Configuration
The project uses Maven with the following key configurations:
- Java 22 source and target
- JavaFX 22.0.1 dependencies
- JUnit 5.10.2 for testing
- JavaFX Maven plugin for application packaging

### Module Configuration
The application uses Java modules with proper exports and opens declarations for JavaFX FXML loading.

## 🚀 Running the Application

1. **Development Mode**
   ```bash
   mvn clean javafx:run
   ```

2. **Build and Package**
   ```bash
   mvn clean package
   ```

3. **Run Tests**
   ```bash
   mvn test
   ```

## 📱 Application Flow

1. **Launch**: Application starts with the sign-in screen
2. **Authentication**: Users choose between Staff or Guest login
3. **Role Selection**: Staff members select their specific role
4. **Dashboard**: Users access role-specific dashboards
5. **Feature Access**: Navigate through available features and services
6. **Data Management**: Create, view, and manage relevant data
7. **Logout**: Secure logout returns to sign-in screen

## 🔒 Security Features

- Role-based access control
- Secure user authentication
- Data validation and input sanitization
- Session management
- Secure logout functionality

## 🐛 Troubleshooting

### Common Issues

1. **JavaFX Runtime Not Found**
   - Ensure JDK 11+ is installed
   - JavaFX is included in JDK 11 and later

2. **Maven Build Failures**
   - Check Java version compatibility
   - Ensure Maven is properly configured

3. **FXML Loading Errors**
   - Verify resource paths in FXML loaders
   - Check module-info.java exports

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## 📄 License

This project is developed for educational purposes as part of a Computer Science Engineering course.

## 👨‍💻 Development Team

Developed as part of a CSE (Computer Science Engineering) academic project.

## 📞 Support

For technical support or questions about the application, please refer to the project documentation or contact the development team.

---

**Note**: This is a desktop application designed for hotel management operations. Ensure proper Java environment setup before running the application.
