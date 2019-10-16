import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class Config {
    @Bean
    public Node nodeA(@Value("A") String value, @Value("None") String parent,
                      @Value("B") String childOne, @Value("C") String childTwo) {
        return new Node(new InfoImpl(value), new InfoImpl(parent), Arrays.asList(new InfoImpl(childOne), new InfoImpl(childTwo)));
    }

    @Bean
    public NodeImmutable nodeImmutableA(@Value("A") String value, @Value("None") String parent,
                                        @Value("B") String childOne, @Value("C") String childTwo) {
        return new NodeImmutable(new InfoImpl(value), new InfoImpl(parent), Arrays.asList(new InfoImpl(childOne), new InfoImpl(childTwo)));
    }

    @Bean
    public Node nodeB(@Value("B") String value, @Value("A") String parent) {
        return new Node(new InfoImpl(value), new InfoImpl(parent), Arrays.asList());
    }

    @Bean
    public Node nodeC(@Value("C") String value, @Value("A") String parent,
                      @Value("D") String childOne, @Value("E") String childTwo) {
        return new Node(new InfoImpl(value), new InfoImpl(parent), Arrays.asList(new InfoImpl(childOne), new InfoImpl(childTwo)));
    }

    @Bean
    public Node nodeD(@Value("D") String value, @Value("C") String parent) {
        return new Node(new InfoImpl(value), new InfoImpl(parent), Arrays.asList());
    }

    @Bean
    public Node nodeE(@Value("E") String value, @Value("C") String parent) {
        return new Node(new InfoImpl(value), new InfoImpl(parent), Arrays.asList());
    }
}
