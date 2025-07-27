package org.example;

import java.util.concurrent.Callable;
 
public class FactorialThread implements Callable<Long>{
    private Long val;
    private Log logger;
    private Long mod=1000000007L;
    FactorialThread(Long i){
        this.val=i;
    }
    @Override
    public Long call(){
        logger=new LogImpl(Thread.currentThread().getName()+"-"+val);
        Long factValue=calculatefactorial(val, logger);
        logger.log("factValue is: "+factValue);
        return factValue;
    }

    public Long calculatefactorial(Long val, Log loggLog){
        if(val==0 || val==1)return val;
        else return (val*(calculatefactorial(val-1, loggLog)%mod))%mod;
    }
}