import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ship {
    final private int weightCapacity;
    final private int countCapacity;
    final private List<ContainerType> allowedContainerTypes;
    private int weight = 0;
    private int count = 0;
    private final ArrayList<Container> containers = new ArrayList<>();
    private final ArrayList<UUID> containerIDs = new ArrayList<>();

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
            System.out.println("case1");
        }
    }
}
