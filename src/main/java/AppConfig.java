import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// Аннотация @Configuration указывает, что это класс содержит все конфигурационные настройки для приложения
@Configuration
public class AppConfig {
    // создаем Bean c именем helloworld
    @Bean(name="helloworld")
    public HelloWorld getHelloWorld() {
        // инициализируем класс
        HelloWorld helloWorld = new HelloWorld();
        // через сеттер задаем значение поля объекта
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }
    // Создаем Bean с именем cat
    @Bean(name = "cat")
    // когда запрашивается экземпляр bean, будет создаваться новый экземпляр класса
    @Scope("prototype")
    public Cat getCat() {
        Cat cat = new Cat();
        return cat;
    }
}