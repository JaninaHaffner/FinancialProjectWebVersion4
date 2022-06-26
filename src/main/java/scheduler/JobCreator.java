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

public class JobCreator {

    //private final Logger logger = Logger.getLogger(JobCreator.class);

    public void execute(JobExecutionContext jobExecutionContext) {

    }

    public String jobCreator(String username, String updates, String preference, String exchange, String symbols, String email) {
        int frequency = 0;
        String emailBody = "";
        String subject = "";

        try {
            switch (updates) {
                case "Daily":
                    frequency = 1;

                case "Weekly":
                    frequency = 7;

                case "Monthly":
                    frequency = 30;
            }

            switch (preference) {
                case "Email":
                    new ScreenShot().TakeScreenShot(exchange, symbols);
                    subject = "Financial Curation " + updates + " update email for " + username;

                case "Browser":
                    subject = "Financial Curation " + updates + " update.";
                    emailBody = "Please log in to your account to view your financial information.";

            }
        } catch (IOException exception) {
            return null;
        }
        return preference + "," + email + "," +  subject + "," +  emailBody + "," +  frequency;
    }

    public boolean jobScheduler(String preference, String email, String subject, String emailBody, int frequency) {
        String jobPref;
        String jobEmail;
        String jobSubject;
        String jobEmailBody;
        int jobFrequency;
        boolean jobCompleted;

        try {

            switch (frequency) {
                case 1:
                    jobCompleted = new SendEmail().sendMail(email, subject, preference, emailBody);
                    if (jobCompleted) {
                        jobPref = preference;
                        jobEmail = email;
                        jobSubject = subject;
                        jobEmailBody = emailBody;
                        jobFrequency = frequency;
                        wait(60 * 60 * 24 * 1000);
                        jobScheduler(jobPref, jobEmail, jobSubject, jobEmailBody, jobFrequency);
                    }
                case 7:
                    jobCompleted = new SendEmail().sendMail(email, subject, preference, emailBody);
                    if (jobCompleted) {
                        jobPref = preference;
                        jobEmail = email;
                        jobSubject = subject;
                        jobEmailBody = emailBody;
                        jobFrequency = frequency;
                        wait(60 * 60 * 24 * 7 * 1000);
                        jobScheduler(jobPref, jobEmail, jobSubject, jobEmailBody, jobFrequency);
                    }
                case 30:
                    jobCompleted = new SendEmail().sendMail(email, subject, preference, emailBody);
                    if (jobCompleted) {
                        jobPref = preference;
                        jobEmail = email;
                        jobSubject = subject;
                        jobEmailBody = emailBody;
                        jobFrequency = frequency;
                        wait(60L * 60 * 24 * 30 * 1000);
                        jobScheduler(jobPref, jobEmail, jobSubject, jobEmailBody, jobFrequency);
                    }
            }
        } catch (MessagingException | InterruptedException ignored) {
            return false;
        }
        return true;
    }
}

/*

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
    public void scheduler(){

    }
}
*/
