import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.*;

public class Ship {
    final private int weightCapacity;
    final private int countCapacity;
    final private List<ContainerType> allowedContainerTypes;
    private int weight = 0;
    private int count = 0;
    private final ArrayList<Container> containers = new ArrayList<>();
    private final ArrayList<UUID> containerIDs = new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger(Ship.class.getName());

    static {
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler(Ship.class.getName());
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        fileHandler.setLevel(Level.FINE);
        LOGGER.addHandler(fileHandler);
    }
    public ArrayList<Container> getContainers() {
        return containers;
    }

    public ArrayList<UUID> getContainerIDs() {
        return containerIDs;
    }

    public Ship(int countCapacity, int weightCapacity, List<ContainerType> allowedContainerTypes) {
        this.weightCapacity = weightCapacity;
        this.countCapacity = countCapacity;
        this.allowedContainerTypes = allowedContainerTypes;
        LOGGER.log(Level.INFO, "New ship initiated");
    }

    public void addContainer(Container container) {
        if (this.getAllowedContainerTypes().contains(container.getContainerType())) {
            if (this.countCapacity > this.count) {
                if (this.weightCapacity > this.weight + container.getWeight()) {
                    this.count += 1;
                    this.weight += container.getWeight();
                    this.containerIDs.add(container.getId());
                    this.containers.add(container);
                } else {
                    System.out.println("case3");
                }
            } else {
                System.out.println("case2");
            }
        } else {
            LOGGER.log(Level.WARNING, "Container Type not allowed.");
        }
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public int getCountCapacity() {
        return countCapacity;
    }

    public List<ContainerType> getAllowedContainerTypes() {
        return allowedContainerTypes;
    }



}
