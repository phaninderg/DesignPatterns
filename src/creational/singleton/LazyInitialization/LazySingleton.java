package creational.singleton.LazyInitialization;

public class LazySingleton {
    private static volatile LazySingleton INSTANCE; //volatile to avoid cache

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if(INSTANCE == null){
            synchronized(LazySingleton.class) {
                // second check to avoid new instance creation
                // since other thread will be waiting at synchronized instruction
                if (INSTANCE == null) {
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}
