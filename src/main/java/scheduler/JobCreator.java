package scheduler;

import email.ScreenShot;
import email.SendEmail;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import javax.mail.MessagingException;
import java.io.IOException;

/* JobCreator class is used to create a schedule to send user emails
 * to give user updates as per their specification on registration.
 * Use a switch case to set the frequency of the jobs and another
 * switch case to change the body of the email being sent to the user
 * to display appropriate information.
 * Set the job details, the triggers as per the frequency specified by the user
 * Start the jobs. */

public abstract class JobCreator implements Job {

    //private final Logger logger = Logger.getLogger(JobCreator.class);

    public void execute(JobExecutionContext jobExecutionContext) {

    }
    public static void jobCreator(String username, String updates, String preference, String exchange, String symbols, String email) {
        int frequency = 0;
        String emailBody = "";
        String subject = "";

        try {
            switch (updates) {
                case "Daily":
                    frequency = 24;

                case "Weekly":
                    frequency = 24 * 7;

                case "Monthly":
                    frequency = 24 * 30;
            }

            switch (preference) {
                case "Email":
                    new ScreenShot().TakeScreenShot(exchange, symbols);
                    subject = "Financial Curation " + updates + " update email for " + username;

                case "Browser":
                    subject = "Financial Curation " + updates + " update.";
                    emailBody = "Please log in to your account to view your financial information.";

            }

            JobDetail jobDetail = JobBuilder.newJob(new SendEmail().sendMail(email, subject, preference, emailBody)).withIdentity(username).build();

            Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(frequency).repeatForever()).build();

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (IOException | SchedulerException | MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
