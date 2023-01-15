import java.util.UUID;
import java.util.logging.*;

public class Container {
    private final ContainerType containerType;
    private final UUID id;
    private final int cargoWeight;
    private static final Logger LOGGER = LoggingUtil.configureContainerLogger(Container.class.getName());

    public Container(ContainerType containerType, int cargoWeight) {
        this.containerType = containerType;
        this.cargoWeight = cargoWeight;
        this.id = UUID.randomUUID();
        LOGGER.log(Level.INFO, "New container " + this.id + " initiated.");
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
