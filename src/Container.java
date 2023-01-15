import java.util.UUID;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Container {
    private final ContainerType containerType;
    private final UUID id;
    private final int cargoWeight;
    //private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    static {
        //ConsoleHandler consoleHandler = new ConsoleHandler();
        //LOGGER.addHandler(consoleHandler);

    }
    public Container(ContainerType containerType, int cargoWeight) {
        this.containerType = containerType;
        this.cargoWeight = cargoWeight;
        this.id = UUID.randomUUID();
        //LOGGER.logp(Level.INFO, Container.class.getName(), "Constructor", "New container with id " + this.id + " initiated");
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
