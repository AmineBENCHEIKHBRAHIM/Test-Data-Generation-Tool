package classes;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.JobDetail;

public class OurCronSchedular implements ServletContextListener
{
            public static final String QUARTZ_FACTORY_KEY = "org.quartz.impl.StdSchedulerFactory.KEY";
    private ServletContext ctx = null;
    private StdSchedulerFactory factory = null;
   
      //Called when the container is shutting down.
    
    public void contextDestroyed(ServletContextEvent sce)
    {
         try
         {
              factory.getDefaultScheduler().shutdown();
         }
         catch (SchedulerException ex)
         {             
              System.out.println("error in Scheduling.java in contextInitialized() = "+ex);
         }
    }

    //Called when the container is first started.
    
    public void contextInitialized(ServletContextEvent sce)
    {
         ctx = sce.getServletContext();
         try
         {
             factory = new StdSchedulerFactory();             
             
             Scheduler sched=factory.getScheduler();
             JobDetail jd=new JobDetail("job1","group1",OurCronJob.class);
             CronTrigger ct=new CronTrigger("cronTrigger","group2","0 30 14 * * ?");
            sched.scheduleJob(jd,ct);
            sched.start();
             
              ctx.setAttribute(QUARTZ_FACTORY_KEY, factory);
        }
        catch (Exception ex)
        {             
              System.out.println("error in Scheduling.java in contextInitialized() = "+ex);
        }
    }
}
