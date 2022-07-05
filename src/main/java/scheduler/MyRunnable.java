package scheduler;

import org.quartz.SchedulerConfigException;

public class MyRunnable implements Runnable {

    private final String userName;
    private final String upDates;
    private final String prefeRence;
    private final String exChange;
    private final String symBols;
    private final String eMail;

    /* Constructor to create new thread.
     * Call to JobCreator to create the job
     * Call to jobScheduler to schedule the job
     */
    public MyRunnable(String username, String updates, String preference, String exchange, String symbols, String email) throws SchedulerConfigException {

        this.userName = username;
        this.upDates = updates;
        this.prefeRence = preference;
        this.exChange = exchange;
        this.symBols = symbols;
        this.eMail = email;

    }
    @Override
    public void run() {

        String createJob;
        try {
            createJob = new JobCreator().jobCreator(userName, upDates, prefeRence, exChange, symBols, eMail);
        } catch (SchedulerConfigException e) {
            throw new RuntimeException(e);
        }

        String[] jobInfo;
        jobInfo = createJob.split(",");
        String jobPref = jobInfo[0];
        String jobEmail = jobInfo[1];
        String jobSubject = jobInfo[2];
        String jobEmailBody = jobInfo[3];
        int jobFrequency = Integer.parseInt(jobInfo[4]);

        new JobCreator().jobScheduler(jobPref, jobEmail, jobSubject, jobEmailBody, jobFrequency);
    }
}
