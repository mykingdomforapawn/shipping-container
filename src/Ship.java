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
    private static final Logger LOGGER = LoggingUtil.configureShipLogger(Ship.class.getName());

    public ArrayList<UUID> getContainerIDs() {
        return containerIDs;
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public Ship(int countCapacity, int weightCapacity, List<ContainerType> allowedContainerTypes) {
        this.weightCapacity = weightCapacity;
        this.countCapacity = countCapacity;
        this.allowedContainerTypes = allowedContainerTypes;
        LOGGER.log(Level.INFO, "New ship initiated.");
    }

    public void addContainer(Container container) {
        if (this.allowedContainerTypes.contains(container.getContainerType())) {
            if (this.countCapacity > this.count) {
                if (this.weightCapacity > this.weight + container.getWeight()) {
                    if (!this.containerIDs.contains(container.getId())) {
                        this.count += 1;
                        this.weight += container.getWeight();
                        this.containerIDs.add(container.getId());
                        this.containers.add(container);
                        LOGGER.log(Level.INFO, "Container " + container.getId() + " added to ship.");
                    } else {
                        LOGGER.log(Level.INFO, "Container " + container.getId() + " can not be added because it is already on the ship.");
                    }
                } else {
                    LOGGER.log(Level.WARNING, "Container " + container.getId() + " can not be added due to weight capacity issues.");
                }
            } else {
                LOGGER.log(Level.WARNING, "Container " + container.getId() + " can not be added due to count capacity issues.");
            }
        } else {
            LOGGER.log(Level.WARNING, "Container Type " + container.getId() + " can not be added due to container type issues.");
        }
    }
}
