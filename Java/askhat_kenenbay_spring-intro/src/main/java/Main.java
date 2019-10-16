import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Autowired
    @NodeAnnotation
    private static Node node;

    @Autowired
    @NodeImmutableAnnotation
    private static NodeImmutable nodeImmutable;

    private static final String LINE = "---------------------------------------";

    public static void main(String[] args) {
        System.out.println("with annotations");
        System.out.println(LINE);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        nodeImmutable = (NodeImmutable) ctx.getBean("nodeImmutableA");
        nodeImmutable.printInfo();
        System.out.println(LINE);
        node = (Node) ctx.getBean("nodeB");
        node.printInfo();
        System.out.println(LINE);
        node = (Node) ctx.getBean("nodeC");
        node.printInfo();
        System.out.println(LINE);
        node = (Node) ctx.getBean("nodeD");
        node.printInfo();
        System.out.println(LINE);
        node = (Node) ctx.getBean("nodeE");
        node.printInfo();
        System.out.println(LINE);
        System.out.println("with xml file");
        System.out.println(LINE);
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring_file.xml");
        nodeImmutable = (NodeImmutable) context.getBean("nodeA");
        nodeImmutable.printInfo();
        System.out.println(LINE);
        node = (Node) context.getBean("nodeB");
        node.printInfo();
        System.out.println(LINE);
        node = (Node) context.getBean("nodeC");
        node.printInfo();
        System.out.println(LINE);
        node = (Node) context.getBean("nodeD");
        node.printInfo();
        System.out.println(LINE);
        node = (Node) context.getBean("nodeE");
        node.printInfo();
        System.out.println(LINE);

        context.close();

    }
}
