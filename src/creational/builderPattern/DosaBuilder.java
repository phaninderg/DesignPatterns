package creational.builderPattern;

public interface DosaBuilder {
    DosaBuilder withBatter(Batter batter);
    DosaBuilder withSize(Size size);

}
