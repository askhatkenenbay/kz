import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.LinkedList;
import java.util.List;

public class NodeImmutable implements Info {
    private Info value;
    private Info parent;
    private List<Info> children;

    @Autowired
    public NodeImmutable(@Qualifier("InfoImpl") Info value, @Qualifier("InfoImpl") Info parent, @Qualifier("InfoImpl") List<Info> children) {
        this.value = value;
        this.parent = parent;
        this.children =  new LinkedList<>(children);
    }

    public Info getValue() {
        return value;
    }

    public Info getParent() {
        return parent;
    }

    public List<Info> getChildren() {
        return  new LinkedList<>(children);
    }

    @Override
    public void printInfo() {
        System.out.print("Current: ");
        value.printInfo();
        System.out.print("Parent: ");
        parent.printInfo();
        for (Info curr : children) {
            System.out.print("Children: ");
            curr.printInfo();
        }
    }
}
