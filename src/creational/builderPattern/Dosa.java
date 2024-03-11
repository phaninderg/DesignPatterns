package creational.builderPattern;

public class Dosa {

    Batter batter;
    Size size;
    boolean usePaneer;
    boolean useCheese;
    boolean useMasala;
    boolean useKaram;
    boolean useButter;
    boolean needChutney;

    @Override
    public String toString() {
        return "Dosa{" +
                "batter=" + batter +
                ", size=" + size +
                ", usePaneer=" + usePaneer +
                ", useCheese=" + useCheese +
                ", useMasala=" + useMasala +
                ", useKaram=" + useKaram +
                ", useButter=" + useButter +
                ", needChutney=" + needChutney +
                ", needSambhar=" + needSambhar +
                '}';
    }

    boolean needSambhar;

    public Batter getBatter() {
        return batter;
    }

    private void setBatter(Batter batter) {
        this.batter = batter;
    }

    public Size getSize() {
        return size;
    }

    private void setSize(Size size) {
        this.size = size;
    }

    public boolean isUsePaneer() {
        return usePaneer;
    }

    private void setUsePaneer(boolean usePaneer) {
        this.usePaneer = usePaneer;
    }

    public boolean isUseCheese() {
        return useCheese;
    }

    private void setUseCheese(boolean useCheese) {
        this.useCheese = useCheese;
    }

    public boolean isUseMasala() {
        return useMasala;
    }

    private void setUseMasala(boolean useMasala) {
        this.useMasala = useMasala;
    }

    public boolean isUseKaram() {
        return useKaram;
    }

    private void setUseKaram(boolean useKaram) {
        this.useKaram = useKaram;
    }

    public boolean isUseButter() {
        return useButter;
    }

    private void setUseButter(boolean useButter) {
        this.useButter = useButter;
    }

    public boolean isNeedChutney() {
        return needChutney;
    }

    private void setNeedChutney(boolean needChutney) {
        this.needChutney = needChutney;
    }

    public boolean isNeedSambhar() {
        return needSambhar;
    }

    private void setNeedSambhar(boolean needSambhar) {
        this.needSambhar = needSambhar;
    }

    public static DosaBuilder getBuilder() {
        return new DosaBuilder();
    }
    public static class DosaBuilder {

        Dosa dosa;
        Batter batter;
        Size size;
        boolean usePaneer = false;
        boolean useCheese = false;
        boolean useMasala = false;
        boolean useKaram = false;
        boolean useButter = false;
        boolean needChutney = true;
        boolean needSambhar = true;
        public DosaBuilder withBatter(Batter batter) {
            this.batter = batter;
            return this;
        }
        public DosaBuilder Size(Size size) {
            this.size = size;
            return this;
        }

        public DosaBuilder withPaneer(boolean usePaneer) {
            this.usePaneer = usePaneer;
            return this;
        }

        public DosaBuilder withCheese(boolean useCheese) {
            this.useCheese = useCheese;
            return this;
        }

        public Dosa build(){
            this.dosa = new Dosa();
            dosa.setBatter(this.batter);
            dosa.setSize(this.size);
            dosa.setNeedChutney(this.needChutney);
            dosa.setNeedSambhar(this.needSambhar);
            dosa.setUsePaneer(this.usePaneer);
            dosa.setUseMasala(this.useMasala);
            dosa.setUseKaram(this.useKaram);
            dosa.setUseButter(this.useButter);
            dosa.setUsePaneer(this.usePaneer);
            return dosa;
        }

        public Dosa getDosa(){
            return this.dosa;
        }
    }
}
