# Use the official Python image from the DockerHub
FROM python:3.9

# Set the maintainer label
LABEL maintainer="ketwaphelo@gmail.com"
ENV MYSQL_DATABASE='service_sphere'
ENV MYSQL_USER='root'
ENV MYSQL_PASSWORD='password'
ENV MYSQL_HOST='localhost'
ENV MYSQL_PORT='3306'

# Set environment variables
# Ensures that the python output is set straight to the terminal without buffering it first
ENV PYTHONUNBUFFERED 1

# Set the working directory in docker
WORKDIR /app

# Copy the dependencies file to the working directory
COPY requirements.txt .

# Install any dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Copy the content of the local src directory to the working directory
COPY . .

# Specify the command to run on container start
CMD ["gunicorn", "--bind", "0.0.0.0:8000", "user_management.wsgi:application"]
