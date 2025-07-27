import java.util.concurrent.Callable;
 
public class FactorialThread implements Callable<Integer>{
    private Integer val;
    private Log logger;
    FactorialThread(Integer i){
        this.val=i;
    }
    @Override
    public Integer call(){
        logger=new LogImpl(Thread.currentThread().getName()+"-"+val);
        Integer factValue=calculatefactorial(val, logger);
        logger.log("factValue is: "+factValue);
        return factValue;
    }

    public Integer calculatefactorial(Integer val, Log loggLog){
        if(val==0 || val==1)return val;
        else return val*calculatefactorial(val-1, loggLog);
    }
}