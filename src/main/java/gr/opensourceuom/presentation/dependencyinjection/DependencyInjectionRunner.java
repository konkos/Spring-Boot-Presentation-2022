package gr.opensourceuom.presentation.dependencyinjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DependencyInjectionRunner implements CommandLineRunner {

    private final LibraryService libraryService;

    private final ApplicationContext applicationContext;

    public DependencyInjectionRunner(@Qualifier("libraryService1") LibraryService libraryService, ApplicationContext applicationContext) {
        this.libraryService = libraryService;
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        LibraryService1 libraryService1 = applicationContext.getBean("libraryService1", LibraryService1.class);
        LibraryService2 libraryService2 = applicationContext.getBean("libraryService2", LibraryService2.class);

        libraryService1.showMsg();
        libraryService2.showMsg();
    }
}
