package com.jxsun.design.chainpattern;

/**
 * Created by sunjx on 2017/11/15.
 * 责任链模式
 * 顾名思义，责任模式链为请求创建一系列接收者对象。 此模式基于请求的类型将请求的发送方和接收方分离。 这种模式是行为模式。
 在这种模式中，通常每个接收器包含对另一个接收器的引用。如果一个对象不能处理请求，则它将相同的对象传递给下一个接收者等等。
 */
public class Run {

    public static void main(String[] args) {
        AbstractLogger logger = getLogger();
        logger.log(AbstractLogger.INFO , "info level");
        logger.log(AbstractLogger.DEBUG , "debug level");
        logger.log(AbstractLogger.ERROR , "error level");
    }

    private static AbstractLogger getLogger(){
        AbstractLogger info = new InfoLogger(AbstractLogger.INFO);
        AbstractLogger debug = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger error = new ErrorLogger(AbstractLogger.ERROR);

        info.setNext(debug);
        debug.setNext(error);
        return info;
    }
}
