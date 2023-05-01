/**
 * 
 */
package saveThePlanet;

/**
 * @author
 *
 */
public class Board {
    private Square[] squares;

    // Default constructor
    public Board() {

     // Create Field and Area instances
        Field renewableEnergy = new Field("Renewable Energy");
        Area hydroelectricity = new Area("Hydroelectricity", 50);
        Area solarPower = new Area("Solar Power", 50);
        renewableEnergy.addArea(hydroelectricity);
        renewableEnergy.addArea(solarPower);

        Field wasteManagement = new Field("Waste Management");
        Area recyclingPrograms = new Area("Recycling Programs", 40);
        Area compostingInitiatives = new Area("Composting Initiatives", 40);
        wasteManagement.addArea(recyclingPrograms);
        wasteManagement.addArea(compostingInitiatives);

        Field biodiversityConservation = new Field("Biodiversity Conservation");
        Area habitatRestoration = new Area("Habitat Restoration", 60);
        Area wildlifeProtection = new Area("Wildlife Protection", 60);
        biodiversityConservation.addArea(habitatRestoration);
        biodiversityConservation.addArea(wildlifeProtection);

        Field sustainableTransportation = new Field("Sustainable Transportation");
        Area publicTransitInfrastructure = new Area("Public Transit Infrastructure", 70);
        Area electricVehicleAdoption = new Area("Electric Vehicle Adoption", 70);
        sustainableTransportation.addArea(publicTransitInfrastructure);
        sustainableTransportation.addArea(electricVehicleAdoption);

        // Initialize the squares array with a size of 10.
        this.squares = new Square[10];
        
        // Initialize the squares array with instances of each Square type.
        this.squares[0] = new StartSquare("Start");
        this.squares[1] = new NothingSquare("Blank Square");

        // Renewable Energy field
        this.squares[2] = new FieldSquare("Renewable Energy - Hydroelectricity", renewableEnergy, hydroelectricity);
        this.squares[3] = new FieldSquare("Renewable Energy - Solar Power", renewableEnergy, solarPower);

        // Waste Management field
        this.squares[4] = new FieldSquare("Waste Management - Recycling Programs", wasteManagement, recyclingPrograms);
        this.squares[5] = new FieldSquare("Waste Management - Composting Initiatives", wasteManagement, compostingInitiatives);

        // Biodiversity Conservation field
        this.squares[6] = new FieldSquare("Biodiversity Conservation - Habitat Restoration", biodiversityConservation, habitatRestoration);
        this.squares[7] = new FieldSquare("Biodiversity Conservation - Wildlife Protection", biodiversityConservation, wildlifeProtection);

        // Sustainable Transportation field
        this.squares[8] = new FieldSquare("Sustainable Transportation - Public Transit Infrastructure", sustainableTransportation, publicTransitInfrastructure);
        this.squares[9] = new FieldSquare("Sustainable Transportation - Electric Vehicle Adoption", sustainableTransportation, electricVehicleAdoption);
    }


    public Square getSquare(int position) {
        if (position >= 0 && position < squares.length) {
            return squares[position];
        } else {
            return null;
        }
    }

    public int getSize() {
        return squares.length;
    }

    public StartSquare getStartSquare() {
        for (Square square : squares) {
            if (square instanceof StartSquare) {
                return (StartSquare) square;
            }
        }
        return null;
    }

    public NothingSquare getNothingSquare() {
        for (Square square : squares) {
            if (square instanceof NothingSquare) {
                return (NothingSquare) square;
            }
        }
        return null;
    }
}