package com.fs.quartz.corn;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;

public class CornJobTest {
    public static void main(String[] args) throws SchedulerException {
//jobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("cronJob").build();
        JobDetail jobDetail1 = JobBuilder.newJob(HelloJob.class).withIdentity("cronJob1").build();
        //cronTrigger
        //每日的9点40触发任务
        CronTrigger cronTrigger1 = TriggerBuilder.newTrigger().withIdentity("cronJob")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
        CronTrigger cronTrigger2 = TriggerBuilder.newTrigger().withIdentity("cronJob1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/6 * * * * ?")).build();
        System.out.println(cronTrigger1.getFireTimeAfter(new Date()));
        //1.每日10点15分触发      0 15 10 ？* *
        //2.每天下午的2点到2点59分（正点开始，隔5分触发）       0 0/5 14 * * ?
        //3.从周一到周五每天的上午10点15触发      0 15 10 ? MON-FRI
        //4.每月的第三周的星期五上午10点15触发     0 15 10 ? * 6#3
        //5.2016到2017年每月最后一周的星期五的10点15分触发   0 15 10 ? * 6L 2016-2017
        //Scheduler实例
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,cronTrigger1);
//        scheduler.addJob();
        //Scheduler scheduler1 = stdSchedulerFactory.getScheduler();
        //scheduler1.start();
        scheduler.scheduleJob(jobDetail1,cronTrigger2);
        System.out.println("aaa");
        Date date = new Date();
        for (int i = 0;i<10;i++){
            date=cronTrigger1.getFireTimeAfter(date);
            System.out.println(date);
        }
        try {
            Thread.sleep(1000*15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JobKey jobKey = new JobKey("cronJob");
//        TriggerKey triggerKey = new TriggerKey("cronJob");
//        scheduler.getJobDetail(jobKey);
        scheduler.deleteJob(jobKey);
        try {
            Thread.sleep(1000*15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jobKey = new JobKey("cronJob1");
//        TriggerKey triggerKey = new TriggerKey("cronJob");
//        scheduler.getJobDetail(jobKey);
        scheduler.deleteJob(jobKey);
    }

    public static class HelloJob implements Job {
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            //打印当前的执行时间 例如 2017-11-22 00:00:00
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("现在的时间是："+ sf.format(date));
            //具体的业务逻辑
            System.out.println("开始生成任务报表 或 开始发送邮件");
        }


    }
}
