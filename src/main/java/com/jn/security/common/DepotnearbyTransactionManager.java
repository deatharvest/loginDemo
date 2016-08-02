package com.jn.security.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

import java.util.ArrayList;
import java.util.List;


public class DepotnearbyTransactionManager extends JpaTransactionManager
    implements ApplicationEventPublisherAware {

    private static final Logger logger =
        LoggerFactory.getLogger(DepotnearbyTransactionManager.class);


    protected static ApplicationEventPublisher applicationEventPublisher;

    public static final ThreadLocal<List<ApplicationEvent>> events =
        new ThreadLocal<List<ApplicationEvent>>();
    public static final ThreadLocal<Boolean> inTransactions = new ThreadLocal<Boolean>();

    public DepotnearbyTransactionManager() {
        super();
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    protected void doBegin(Object transaction, TransactionDefinition definition) {
        super.doBegin(transaction, definition);
        inTransactions.set(true);
    }

    protected void doCommit(DefaultTransactionStatus status) {
        super.doCommit(status);
        List<ApplicationEvent> list = events.get();
        if (list != null && !list.isEmpty()) {
            boolean isDebugEnabled = logger.isDebugEnabled();
            for (ApplicationEvent event : list) {
                if (isDebugEnabled) {
                    logger.debug("applicationEventPublisher.publishEvent {}, hashcode {},ts {}",
                        event.getClass().getCanonicalName(), event.hashCode(),
                        event.getTimestamp());
                }
                applicationEventPublisher.publishEvent(event);
            }
            list.clear();
        }
        inTransactions.set(false);
    }

    protected void doRollback(DefaultTransactionStatus status) {
        super.doRollback(status);
        List<ApplicationEvent> list = events.get();
        if (list != null && !list.isEmpty()) {
            if (logger.isDebugEnabled()) {
                logger.debug("rooback && clear event");
            }
            list.clear();
        }
        inTransactions.set(false);
    }


    public static void publishEvent(ApplicationEvent event) {
        Boolean transFlag = inTransactions.get();
        if (transFlag != null && transFlag.booleanValue()) {
            List<ApplicationEvent> list = events.get();
            if (list == null) {
                list = new ArrayList<ApplicationEvent>();
                events.set(list);
            }
            if (logger.isDebugEnabled()) {
                logger.debug("thread is in Transcation send push envet to list");
            }
            list.add(event);
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug(
                    "thread is not in Transcation send event now! applicationEventPublisher is : {} event is:{} ",
                    applicationEventPublisher, event);
            }
            applicationEventPublisher.publishEvent(event);
        }
    }
}
