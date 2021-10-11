package cn.chaseshu.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;

public class MySpringEvent extends ApplicationEvent {
    
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param message 事件消息
     */
    public MySpringEvent(String message) {
        super(message);
    }
    
    @Override
    public String getSource() {
        return (String) super.getSource();
    }
    
    public String getMessage() {
        return getSource();
    }

}
