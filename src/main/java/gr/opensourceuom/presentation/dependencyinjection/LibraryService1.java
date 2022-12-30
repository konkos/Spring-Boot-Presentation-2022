package gr.opensourceuom.presentation.dependencyinjection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "libraryService1")
public class LibraryService1 implements LibraryService {

    Logger logger = LoggerFactory.getLogger(LibraryService1.class);

    @Override
    public void showMsg() {
        logger.info("This is a Message From " + getClass().getName());
    }
}
