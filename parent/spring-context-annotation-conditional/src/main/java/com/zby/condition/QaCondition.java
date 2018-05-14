package com.zby.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class QaCondition implements Condition {

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		if (context.getEnvironment() != null) {
			if (context.getEnvironment().acceptsProfiles("qa")) {
				return true;
			}
			return false;
		}
		return true;
	}

}
