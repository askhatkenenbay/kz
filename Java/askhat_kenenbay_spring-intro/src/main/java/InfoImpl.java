public class InfoImpl implements Info {
    private String name;

    public InfoImpl(String name) {
        this.name = name;
    }

    @Override
    public void printInfo() {
        System.out.println(name);
    }
}
