package br.tec.gtech.jobmanagement.jobrunrdemo;

import javax.annotation.PostConstruct;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.tec.gtech.jobmanagement.jobrunrdemo.service.SampleJobService;


@SpringBootApplication
public class JobrunrdemoApplication {

	private JobScheduler jobScheduler;

	public JobrunrdemoApplication(JobScheduler jobScheduler){
		this.jobScheduler = jobScheduler;
	}

	public static void main(String[] args) {
		SpringApplication.run(JobrunrdemoApplication.class, args);
	}

	@PostConstruct
    public void scheduleRecurrently() {
        jobScheduler.<SampleJobService>scheduleRecurrently(Cron.every30seconds(), x -> x.executeSampleJob("a recurring job"));
    }

}