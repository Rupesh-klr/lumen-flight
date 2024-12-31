# Use an official Maven image with JDK 17
FROM maven:3.8.6-openjdk-17

# Set the working directory
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install any necessary dependencies
RUN mvn clean install

# Command to run the application
CMD ["mvn", "spring-boot:run"]