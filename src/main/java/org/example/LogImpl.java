package org.example;

public class LogImpl implements Log {
    private String threadName;
    LogImpl(String threadName){
        this.threadName=threadName;
    }

    @Override
    public void log(String message){
        String prefix=threadName+"-LOG-";
        System.out.println(prefix+" "+message);
    }
    @Override
    public void debug(String message){
        String prefix=threadName+"-LOG-";
        System.out.println(prefix+" "+message);
    }

    @Override
    public void error(String message){
        String prefix=threadName+"-LOG-";
        System.out.println(prefix+" "+message);
    }


}
