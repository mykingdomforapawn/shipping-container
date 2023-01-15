import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream fis =  new FileInputStream("logging.properties");
        //LoggingUtil.initLogManager();
        try {
            //FileInputStream fis =  new FileInputStream("logging.properties");
            LogManager.getLogManager().readConfiguration(fis);
        } catch(IOException e) {
            e.printStackTrace();
        }

        // Init ship and look at containers
        Ship myShip = new Ship(2, 20000, List.of(ContainerType.REEFER_CONTAINER, ContainerType.TANK_CONTAINER));
        System.out.println("Current containes on ship: " + myShip.getContainerIDs());

        // Add container
        Container myContainer = new Container(ContainerType.TANK_CONTAINER, 300);
        myShip.addContainer(myContainer);

        // Add the same container again
        myShip.addContainer(myContainer);

        // Add wrong container type
        myShip.addContainer(new Container(ContainerType.OPEN_TOP_CONTAINER, 20));

        // Add too heavy container
        myShip.addContainer(new Container(ContainerType.TANK_CONTAINER, 30000));

        // Add too many containers
        myShip.addContainer(new Container(ContainerType.REEFER_CONTAINER, 20));
        myShip.addContainer(new Container(ContainerType.REEFER_CONTAINER, 20));

        // Look at containers
        System.out.println("Current containes on ship: " + myShip.getContainerIDs());
    }
}