# URL Shortener Application

This project is created to learn and demonstrate the usage of Redis as a key-value store for URL shortening. The application consists of a backend built with Spring Boot and Redis, and a frontend built with plain HTML, CSS, and JavaScript.

## How to Use

### Prerequisites

- Java
- IntelliJ IDEA or Visual Studio Code with Java extension
- Redis server running locally or accessible remotely

### Cloning the Repository

Clone the repository to your local machine using the following command:

```sh
git clone <your-repo-url>
cd <your-repo-directory>
```

### Setup
There are two directories url shortener for backend and frontend url shortener for frontend side.

### Using the Application

1. **Shorten a URL**:
   - Open the frontend in your web browser.
   - Enter the URL you want to shorten in the "Enter URL" field.
   - Optionally, enter a custom alias in the "Custom Alias" field.
   - Click the "Shorten" button.

2. **Get the Shortened URL**:
   - The shortened URL will be displayed below the form.
   - Click the shortened URL to be redirected to the original URL.


### Backend Components

- **UrlShortenerApplication.java**: Main class to run the Spring Boot application.
- **UrlShortenerController.java**: REST controller to handle URL shortening and redirection.
- **UrlShortenerService.java**: Service class to handle the business logic for URL shortening.
- **UrlRequest.java**: Class to create an object that represent URL request payloads.
- **CorsConfig.java**: Handling the cors configuration.

### Frontend Components

- **index.html**: Main HTML file with the form for URL input.
- **style.css**: Basic CSS for styling the frontend.
- **app.js**: JavaScript to handle form submission and interaction with the backend.

