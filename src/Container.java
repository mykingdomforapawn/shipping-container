import java.io.IOException;
import java.util.UUID;
import java.util.logging.*;

public class Container {
    private final ContainerType containerType;
    private final UUID id;
    private final int cargoWeight;
    private static final Logger LOGGER = Logger.getLogger(Container.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("logs/" + Container.class.getName() + ".log");
            fileHandler.setLevel(Level.INFO);
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

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
