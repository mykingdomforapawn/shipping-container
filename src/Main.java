import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException {

        //LoggingUtil.initLogManager();

        System.out.println("Hello world!");

        // Init ship and add container
        Ship myShip = new Ship(2, 20000, List.of(ContainerType.REEFER_CONTAINER, ContainerType.TANK_CONTAINER));
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

    }
}