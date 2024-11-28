# PriceTicker - Nepal's Largest Vegetable Marketplace

## Overview

PriceTicker is an application designed to provide real-time price data for vegetables in Nepal's largest vegetable marketplace. This project consists of two main components:

1. **Spring Boot API** - Exposes RESTful endpoints for retrieving the latest vegetable price data.
2. **Python Web Scraper** - Dynamically scrapes the vegetable price data from the marketplace's website and updates the API.

## Tech Stack

- **Backend**: Spring Boot (Java)
- **Web Scraping**: Python (BeautifulSoup, Requests)
- **Database**: PostgreSQL
- **Cloud**: AWS

## Features

- Scrape vegetable price data (min, max, and average prices) from the marketplace.
- Expose the scraped data via REST API endpoints.
- Real-time data updates from the website through scheduled scraping.
- Scalable and flexible for future improvements, such as adding more marketplaces or additional features.

## Setup & Installation

### Prerequisites

1. **Java 17+** - For running the Spring Boot application.
2. **PostgreSQL** (Optional) - For storing the data in a database.
3. **Python 3.x** - For running the web scraper.

### Steps to Run the Application

#### Spring Boot Application

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/PriceTicker.git
    cd PriceTicker
    ```

2. Install required dependencies using Maven or Gradle:
    ```bash
    mvn install
    ```

3. Configure your `application.properties` file for database and other settings (if required).

4. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

5. The Spring Boot application should now be running on `http://localhost:8080`.

#### Python Web Scraper

1. Install Python dependencies:
    ```bash
    pip install beautifulsoup4 requests
    ```

2. Navigate to the web scraping script:
    ```bash
    cd webscraper
    ```

3. Run the web scraper script:
    ```bash
    python scraper.py
    ```

   This script will start scraping data from the marketplace and updating the API with new vegetable prices.

## API Endpoints

1. **GET /api/vegetables**
   - Retrieves the list of all vegetables and their latest price data.

2. **GET /api/vegetables/{id}**
   - Retrieves the price data for a specific vegetable by its ID.

## Future Enhancements

- Integrate with other vegetable marketplaces for more extensive data.
- Implement user authentication to restrict access to certain endpoints.
- Add price history tracking and analytics.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

