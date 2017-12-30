package com.rosettcompany.api.error.classes;

import lombok.Data;

@Data
public abstract class Detail {
	
	protected String title;
	protected int status;
	protected String detail;
	
	
}
