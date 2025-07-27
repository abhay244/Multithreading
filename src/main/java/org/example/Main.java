package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Main {
    private static ThreadPoolManager threadPoolManager=new ThreadPoolManager();
    private  static Log logger;
    public static void main(String[] args) {

            logger=new LogImpl("MAIN");
            Long startTime=System.currentTimeMillis();
            threadPoolManager.initiateThreadPool(1,logger);//1-thread:7850 ms, 10-thread 2085ms
            List<Future<Long>>futureList=new ArrayList<>();
            for(Long i=1L;i<100000;i++){
                Future<Long> futureFactValue=threadPoolManager.submitTask(new FactorialThread(i));
                futureList.add(futureFactValue);
            }
            List<Long>result=threadPoolManager.processSubmittedTask(futureList);
            Long endTime=System.currentTimeMillis();
            Long timeTake=endTime-startTime;
            logger.log("result is: "+result);
            logger.log("time taken in milliSeconds: "+timeTake);

    }

   
}