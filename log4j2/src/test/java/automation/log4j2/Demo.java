package automation.log4j2;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.*;;

public class Demo {

	public static Logger log =  LogManager.getLogger(Demo.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();

		log.debug("debug message");
		log.error("error message");
		log.info("info message");
		log.fatal("fatal message");
	}

}
