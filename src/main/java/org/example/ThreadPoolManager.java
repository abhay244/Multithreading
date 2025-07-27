package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolManager {
            private static ExecutorService executorService;
            public void initiateThreadPool(int threadPoolSize, Log logger){
                executorService=Executors.newFixedThreadPool(threadPoolSize);
                logger.log("Initiating threadpool of size: "+threadPoolSize);
            }
           public  Future<Long>submitTask(Callable<Long> task){
            return executorService.submit(task);
           }
           List<Long>processSubmittedTask(List<Future<Long>> futureObjectList){
            List<Long>res=new ArrayList<>();
            try{
            for(Future<Long>futureObject:futureObjectList){
                if(futureObject.get()!=null){
                    res.add(futureObject.get());
                }
            }
            }catch(Exception e){
                e.printStackTrace();
            }

            return res;
           }

          
            public static void shutdown(){
                if(executorService != null){
                    executorService.shutdown();
                }
            }

           

    
}
