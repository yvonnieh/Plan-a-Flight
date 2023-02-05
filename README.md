# Plan-a-Flight
This program determine all possible flight plans for a person wishing to travel between two different cities serviced by an airline (assuming a path exists). It will also calculate the total cost incurred for all parts of the trip. The program will use information from two different input files in order to calculate the trip plan and total cost. 

1.	Origination and Destination Data – This file will contain a sequence of city pairs representing different legs of flights that can be considered in preparing a flight plan. For each leg, the file will also contain a dollar cost for that leg and a time to travel . For each pair in the file, you can assume that it is possible to fly both directions. 
2.	Requested Flights – This file will contain a sequence of origin/destination city pairs. For each pair, your program will determine if the flight is or is not possible. If it is possible, it will output to a file the flight plan with the total cost for the flight. If it is not possible, then a suitable message will be written to the output file. 

Sample Data

Flight Data:
4
Dallas|Austin|98|47
Austin|Houston|95|39
Dallas|Houston|101|51
Austin|Chicago|144|192

The first line of the file will contain an integer indicating how many rows of data will be in the file.  Each subsequent row will contain two city names, the cost of the flight, and the number of minutes of the flight.

Requested Flight Plans: 
2
Dallas|Houston|T
Chicago|Dallas|C

The first line will contain an integer indicating the number of flight plans requested.  The subsequent lines will contain a pipe-delimited list of city pairs with a trailing character to indicate sorting the output of flights by time (T) or cost (C). 


## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.



> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
