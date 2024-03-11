package creational.singleton;

import creational.singleton.EagerInitialization.EagerSingleton;
import creational.singleton.LazyInitialization.LazySingleton;
import creational.singleton.LazyInitialization.LazySingletonPlaceHolderIdiom;

public class Main {
    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton == eagerSingleton1);
        System.out.println(eagerSingleton + "," + eagerSingleton1 );
        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        System.out.println(lazySingleton == lazySingleton1);
        System.out.println(lazySingleton + "," + lazySingleton1);
        LazySingletonPlaceHolderIdiom lazySingletonIdiom = LazySingletonPlaceHolderIdiom.getInstance();
        LazySingletonPlaceHolderIdiom lazySingletonIdiom1 = LazySingletonPlaceHolderIdiom.getInstance();
        System.out.println(lazySingletonIdiom == lazySingletonIdiom1);
        System.out.println(lazySingletonIdiom + "," + lazySingletonIdiom1);
    }
}
