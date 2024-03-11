package creational.builderPattern;

public class Main {
    public static void main(String[] args) {
        Dosa dosa = directBuild(Dosa.getBuilder());
        System.out.println("Hello world!");
        System.out.println(dosa);
    }

    private static Dosa directBuild(Dosa.DosaBuilder builder) {
        return builder.withBatter(Batter.URADDAL)
                .Size(Size.MEDIUM)
                .withCheese(true)
                .withPaneer(true)
                .build();
    }
}