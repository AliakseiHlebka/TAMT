package com.epam.task.taxiPark.readDataFromExternalSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.epam.task.taxiPark.Car;
import com.epam.task.taxiPark.PassengerCar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromXmlFile implements ReadDataFromExternalSource {
    private String path;

    public ReadFromXmlFile(String path) {
        this.path = path;
    }

    @Override
    public List<Car> read() {
        List<Car> carsList = new ArrayList<>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(this.path));
            document.normalizeDocument();
            Element root = document.getDocumentElement();
            NodeList cars = root.getElementsByTagName("car");

            for (int i = 0; i < cars.getLength(); i++) {
                Element item = (Element) cars.item(i);
                item.getTagName();
                Element elementModel = (Element) item.getElementsByTagName("model").item(0);
                String model = elementModel.getTextContent();
                Element elementValueInDollars = (Element) item.getElementsByTagName("valueInDollars").item(0);
                int valueInDollars = Integer.parseInt(elementValueInDollars.getTextContent());
                Element elementFuelConsumption = (Element) item.getElementsByTagName("fuelConsumption").item(0);
                int fuelConsumption = Integer.parseInt(elementFuelConsumption.getTextContent());
                Element elementPassengersNumber = (Element) item.getElementsByTagName("passengersNumber").item(0);
                int passengersNumber = Integer.parseInt(elementPassengersNumber.getTextContent());

                carsList.add(new PassengerCar(model, valueInDollars, fuelConsumption, passengersNumber));
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return carsList;
    }
}
