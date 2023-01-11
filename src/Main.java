import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ContainerType xx = ContainerType.TANK_CONTAINER;
        System.out.println(xx);
        System.out.println(xx.emptyWeight);

        Ship myShip = new Ship(20, 20000, List.of(ContainerType.REEFER_CONTAINER, ContainerType.TANK_CONTAINER));
        System.out.println(myShip.getWeightCapacity());
        System.out.println(myShip.getAllowedContainerTypes());

        Container myContainer = new Container(ContainerType.TANK_CONTAINER, 300);
        System.out.println(myContainer.getId());
        System.out.println(myContainer.getContainerType());

        myShip.addContainer(myContainer);
        System.out.println(myShip.getContainerIDs());
        System.out.println(myShip.getContainers());
    }
}