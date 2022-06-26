package scheduler;

import org.quartz.SchedulerConfigException;

public class MyRunnable implements Runnable {

    /* Constructor to create new thread.
     * Call to JobCreator to create the job
     * Call to jobScheduler to schedule the job
     */
    public MyRunnable(String username, String updates, String preference, String exchange, String symbols, String email) throws SchedulerConfigException {

        String createJob = new JobCreator().jobCreator(username, updates, preference, exchange, symbols, email);
        String[] jobInfo;
        jobInfo = createJob.split(",");
        String jobPref = jobInfo[0];
        String jobEmail = jobInfo[1];
        String jobSubject = jobInfo[2];
        String jobEmailBody = jobInfo[3];
        int jobFrequency = Integer.parseInt(jobInfo[4]);

        new JobCreator().jobScheduler(jobPref, jobEmail, jobSubject, jobEmailBody, jobFrequency);
    }
    public void run() {

    }
}
