public enum ContainerType {
    OPEN_TOP_CONTAINER (2000),
    TANK_CONTAINER (3000),
    REEFER_CONTAINER (5000);

    public final int emptyWeight;
    ContainerType(int emptyWeight) {
        this.emptyWeight = emptyWeight;
    }
}
