package cn.chaseshu.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Source - When a message is needed to be published it is done using Source.
 * The Source is an interface having a method annotated with @Output.
 * The @Output annotation is used to identify output channels.
 * The Source takes a POJO object, serializes it and then publishes it to the output channel.
 */
public interface EmployeeRegistrationSource {

	@Output("employeeRegistrationChannel")
	MessageChannel employeeRegistration();

}