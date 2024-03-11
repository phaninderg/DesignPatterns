package creational.singleton.LazyInitialization;

public class LazySingletonPlaceHolderIdiom {

    private static class PlaceHolderIdiom {
        private static final LazySingletonPlaceHolderIdiom INSTANCE = new LazySingletonPlaceHolderIdiom();
    }
    private LazySingletonPlaceHolderIdiom(){ }

    public static LazySingletonPlaceHolderIdiom getInstance() {
        return PlaceHolderIdiom.INSTANCE;
    }
}
