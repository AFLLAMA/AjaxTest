package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class ContexListener implements ServletContextListener
{
    private static Logger LOGGER;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER = Logger.getLogger( ServletContextEvent.class.getName());
        LOGGER.log(Level.SEVERE, "This event: "+servletContextEvent.toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER = Logger.getLogger( ServletContextEvent.class.getName());
        LOGGER.log(Level.SEVERE, "This event: "+servletContextEvent.toString());
    }
}
