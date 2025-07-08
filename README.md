# ✈️ WorldAirline - Flight Booking System (2020)

This repository showcases a group project completed in 2020 at ECE Paris, aimed at learning Java programming. It was also our first group project involving a SQL database, which we put a lot of effort to be as compelete as possible.  
The project is a flight booking desktop application built in Java using Swing for the GUI and MySQL for data storage. The software supports both customer and admin functionalities and follows the MVC architectural pattern with DAO and a singleton database connection.

---

## 📚 Table of Contents

- [📦 Environment used](#environment)
- [🧾 Features](#features)
- [🗃️ Database](#database)

---
<a name="environment"></a>  
  
## 📦 Environment used

- **Language & Tools**: Java (JDK 15), NetBeans 12.5
- **Database**: MySQL
- **Architecture**: MVC pattern + DAO + Singleton DB Connection
- **Build**: Available as a `.jar` in the `dist/` folder (built with NetBeans, which uses Ant)
- **GUI Libraries**:  
  - `Swing` (GUI)
  - `LGoodDatePicker` & `JCalendar` (date selection)  
  - `Barbecue` (barcode generation)
  - `JFreeChart` (for statistics)  
  - `MySQL connector`  

---

<a name="features"></a>  
  
## 🧾 Features

### 👤 Customer Features

- **🔐 Authentication Options**:  
  - Log in with a customer account  
  - Sign up for a new account  
  - Continue as a guest (limited features)

- **🔎 Flight Search**:  
  Search for flights by specifying:
  - Departure and arrival airports
  - Departure and return dates
  - Number of passengers
  - One-way or round-trip preference

- **✈ Flight Selection**:  
  - View available flights and select outbound/inbound flights  
  - Summary view showing flight details before confirmation
  - Can filter by seat class availability (economy, business or first class)

- **🎫 Ticket Pricing**:  
  - Ticket Pricing depends on age category : 
    - child : 10% discount
    - regular : no discount
    - senior : 20% discount
  - User's age category is directly computed from the birth date when signing in : 
    - child category is younger than 12 years old
    - senior is older than 62

- **💺 Passenger & Seat Details**:  
  - Enter personal information for each passenger  
  - Choose individual seat numbers

- **💳 Payment Screen**:  
  - Mock payment interface (no real payment integration)  
  - Apply a coupon code to receive discounts

- **🧾 Booking Confirmation**:  
  - After successful booking, tickets are generated and tied to this booking
  - Each ticket includes a unique barcode using the Barbecue library  
  - Logged-in users can view their bookings and tickets in the "My Information" section

> Note: Guest users do not receive email confirmations. Ticket emailing was considered but not implemented.  
  
  
  
### 🔧 Admin Features

> To log in as an admin, you must manually create an admin account in the database. Passwords are stored as MD5 hashes.

- **🔑 Admin Dashboard**:  
  Accessed via a button on the home screen (requires login)

- **🧭 Manage Data**:  
  - Search, add, edit, and delete:
    - Flights
    - Bookings
    - Tickets
    - Coupons

- **📊 Statistics Panel**:  
  Visual insights using JFreeChart:
  - **Bar chart**: Number of flights per month  
  - **Pie chart**: Distribution of destinations by airport

> Current limitations:
> - No GUI for adding new airports or airplanes  
> - Admin account creation must be done manually in the database  
  
  


### More about features & code

- Customer Wireframes / Storyboards
- Admin Wireframes / Storyboards
- Application UI
- UML Diagrams

> - see the ![docs](docs) folder  



---  



<a name="database"></a>  
  
## 🗃️ Database Schema

- airplane, airport, flight, booking, coupon, ticket, flightseat, passenger, customeraccount, employeeaccount
- Supports multiple passengers and tickets per booking and individual seat tracking.

### ER Diagram

![ER Diagram](https://github.com/user-attachments/assets/fe049d55-5c64-40e3-9dd3-925076aa5259)  
  
  
  
  
  
## Database Setup
- Create a new empty database with the same name as the one specified in the link in demo.properties
- Execute the provided `flightbooking.sql` script to create and populate tables.

> You may need to do the following if the script doesn't work:
> - Set charset of database and tables to `utf8` and collation to `utf8_general_ci`
> - Remove INSERT command for ticket table

### Configuration
1. Edit `demo_properties`:
   ```properties
   user=your_username
   password=your_password
   dburl=jdbc:mysql://127.0.0.1:3306/worldairline2?useSSL=false
    ```


---

