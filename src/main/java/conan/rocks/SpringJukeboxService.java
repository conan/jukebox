package conan.rocks;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJukeboxService {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("conan.rocks");
        context.refresh();

        JukeboxService jukeboxService = context.getBean(JukeboxService.class);
        jukeboxService.run(args);
    }
}
