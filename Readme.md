# AgriTicker Nepal

AgriTicker Nepal is a real-time vegetable price tracking platform designed to provide up-to-date pricing information across 3,000+ products in the agricultural sector. Built with a focus on scalability and automation, the platform collects, processes, and delivers essential pricing data to empower stakeholders in Nepal’s agricultural market.

## Key Features:
- **Real-Time Data**: A RESTful API built with **Spring Boot** that serves real-time vegetable prices from multiple sources.
- **Extensive Product Coverage**: Aggregates pricing data for over **3,000 products**, ensuring comprehensive market coverage.
- **Automated Data Scraping**: **Python**-based automation scripts scrape data from **20+ websites**, significantly reducing the time needed to update product prices.
- **Seamless Integration**: The platform uses **AWS RDS** for database management, **AWS ECS** for scalable containerized deployments, and **Docker** for environment consistency.
  
## Technologies Used:
- **Backend**: Java, Spring Boot
- **Automation**: Python (Web Scraping)
- **Cloud Infrastructure**: AWS RDS, AWS ECS, Docker
- **Build Tools**: Maven

## Impact:
- **Reduced Data Update Time**: Automated scraping processes cut down manual update times and ensured data accuracy, improving the timeliness of price updates for stakeholders.
- **Scalable Architecture**: Deployed using **AWS ECS** and **Docker**, enabling the platform to scale effortlessly as the product catalog and user base grow.
- **Data Accessibility**: The RESTful API provides easy access to real-time data for developers and businesses to integrate into their systems.
