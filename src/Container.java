import java.util.UUID;

public class Container {
    private final ContainerType containerType;
    private final UUID id;
    private final int cargoWeight;

    public Container(ContainerType containerType, int cargoWeight) {
        this.containerType = containerType;
        this.cargoWeight = cargoWeight;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public ContainerType getContainerType() {
        return containerType;
    }

    public int getWeight() {
        return this.cargoWeight + this.containerType.emptyWeight;
    }
}
