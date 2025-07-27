package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Main {
    private static ThreadPoolManager threadPoolManager=new ThreadPoolManager();
    private  static Log logger;
    public static void main(String[] args) {

            logger=new LogImpl("MAIN");
            threadPoolManager.initiateThreadPool(10,logger);
            List<Integer>factorials=new ArrayList<>();
            List<Future<Integer>>futureList=new ArrayList<>();
            for(int i=1;i<50;i++){
                Future<Integer> futureFactValue=threadPoolManager.submitTask(new FactorialThread(i));
                futureList.add(futureFactValue);
            }
            List<Integer>result=threadPoolManager.processSubmittedTask(futureList);
            logger.log("result is: "+result);

    }

   
}