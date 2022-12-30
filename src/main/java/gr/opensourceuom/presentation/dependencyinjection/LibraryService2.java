package gr.opensourceuom.presentation.dependencyinjection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "libraryService2")
public class LibraryService2 implements LibraryService{
    Logger logger = LoggerFactory.getLogger(LibraryService2.class);

    @Override
    public void showMsg() {
        logger.info("This is a Message From " + getClass().getName());
    }
}
