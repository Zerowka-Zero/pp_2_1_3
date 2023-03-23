import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// Главный класс собственно
public class App {
    public static void main(String[] args) {
        // Создаем интерфейс ApplicationContext он является основным интерфейсом
        // доступа к IoC Container Spring где и хранятся все bean(singleton), а prototype вызываются
        // и сразу выбрасываются и не хранятся в контейнере
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        // создаем bean`s HelloWorld
        HelloWorld bean1 = applicationContext.getBean("helloworld", HelloWorld.class);
        HelloWorld bean2 = applicationContext.getBean("helloworld", HelloWorld.class);
        // создаем bean`s Cat
        Cat cat1 = applicationContext.getBean("cat", Cat.class);
        Cat cat2 = applicationContext.getBean("cat", Cat.class);
        // bean1 and bean2 создаются на основе одного и того же объекта, поэтому ссылки у них одинаковые
        // по сути это один и тот же объект
        System.out.println(bean1 == bean2);
        // сравниваем ссылки, так как cat1 and cat2 находятся в IoC контейнере,
        // то у них соответственно разные ссылки
        System.out.println(cat1 == cat2);
    }
}