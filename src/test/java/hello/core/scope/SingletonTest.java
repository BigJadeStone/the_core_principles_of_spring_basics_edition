package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @Test
    void singletonBeanFind () {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBeanbean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBeanbean2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBeanbean1 = " + singletonBeanbean1);
        System.out.println("singletonBeanbean2 = " + singletonBeanbean2);

        Assertions.assertThat(singletonBeanbean1).isSameAs(singletonBeanbean2);

        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean destroy");
        }
    }
}
