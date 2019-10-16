import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class Node implements Info {
    private Info value;
    private Info parent;
    private List<InfoImpl> children;

    @Autowired
    public Node(@Qualifier("InfoImpl") Info value, @Qualifier("InfoImpl") Info parent, @Qualifier("InfoImpl") List<InfoImpl> children) {
        this.value = value;
        this.parent = parent;
        this.children = new LinkedList<>(children);
    }

    public Info getValue() {
        return value;
    }

    public void setValue(Info value) {
        this.value = value;
    }

    public Info getParent() {
        return parent;
    }

    public void setParent(Info parent) {
        this.parent = parent;
    }

    public List<InfoImpl> getChildren() {
        return new LinkedList<>(children);
    }

    public void setChildren(List<InfoImpl> children) {
        this.children = new LinkedList<>(children);
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
